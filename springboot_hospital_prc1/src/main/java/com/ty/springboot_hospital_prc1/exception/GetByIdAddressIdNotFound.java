package com.ty.springboot_hospital_prc1.exception;

public class GetByIdAddressIdNotFound extends Exception {
	private String message="pincode is wrong ";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public GetByIdAddressIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	public GetByIdAddressIdNotFound( ) {
		
	}
}
