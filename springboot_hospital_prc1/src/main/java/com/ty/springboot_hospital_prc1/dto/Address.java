package com.ty.springboot_hospital_prc1.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pincode;
	@NotBlank(message = "street should not be null")
	@NotNull(message = "street should not be null")
	private String street;
	@NotBlank(message = "city should not be null")
	@NotNull(message = "city should not be null")
	private String city;
	@NotBlank(message = "state should not be null")
	@NotNull(message = "state should not be null")
	private String state;
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
