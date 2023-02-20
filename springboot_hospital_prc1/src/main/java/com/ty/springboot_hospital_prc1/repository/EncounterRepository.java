package com.ty.springboot_hospital_prc1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital_prc1.dto.Encounter;

public interface EncounterRepository extends JpaRepository<Encounter, Integer>{

}
