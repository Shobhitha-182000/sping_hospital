package com.ty.springboot_hospital_prc1.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.TinyBitSet;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_prc1.dto.Address;
import com.ty.springboot_hospital_prc1.dto.Branch;
import com.ty.springboot_hospital_prc1.dto.Hospital;
import com.ty.springboot_hospital_prc1.repository.BranchRepository;

@Repository
public class BranchDao {
	@Autowired
	private BranchRepository branchRepo;
	
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private AddressDao addressDao;
	
	public Branch saveBranch(Branch branch,int hid,int aid) {
		Hospital hospital=hospitalDao.getById(hid);
		Address address=addressDao.getByPincode(aid);
		branch.setHospital(hospital);
		branch.setAddress(address);
		return branchRepo.save(branch);
	}
	
	public Branch updateBranch(int id,Branch branch ) {
		 Branch branch1=branchRepo.findById(id).get();	
	 if( branch1  != null) {
		 branch.setId(id);
		 branch.setHospital(branch1.getHospital());
		 return branchRepo.save(branch);
	 }
	 else {
		return null;
	}
		
	}
	
	public Branch getById(int id) {
		 if(branchRepo.findById(id).isPresent()) {
			 Branch branch=branchRepo.findById(id).get();
			 return  branch;
		 }
		 else {
			return null;
		}
	}
	public Branch deleteBranch(int id) {
		 Branch branch=branchRepo.findById(id).get(); 
		if(branchRepo.findById(id).isPresent()) {
			branchRepo.deleteById(id); 
			 return  branch;
		 }
		 else {
			return null;
		}
	}
	
	public List<Branch> getByHospital(int hid){
		Hospital hospital=hospitalDao.getById(hid);
		 return branchRepo.getByHospital(hospital);
	}
}

