package com.ty.springboot_hospital_prc1.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

 
public class IdNotFound extends RuntimeException {

	private String message="id not found";
	
	public IdNotFound() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IdNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public IdNotFound(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IdNotFound(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public IdNotFound(String message) {
		super();
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	
	

}
