package com.ty.springboot_hospital_prc1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital_prc1.dto.MedOrder;

public interface MedOrederRepository extends JpaRepository<MedOrder, Integer>{

}
