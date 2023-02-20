package com.ty.springboot_hospital_prc1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_prc1.dao.BranchDao;
import com.ty.springboot_hospital_prc1.dao.EncounterDao;
import com.ty.springboot_hospital_prc1.dao.PersonDao;
import com.ty.springboot_hospital_prc1.dto.Address;
import com.ty.springboot_hospital_prc1.dto.Branch;
import com.ty.springboot_hospital_prc1.dto.Encounter;
import com.ty.springboot_hospital_prc1.dto.Hospital;
import com.ty.springboot_hospital_prc1.dto.Person;
import com.ty.springboot_hospital_prc1.exception.DeleteEncounterIdNotFound;
import com.ty.springboot_hospital_prc1.exception.GetByIdEncounterIdNotFound;
import com.ty.springboot_hospital_prc1.exception.IdNotFound;
import com.ty.springboot_hospital_prc1.util.ResponseStructure;

@Service
public class EncounterService {
	@Autowired
	private EncounterDao encounterDao;
	@Autowired
	private PersonDao personDao;
	@Autowired
	private BranchDao branchDao;
	
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter,int pid,int bid){
		Person person=personDao.getById(pid);
		Branch branch=branchDao.getById(bid);
		encounter.setPerson(person);
		List<Branch> list=new ArrayList<Branch>();
		list.add(branch);
		encounter.setBranchs(list);
		ResponseStructure<Encounter> structure=new ResponseStructure<Encounter>();
		structure.setMessage("successively saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(encounterDao.saveEncouter(encounter));
		return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter encounter, int encounterid,
			int branchid) {
		Encounter encounter2=encounterDao.getById(encounterid);
		Branch branch=branchDao.getById(branchid);
		
		List<Branch> list=encounter.getBranchs();
		list.add(branch);
		encounter2.setBranchs(list);
		encounter2.setPerson(encounter2.getPerson());
		ResponseStructure<Encounter> structure=new ResponseStructure<Encounter>();
		structure.setMessage("successively saved");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(encounterDao.updateEncounter(  encounter,   encounterid));
		return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int eid) throws DeleteEncounterIdNotFound{
		ResponseStructure<Encounter> structure=new ResponseStructure<Encounter>();
		Encounter encounter=encounterDao.deleteEncounter(eid);
		if(encounter!=null) {
			structure.setMessage("successfully Branch is deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new DeleteEncounterIdNotFound()  ;
		}
	}
	public ResponseEntity<ResponseStructure<Encounter>> getById(int id) throws GetByIdEncounterIdNotFound {
		ResponseStructure<Encounter> structure=new ResponseStructure<Encounter>();
		Encounter encounter2=encounterDao.getById(id);
		if(encounter2!=null) {
			structure.setMessage("successfully Branch is found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(encounterDao.getById(id));
			return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new GetByIdEncounterIdNotFound()  ;
		}
	}
}
