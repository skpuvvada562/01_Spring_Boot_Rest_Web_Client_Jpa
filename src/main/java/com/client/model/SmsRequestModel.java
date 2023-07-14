package com.client.model;

public class SmsRequestModel {

	private String mobileNo;
	private String message;
	
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "SmsRequestModel [mobileNo=" + mobileNo + ", message=" + message + "]";
	}
	
	
}
