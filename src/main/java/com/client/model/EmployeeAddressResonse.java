package com.client.model;

public class EmployeeAddressResonse {

	private String empName;
	private int empAge;
	private double empSalary;
	private String street;
	private int flatNo;
	private String state;
	private String city;
	private String country;
	public EmployeeAddressResonse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeAddressResonse(String empName, int empAge, double empSalary, String street, int flatNo, String state,
			String city, String country) {
		super();
		this.empName = empName;
		this.empAge = empAge;
		this.empSalary = empSalary;
		this.street = street;
		this.flatNo = flatNo;
		this.state = state;
		this.city = city;
		this.country = country;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
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
	@Override
	public String toString() {
		return "EmployeeAddressResonse [empName=" + empName + ", empAge=" + empAge + ", empSalary=" + empSalary
				+ ", street=" + street + ", flatNo=" + flatNo + ", state=" + state + ", city=" + city + ", country="
				+ country + "]";
	}
	
	
	
//	/emp.empName,emp.empAge,emp.empSalary,addr.street,addr.flatNo,addr.state,addr.city,addr.country
	
}
