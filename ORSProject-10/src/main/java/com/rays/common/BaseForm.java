package com.rays.common;

public class BaseForm {
	
	protected Long id;
	
	protected String createdBy;
	
	protected String modifiedBy;
	
	protected long createdDatetime;
	
	protected long modifiedDatetime;
	
	private Long[] ids;

	private int pageNo = 0;

	private int pageSize = 5;

	private String operation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
		public BaseDto getDto() {
			return null;
		}
	
		public <T extends BaseDto> T initDto(T dto) {
			System.out.println("id => base dto => " + id);
			if (id != null && id > 0) {
				dto.setId(id);
			} else {
				dto.setId(null);
			}
			return dto;
			
		}
	
	
	
	

}
