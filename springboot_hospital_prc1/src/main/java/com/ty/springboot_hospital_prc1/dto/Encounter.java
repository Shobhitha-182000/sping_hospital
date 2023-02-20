package com.ty.springboot_hospital_prc1.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
public class Encounter {
	@Id
	@GeneratedValue
	private int id;
	@NotBlank(message = "disease should not be null")
	@NotNull(message = "disease should not be null")
	private String disease;
	@Range(min = 1,max= 10, message = "Cost should be  negative." )
	private double cost;
	@ManyToOne
	private Person person;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Branch> branchs;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<Branch> getBranchs() {
		return branchs;
	}
	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
}
