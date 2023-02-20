package com.ty.springboot_hospital_prc1.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "name should not be null")
	@NotBlank(message = "name should not be blank")
	private String name;
	//@Pattern(regexp = "@")
	@NotBlank(message = "email should not be null")
	@NotNull(message = "email should not be null")
	private String email;
	@NotBlank(message = "gst should not be null")
	@NotNull(message = "gst should not be null")
	private String gst;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	
	
}
