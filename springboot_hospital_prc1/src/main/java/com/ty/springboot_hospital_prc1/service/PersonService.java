package com.ty.springboot_hospital_prc1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_prc1.dao.PersonDao;
import com.ty.springboot_hospital_prc1.dto.Address;
import com.ty.springboot_hospital_prc1.dto.Person;
import com.ty.springboot_hospital_prc1.exception.IdNotFound;
import com.ty.springboot_hospital_prc1.util.ResponseStructure;

@Service
public class PersonService {
	@Autowired
	private PersonDao dao;
	
	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person){
		ResponseStructure structure=new ResponseStructure();
		structure.setMessage("successively saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.savePerson(person));
		return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Person>> updatePerson(int id,Person person){
		ResponseStructure structure=new ResponseStructure();
		if(person!=null) {
			structure.setMessage("Successesively updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData( dao.updatePerson(id, person));
			return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new IdNotFound();
		}
	}
	public ResponseEntity<ResponseStructure<Person>> deletePerson(int id){
		ResponseStructure structure=new ResponseStructure();
		Person	 person=dao.deletePerson(id);
		if(person!=null) {
			structure.setMessage("Successesively deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new IdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Person>> getById(int id){
		ResponseStructure<Person> structure=new ResponseStructure<Person>();
		Person person=dao.getById(id);
		if(person!=null) {
			structure.setMessage("Successesively found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new IdNotFound();
		}
	}
	
	
	
	
	
	
	
	
	
}
