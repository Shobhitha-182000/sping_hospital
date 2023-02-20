package com.ty.springboot_hospital_prc1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_prc1.dao.EncounterDao;
import com.ty.springboot_hospital_prc1.dao.MedOrderDao;
import com.ty.springboot_hospital_prc1.dto.Address;
import com.ty.springboot_hospital_prc1.dto.Encounter;
import com.ty.springboot_hospital_prc1.dto.MedOrder;
import com.ty.springboot_hospital_prc1.exception.IdNotFound;
import com.ty.springboot_hospital_prc1.util.ResponseStructure;

@Service
public class MedOrderService {
	@Autowired
	private MedOrderDao medOrderDao;
	@Autowired
	private EncounterDao encounterDao;
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedorder(MedOrder medOrder,int eid){
		Encounter encounter=encounterDao.getById(eid);
		medOrder.setEncounter(encounter);
		
		ResponseStructure<MedOrder> structure=new ResponseStructure<MedOrder>();
		structure.setMessage("successively saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(medOrderDao.saveMedorder(medOrder, eid) );
		return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedorder(MedOrder medOrder, int mid) {
		MedOrder medOrder2=medOrderDao.getById(mid);
		medOrder.setEncounter(medOrder2.getEncounter());
		MedOrder medOrder3=medOrderDao.updateMedOrder(medOrder, mid);
		ResponseStructure<MedOrder> structure=new ResponseStructure<MedOrder>();
			structure.setMessage("Successesively updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData( medOrder3);
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.FOUND);
		 
	}
	public ResponseEntity<ResponseStructure<MedOrder>> getById(int mid) {
		 MedOrder medOrder=medOrderDao.getById( mid);
		 ResponseStructure<MedOrder> structure=new ResponseStructure<MedOrder>();
		 if(medOrder!=null) {
			 structure.setMessage("Successesively Found");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(medOrder);
				return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.FOUND);
		 }
		 else {
			throw new IdNotFound();
		}
	}
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(int mid){
		 MedOrder medOrder=medOrderDao.deleteMedorder(mid);
		 ResponseStructure<MedOrder> structure=new ResponseStructure<MedOrder>();
		 if(medOrder!=null) {
			 structure.setMessage("Successesively Found");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(medOrder);
				return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.FOUND);
		 }
		 else {
				throw new IdNotFound();
			}
	}
}
