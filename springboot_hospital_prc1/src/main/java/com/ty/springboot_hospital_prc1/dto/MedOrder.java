package com.ty.springboot_hospital_prc1.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;



@Entity
public class MedOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	//@CreationTimestamp
	//private Date date;
	@NotBlank(message = "date should not be null")
	@NotNull(message = "date should not be null")
	private String date;
	@NotBlank(message = "doctor should not be null")
	@NotNull(message = "doctor should not be null")
	private String doctor;
	@ManyToOne(fetch = FetchType.EAGER)
	private Encounter encounter;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	@Override
	public String toString() {
		return "MedOrder [mid=" + mid + ", date=" + date + ", doctor=" + doctor + ", encounter=" + encounter + "]";
	}

}

