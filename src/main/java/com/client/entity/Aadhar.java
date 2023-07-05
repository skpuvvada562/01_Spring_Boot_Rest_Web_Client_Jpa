package com.client.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AADHAR_TBL")
public class Aadhar {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="aadhar_id")
	private Integer aadharId;
	
	private String name;
	
	private Long aadharNo;
	
	private String dob;

	public Aadhar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aadhar(Integer aadharId, String name, Long aadharNo, String dob) {
		super();
		this.aadharId = aadharId;
		this.name = name;
		this.aadharNo = aadharNo;
		this.dob = dob;
	}

	public Integer getAadharId() {
		return aadharId;
	}

	public void setAadharId(Integer aadharId) {
		this.aadharId = aadharId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Aadhar [aadharId=" + aadharId + ", name=" + name + ", aadharNo=" + aadharNo + ", dob=" + dob + "]";
	}
	
	
}
