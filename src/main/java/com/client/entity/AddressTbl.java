package com.client.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address_tble")
public class AddressTbl {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="address_id")
	private int addressId;
	@Column(name="flat_no")
	private int flatNo;
	@Column(name="street")
	private String street;
	@Column(name="state")
	private String state;
	@Column(name="city")
	private String city;
	@Column(name="country")
	private String country;
	
	@Column(name="created_on")
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
		return "AddressTbl [addressId=" + addressId + ", flatNo=" + flatNo + ", street=" + street + ", state=" + state
				+ ", city=" + city + ", country=" + country + ", createdOn=" + createdOn + "]";
	}
	
	
	
}
