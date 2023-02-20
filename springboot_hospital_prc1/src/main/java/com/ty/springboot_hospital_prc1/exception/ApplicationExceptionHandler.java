package com.ty.springboot_hospital_prc1.exception;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map;
import java.util.List;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.springboot_hospital_prc1.util.ResponseStructure;

import io.swagger.models.Response;

@ControllerAdvice
public class ApplicationExceptionHandler<ViolationReport> extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFound(IdNotFound ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("id not found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElement(NoSuchElementException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("id not found in the element");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> errors=ex.getAllErrors();
		Map<String, String> map=new  LinkedHashMap<String,String>();
		for(ObjectError er:errors) {
			String fieldName=((FieldError)er).getField();
			String message=((FieldError)er).getDefaultMessage();
			
			map.put(fieldName, message);
		}
		return  new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
	}
 
	@ExceptionHandler({ConstraintViolationException.class})
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exp, WebRequest request){
	
		List<String> errors=new ArrayList<String>();
		
		//Set<ConstraintViolation<?>> violations=exp.getConstraintViolations();
		
		//ConstraintViolation<?> violation= violations.iterator().next();
			//
		//String message=violation.getMessage();
		for(ConstraintViolation<?> violation:exp.getConstraintViolations()) {
			errors.add(violation.getMessage());
		}
		
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
}
