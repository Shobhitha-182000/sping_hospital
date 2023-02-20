package com.ty.springboot_hospital_prc1.exception;

public class UpdateAddressIdNotFound extends Exception {
	private String message="pincode is wrong to update";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UpdateAddressIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	public UpdateAddressIdNotFound( ) {
		
	}

	 
}
