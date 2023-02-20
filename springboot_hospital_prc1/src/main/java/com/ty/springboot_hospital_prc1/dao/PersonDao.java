package com.ty.springboot_hospital_prc1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_prc1.dto.Person;
import com.ty.springboot_hospital_prc1.repository.PersonRespository;

@Repository
public class PersonDao {
	@Autowired
	private PersonRespository repo;
	
	public Person savePerson(Person person) {
		return repo.save(person);
	}
	public Person updatePerson(int id,Person person) {
		if(repo.findById(id).isPresent()) {
			person.setId(id);
			return repo.save(person);
		}
		else {
			return null;
		}
	}
	public Person deletePerson(int id) {
		Person person=repo.findById(id).get();
		if(repo.findById(id).isPresent()) {
			 repo.delete(person);
			return person;
		}
		else {
			return null;
		}
	}
	
	public Person getById(int id) {
		if(repo.findById(id).isPresent()) {
			Person person=repo.findById(id).get();
			return  person;
		}
		else {
			return null;
		}
	}
}
