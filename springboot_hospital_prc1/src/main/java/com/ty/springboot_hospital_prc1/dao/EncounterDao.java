package com.ty.springboot_hospital_prc1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_prc1.dto.Encounter;
import com.ty.springboot_hospital_prc1.repository.EncounterRepository;

@Repository
public class EncounterDao {
	@Autowired
	private EncounterRepository repository;
	
	public Encounter saveEncouter(Encounter encounter) {
		return repository.save(encounter);
	}

	public Encounter getById(int encounterid) {
		// TODO Auto-generated method stub
		return repository.findById(encounterid).get();
	}

	public Encounter updateEncounter(Encounter encounter, int encounterid ) {
	 if(repository.findById(encounterid).isPresent()) {
		 encounter.setId(encounterid);
		 return repository.save(encounter);
	 }
		return null;
	}public Encounter deleteEncounter(  int encounterid ) {
		Encounter encounter=repository.findById(encounterid).get();
		 if(repository.findById(encounterid).isPresent()) {
			 repository.deleteById(encounterid);
			 return  encounter;
		 }
			return null;
		}
	
}
