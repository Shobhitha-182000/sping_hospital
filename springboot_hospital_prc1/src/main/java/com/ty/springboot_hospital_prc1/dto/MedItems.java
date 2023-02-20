package com.ty.springboot_hospital_prc1.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
public class MedItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bill_id;
	@NotBlank(message = "tablet name should not be null")
	@NotNull(message = "tablet name should not be null")
	private String tab_name;
	@Range(min = 1,max= 10, message = " cost should be within the limit" )
	private long bill_amount;
	@ManyToOne
	private MedOrder medOrder;

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}

	public String getTab_name() {
		return tab_name;
	}

	public void setTab_name(String tab_name) {
		this.tab_name = tab_name;
	}

	public long getBill_amount() {
		return bill_amount;
	}

	public void setBill_amount(long bill_amount) {
		this.bill_amount = bill_amount;
	}

	public MedOrder getMedOrder() {
		return medOrder;
	}

	public void setMedOrder(MedOrder medOrder) {
		this.medOrder = medOrder;
	}

	@Override
	public String toString() {
		return "MedItems [bill_id=" + bill_id + ", tab_name=" + tab_name + ", bill_amount=" + bill_amount
				+ ", medOrder=" + medOrder + "]";
	}

}
