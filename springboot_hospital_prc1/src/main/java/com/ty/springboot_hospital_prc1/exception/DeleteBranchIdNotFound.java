package com.ty.springboot_hospital_prc1.exception;

public class DeleteBranchIdNotFound extends Exception {
	private String message="pincode is wrong to delete";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DeleteBranchIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	public DeleteBranchIdNotFound( ) {
		
	}
}
