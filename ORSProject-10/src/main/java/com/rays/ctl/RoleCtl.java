package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.RoleDto;
import com.rays.form.RoleForm;
import com.rays.service.RoleServiceInt;

@RestController
@RequestMapping(value = "Role")
public class RoleCtl extends BaseCtl<RoleForm, RoleDto, RoleServiceInt> {
	
	@GetMapping("preload")
	public ORSResponse preload() {
		
		ORSResponse res = new ORSResponse();
		
		RoleDto dto = new RoleDto();
		//dto.setStatus(RoleDto.ACTIVE);	
		List<DropdownList> list = baseService.search(dto, userContext);
		res.addResult("roleList", list);
		return res;
		
	}

}
