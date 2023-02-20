package com.ty.springboot_hospital_prc1.exception;

public class GetByCityAddressIdNotFound extends Exception {
	private String message="city is wrong";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public GetByCityAddressIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	public GetByCityAddressIdNotFound( ) {
		
	}
}
