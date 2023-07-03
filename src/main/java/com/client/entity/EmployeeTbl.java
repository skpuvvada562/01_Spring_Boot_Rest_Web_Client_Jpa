package com.client.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employer_tble")
public class EmployeeTbl {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="empid")
	private int empId;
	@Column(name="empname")
	private String empName;
	@Column(name="empage")
	private int empAge;
	@Column(name="empsalary")
	private double empSalary;
	@Column(name="created_on")
	private Date createdOn;
	@Column(name="last_login")
	private Date lastLogin;
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
	
	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	@Override
	public String toString() {
		return "EmployeeTbl [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empSalary="
				+ empSalary + ", createdOn=" + createdOn + ", lastLogin=" + lastLogin + "]";
	}
	
	
	
}
