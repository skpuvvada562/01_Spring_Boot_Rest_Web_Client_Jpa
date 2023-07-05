package com.client.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BANK_TBL")
public class Bank {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bank_id")
	private int bankId;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="bank_location")
	private String bankLocation;

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(int bankId, String bankName, String bankLocation) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.bankLocation = bankLocation;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankLocation() {
		return bankLocation;
	}

	public void setBankLocation(String bankLocation) {
		this.bankLocation = bankLocation;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", bankLocation=" + bankLocation + "]";
	}
	
	
}
