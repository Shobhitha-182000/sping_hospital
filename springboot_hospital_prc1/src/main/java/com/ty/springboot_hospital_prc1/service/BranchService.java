package com.ty.springboot_hospital_prc1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_prc1.dao.AddressDao;
import com.ty.springboot_hospital_prc1.dao.BranchDao;
import com.ty.springboot_hospital_prc1.dao.HospitalDao;
import com.ty.springboot_hospital_prc1.dto.Address;
import com.ty.springboot_hospital_prc1.dto.Branch;
import com.ty.springboot_hospital_prc1.dto.Hospital;
import com.ty.springboot_hospital_prc1.exception.DeleteBranchIdNotFound;
import com.ty.springboot_hospital_prc1.exception.GetByIdBranchIdNotFound;
import com.ty.springboot_hospital_prc1.exception.IdNotFound;
import com.ty.springboot_hospital_prc1.exception.UpdateBranchIdNotFound;
import com.ty.springboot_hospital_prc1.util.ResponseStructure;

@Service
public class BranchService {
	@Autowired
	private BranchDao dao;
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private AddressDao addressDao;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch,int hid,int aid){
//		Hospital hospital=hospitalDao.getById(hid);
//		Address address=addressDao.getByPincode(aid);
//		branch.setAddress(address);
//		branch.setHospital(hospital);
		ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
		structure.setMessage("successfully Branch is saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveBranch(branch, hid,aid));
		return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id,Branch branch) throws UpdateBranchIdNotFound{
		ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
		Branch branch2=dao.updateBranch(id, branch);
		if(branch2!=null) {
			structure.setMessage("successfully Branch is updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch2);
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new UpdateBranchIdNotFound()  ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> getById(int id) throws GetByIdBranchIdNotFound{
		ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
		Branch branch2=dao.getById(id);
		if(branch2!=null) {
			structure.setMessage("successfully Branch is found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.getById(id));
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new GetByIdBranchIdNotFound()  ;
		}
	}
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) throws DeleteBranchIdNotFound{
		ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
		Branch branch2=dao.deleteBranch(id);
		if(branch2!=null) {
			structure.setMessage("successfully Branch is deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteBranch(id));
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new DeleteBranchIdNotFound()  ;
		}
	}
	public ResponseEntity<ResponseStructure<List<Branch>>> getByHospital(int hid){
		ResponseStructure<List<Branch>> structure=new ResponseStructure<List<Branch>>();
		
		structure.setMessage("branch details are");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData((dao.getByHospital(hid)));
		return new ResponseEntity<ResponseStructure<List<Branch>>>(structure,HttpStatus.FOUND);
	}
}
