package com.ty.springboot_hospital_prc1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_hospital_prc1.dto.Branch;
import com.ty.springboot_hospital_prc1.dto.Hospital;
 

public interface BranchRepository extends  JpaRepository<Branch, Integer>{
	
	@Query("select b from Branch b where b.hospital=?1")
	public List<Branch> getByHospital(Hospital hospital);
	
}
