package com.ty.springboot_hospital_prc1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_prc1.dto.Encounter;
import com.ty.springboot_hospital_prc1.dto.MedOrder;
import com.ty.springboot_hospital_prc1.repository.MedOrederRepository;

@Repository
public class MedOrderDao {
	@Autowired
	private MedOrederRepository repository;
	
	public MedOrder saveMedorder(MedOrder medOrder,int eid) {
		return repository.save(medOrder);
	}
 
	public MedOrder deleteMedorder(  int mid ) {
		MedOrder medOrder=repository.findById(mid).get();
		 if(repository.findById(mid).isPresent()) {
			 repository.deleteById(mid);
			 return  medOrder;
		 }
			return null;
		}

	public MedOrder updateMedOrder(MedOrder medOrder, int mid) {
		 if(repository.findById(mid).isPresent()) {
			  medOrder.setMid(mid);
		 	 
			  return repository.save(medOrder);
		 }
		 else {
			return null;
		}
	}

	public MedOrder getById(int mid) {
		// TODO Auto-generated method stub
		return repository.findById(mid).get();
	}
	
}
