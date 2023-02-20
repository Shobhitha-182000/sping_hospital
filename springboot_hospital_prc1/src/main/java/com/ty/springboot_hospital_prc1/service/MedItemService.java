package com.ty.springboot_hospital_prc1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_prc1.dao.MedItemDao;
import com.ty.springboot_hospital_prc1.dao.MedOrderDao;
import com.ty.springboot_hospital_prc1.dto.MedItems;
import com.ty.springboot_hospital_prc1.dto.MedOrder;
import com.ty.springboot_hospital_prc1.exception.IdNotFound;
import com.ty.springboot_hospital_prc1.util.ResponseStructure;

@Service
public class MedItemService {
	@Autowired
	private MedItemDao medItemDao;
	
	@Autowired 
	private MedOrderDao medOrderDaOrder;

	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(MedItems medItems, int order_id) {
		  MedOrder medOrder=medOrderDaOrder.getById(order_id);
		  medItems.setMedOrder(medOrder);
		  ResponseStructure<MedItems> structure=new  ResponseStructure<MedItems>();
		  structure.setMessage("Successfully saved");
		  structure.setStatus(HttpStatus.CREATED.value());
		  structure.setData(medItemDao.saveMedItems(medItems));
		  return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(MedItems medItems, int mid) {
		MedItems medItems1=medItemDao.getById(mid);
		medItems.setMedOrder(medItems1.getMedOrder());
		MedItems medItems3=medItemDao.updateMedItems(medItems, mid);
		ResponseStructure<MedItems> structure=new ResponseStructure<MedItems>();
			structure.setMessage("Successesively updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData( medItems3);
			return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.FOUND);
		 
	}
	public ResponseEntity<ResponseStructure<MedItems>> getById(int mid) {
		MedItems medItems=medItemDao.getById( mid);
		 ResponseStructure<MedItems> structure=new ResponseStructure<MedItems>();
		 if(medItems!=null) {
			 structure.setMessage("Successesively Found");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(medItems);
				return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.FOUND);
		 }
		 else {
			throw new IdNotFound();
		}
	}
	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems(int mid){
		MedItems medItems=medItemDao.deleteMedItems(mid);
		 ResponseStructure<MedItems> structure=new ResponseStructure<MedItems>();
		 if(medItems!=null) {
			 structure.setMessage("Successesively deleted");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(medItems);
				return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.FOUND);
		 }
		 else {
				throw new IdNotFound();
			}
	}
}
