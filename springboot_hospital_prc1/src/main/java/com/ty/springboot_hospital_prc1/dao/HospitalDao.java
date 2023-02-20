

package com.ty.springboot_hospital_prc1.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_prc1.dto.Hospital;
import com.ty.springboot_hospital_prc1.repository.HospitalRepository;

@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepository repo;
	
	public Hospital saveHospital(Hospital hospital) {
		return repo.save(hospital);
	}
	
	public Hospital updateHospital(int id,Hospital hospital) {
		if(repo.findById(id).isPresent()) {
			hospital.setId(id);
			return  repo.save(hospital);
		}
		else {
			return null;
		}
	}
	
	public Hospital deletHospital(int id) {
		Hospital hospital=repo.findById(id).get();
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return  hospital;
		}
		else {
			return null;
		}
	}
	
	public Hospital getById(int id) {
		 
		if(repo.findById(id).isPresent()) {
			Hospital hospital=repo.findById(id).get();
			return  hospital;
		}
		else {
			return null;
		}
	}
	
	public List<Hospital> getAll() {
		return repo.findAll();
	}
	
	public Hospital getByEmail(String email) {
		Hospital hospital=repo.getByEmail(email);
		return hospital;
	}
}
