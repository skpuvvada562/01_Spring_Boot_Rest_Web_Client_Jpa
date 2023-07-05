package com.client.model;

import java.util.Date;

public class AddressTblModel {
	private int addressId;
	private int flatNo;
	private String street;
	private String state;
	private String city;
	private String country;
	private Date createdOn;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	@Override
	public String toString() {
		return "AddressTblModel [addressId=" + addressId + ", flatNo=" + flatNo + ", street=" + street + ", state="
				+ state + ", city=" + city + ", country=" + country + ", createdOn=" + createdOn + "]";
	}
	
	
	
}
