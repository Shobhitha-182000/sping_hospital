package com.ty.springboot_hospital_prc1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_prc1.dao.AddressDao;
import com.ty.springboot_hospital_prc1.dto.Address;
import com.ty.springboot_hospital_prc1.dto.Hospital;
import com.ty.springboot_hospital_prc1.exception.DeleteAddressIdNotFound;
import com.ty.springboot_hospital_prc1.exception.GetByCityAddressIdNotFound;
import com.ty.springboot_hospital_prc1.exception.GetByIdAddressIdNotFound;
 
import com.ty.springboot_hospital_prc1.exception.IdNotFound;
import com.ty.springboot_hospital_prc1.exception.UpdateAddressIdNotFound;
import com.ty.springboot_hospital_prc1.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao dao;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address){
		ResponseStructure structure=new ResponseStructure();
		structure.setMessage("successively saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Address>> updatAddress(Address address,int id) throws UpdateAddressIdNotFound{
		ResponseStructure structure=new ResponseStructure();
		if(address!=null) {
			structure.setMessage("Successesively updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateAddress(id, address));
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new UpdateAddressIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) throws DeleteAddressIdNotFound{
		ResponseStructure structure=new ResponseStructure();
		Address address=dao.deleteAddress(id);
		if(address!=null) {
			structure.setMessage("Successesively delete");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new DeleteAddressIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> getById(int id) throws GetByIdAddressIdNotFound{
		ResponseStructure structure=new ResponseStructure();
		Address address=dao.getByPincode(id);
		if(address!=null) {
			structure.setMessage("Successesively found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new GetByIdAddressIdNotFound();
		}
	}
	public ResponseEntity<ResponseStructure<Address>> getByCity(String city) throws GetByCityAddressIdNotFound{
		ResponseStructure structure=new ResponseStructure();
		Address address=dao.getByCity(city);
		if(address!=null) {
			structure.setMessage("Successesively found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new GetByCityAddressIdNotFound();
		}
	}
}
