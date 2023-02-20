package com.ty.springboot_hospital_prc1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital_prc1.dto.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
		public Address getByCity(String city);
}
