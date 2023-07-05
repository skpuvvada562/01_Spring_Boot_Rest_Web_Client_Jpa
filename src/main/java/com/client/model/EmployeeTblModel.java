package com.client.model;

import java.util.List;

import com.client.entity.AddressTbl;

public class EmployeeTblModel {
	private int empId;
	private String empName;
	private int empAge;
	private double empSalary;
	
	private List<AddressTbl> addressTbl;
	
	public EmployeeTblModel(){
		super();
	}
	public EmployeeTblModel(int empId, String empName, int empAge, double empSalary,List<AddressTbl> addressTbl) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empSalary = empSalary;
		this.addressTbl=addressTbl;
	}
	
	
	public List<AddressTbl> getAddressTbl() {
		return addressTbl;
	}
	public void setAddressTbl(List<AddressTbl> addressTbl) {
		this.addressTbl = addressTbl;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
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
	@Override
	public String toString() {
		return "EmployeeTblModel [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empSalary="
				+ empSalary + ", addressTbl=" + addressTbl + "]";
	}
	
	
	
	
}
