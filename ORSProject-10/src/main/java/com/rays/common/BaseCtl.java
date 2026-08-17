package com.rays.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.dto.UserDto;

public class BaseCtl<F extends BaseForm, T extends BaseDto, S extends BaseServiceInt<T>> {

	@Autowired
	protected S baseService;

	@Value("${page.size}")
	private int pageSize = 0;

	protected UserContext userContext = null;

	@ModelAttribute
	public void setUserContext(HttpSession session) {
		userContext = (UserContext) session.getAttribute("userContext");
		if (userContext == null) {
			UserDto dto = new UserDto();
			dto.setLoginId("root@sunilos.com");
			userContext = new UserContext(dto);
		}
	}

	public ORSResponse validate(BindingResult bindingResult) {

		ORSResponse res = new ORSResponse(true);

		if (bindingResult.hasErrors()) {

			res.setSuccess(false);

			Map<String, String> errors = new HashMap<String, String>();

			List<FieldError> list = bindingResult.getFieldErrors();
			list.forEach(e -> {
				errors.put(e.getField(), e.getDefaultMessage());
			});
			res.addInputError(errors);
		}
		return res;
	}

	@PostMapping("/save")
	public ORSResponse save(@RequestBody @Valid F form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (res.isSuccess() == false) {
			return res;
		}

		try {
			T dto = (T) form.getDto();

			if (dto.getId() != null && dto.getId() > 0) {
				T existDto1 = (T) baseService.findByUniqueKey(dto.getUniqueKey(), dto.getUniqueValue(), userContext);
				if (existDto1 != null && dto.getId() != existDto1.getId()) {
					res.setSuccess(false);
					res.addMessage(dto.getLabel() + " already exist");
					return res;
				}
				baseService.update(dto, userContext);
				res.addData(dto.getId());
				res.addMessage(dto.getTableName() + " updated successfully..!!");
			} else {
				if (dto.getUniqueKey() != null && !dto.getUniqueKey().equals("")) {
					T existDto = (T) baseService.findByUniqueKey(dto.getUniqueKey(), dto.getUniqueValue(), userContext);
					if (existDto != null) {
						res.setSuccess(false);
						res.addMessage(dto.getLabel() + " already exist");
						return res;
					}
				}
				baseService.add(dto, userContext);
				res.addMessage(dto.getTableName() + " added successfully..!!");
			}
		} catch (Exception e) {
			res.setSuccess(false);
			res.addMessage(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable long id) {
		ORSResponse res = new ORSResponse(true);
		T dto = baseService.findById(id, userContext);
		if (dto != null) {
			res.addData(dto);
		} else {
			res.setSuccess(false);
			res.addMessage("Record not found");
		}
		return res;
	}

	@PostMapping("deleteMany/{ids}")
	public ORSResponse deleteMany(@PathVariable String[] ids, @RequestParam("pageNo") String pageNo,
			@RequestBody F form) {

		ORSResponse res = new ORSResponse(true);
		try {
			for (String id : ids) {
				baseService.delete(Long.parseLong(id), userContext);
			}
			
			T dto = (T) form.getDto();

			List<T> list = baseService.search(dto, Integer.parseInt(pageNo), pageSize, userContext);

			List<T> nextList = baseService.search(dto, Integer.parseInt(pageNo + 1), pageSize, userContext);

			if (list.size() == 0) {
				res.setSuccess(false);
				res.addMessage("Record not found..!!");
			} else {
				res.setSuccess(true);
				res.addMessage("Records Deleted Successfully");
				res.addData(list);
				res.addResult("nextListSize", nextList.size());
			}
		} catch (Exception e) {
			res.setSuccess(false);
			res.addMessage(e.getMessage());
		}
		return res;
	}

	@RequestMapping(value = "/search/{pageNo}", method = { RequestMethod.GET, RequestMethod.POST })
	public ORSResponse search(@RequestBody F form, @PathVariable int pageNo) {

		pageNo = (pageNo < 0) ? 0 : pageNo;

		T dto = (T) form.getDto();

		ORSResponse res = new ORSResponse(true);

		List<T> list = baseService.search(dto, pageNo, pageSize, userContext);

		List<T> nextList = baseService.search(dto, pageNo + 1, pageSize, userContext);

		if (list.size() == 0) {
			res.setSuccess(false);
			res.addMessage("Record not found..!!");
		} else {
			res.setSuccess(true);
			res.addData(list);
			res.addResult("nextListSize", nextList.size());
		}
		return res;
	}
}