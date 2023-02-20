package com.ty.springboot_hospital_prc1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_prc1.dto.MedItems;
import com.ty.springboot_hospital_prc1.dto.MedOrder;
import com.ty.springboot_hospital_prc1.repository.MedItemRepository;

@Repository
public class MedItemDao {
	@Autowired
	private MedItemRepository repository;

	public MedItems saveMedItems(MedItems medItems) {
		 
		return  repository.save(medItems);
	}
	public MedItems deleteMedItems(  int mid ) {
		MedItems medItems=repository.findById(mid).get();
		 if(repository.findById(mid).isPresent()) {
			 repository.deleteById(mid);
			 return  medItems;
		 }
			return null;
		}

	public MedItems updateMedItems(MedItems medItems, int mid) {
		 if(repository.findById(mid).isPresent()) {
			 medItems.setBill_id(mid);
		 	 
			  return repository.save(medItems);
		 }
		 else {
			return null;
		}
	}

	public MedItems getById(int mid) {
		// TODO Auto-generated method stub
		return repository.findById(mid).get();
	}
	
}
