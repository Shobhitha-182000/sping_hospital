package com.ty.springboot_hospital_prc1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_prc1.dto.Address;
import com.ty.springboot_hospital_prc1.repository.AddressRepository;

@Repository
public class AddressDao {
	@Autowired
	private AddressRepository repository;
	
	public Address saveAddress(Address address) {
		return repository.save(address);
	}
	public Address updateAddress(int id,Address address) {
		if(repository.findById(id).isPresent()) {
			address.setPincode(id);
			return repository.save(address);
		}
		else {
			return null;
		}
	}
	public Address deleteAddress(int id) {
		Address address=repository.findById(id).get();
		if(repository.findById(id).isPresent()) {
			repository.deleteById(id);
			return address;
		}
		else {
			return null;
		}
	}
	
	public Address getByPincode(int id) { 
		if(repository.findById(id).isPresent()) {
			Address address=repository.findById(id).get();
			return address;
		}
		else {
			return null;
		}
	}
	public Address getByCity(String city) {	 
		Address address=repository.getByCity(city);
			return address;
	 
	}
	
}
