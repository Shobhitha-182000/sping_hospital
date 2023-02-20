package com.ty.springboot_hospital_prc1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_prc1.dao.HospitalDao;
import com.ty.springboot_hospital_prc1.dto.Hospital;
import com.ty.springboot_hospital_prc1.exception.DeleteHospitalIdNotFound;
import com.ty.springboot_hospital_prc1.exception.GetByEmailHospitalIdNotFound;
import com.ty.springboot_hospital_prc1.exception.GetByIdHospitalIdNotFound;
import com.ty.springboot_hospital_prc1.exception.IdNotFound;
import com.ty.springboot_hospital_prc1.exception.UpdateHospitalIdNotFound;
import com.ty.springboot_hospital_prc1.util.ResponseStructure;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao dao;
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital){
		ResponseStructure structure=new ResponseStructure();
		structure.setMessage("successively saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveHospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id,Hospital hospital) throws UpdateHospitalIdNotFound{
		ResponseStructure structure=new ResponseStructure();
		if(hospital!=null) {
			structure.setMessage("Successesively updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateHospital(id, hospital));
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new UpdateHospitalIdNotFound();
		}
	}
	public ResponseEntity<ResponseStructure<Hospital>> deletHospital(int id) throws DeleteHospitalIdNotFound{
		ResponseStructure structure=new ResponseStructure();
		Hospital hospital=dao.deletHospital(id);
		if(hospital!=null) {
			structure.setMessage("Successesively delete");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deletHospital(id));
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new DeleteHospitalIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> getById(int id) throws GetByIdHospitalIdNotFound{
		ResponseStructure structure=new ResponseStructure();
		Hospital hospital=dao.getById(id);
		if(hospital!=null) {
			structure.setMessage("Successesively found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.getById(id));
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new GetByIdHospitalIdNotFound();
		}
	}
	public ResponseEntity<ResponseStructure<Hospital>> getByEmail(String email) throws GetByEmailHospitalIdNotFound{
		ResponseStructure structure=new ResponseStructure();
		Hospital hospital=dao.getByEmail(email);
		if(hospital!=null) {
			structure.setMessage("Successesively found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.getByEmail(email));
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new GetByEmailHospitalIdNotFound();
		}
	}
}
