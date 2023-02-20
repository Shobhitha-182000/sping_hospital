package com.ty.springboot_hospital_prc1.exception;

public class UpdateBranchIdNotFound extends Exception {
	private String message="id is wrong to update";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UpdateBranchIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	public UpdateBranchIdNotFound( ) {
		
	}
}
