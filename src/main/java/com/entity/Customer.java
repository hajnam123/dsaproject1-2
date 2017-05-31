package com.entity;

public class Customer {
	String ccode,cus_name,phone;

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [ccode=" + ccode + ", cus_name=" + cus_name + ", phone=" + phone + "]";
	}

	public Customer(String ccode, String cus_name, String phone) {
		super();
		this.ccode = ccode;
		this.cus_name = cus_name;
		this.phone = phone;
	}

	public Customer(String ccode2) {
		this.ccode = ccode2;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	
}
