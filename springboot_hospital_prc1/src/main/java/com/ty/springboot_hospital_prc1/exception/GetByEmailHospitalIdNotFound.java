package com.ty.springboot_hospital_prc1.exception;

public class GetByEmailHospitalIdNotFound extends Exception {
private String message="email is wrong to get";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public GetByEmailHospitalIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	public GetByEmailHospitalIdNotFound( ) {
		
	}
}
