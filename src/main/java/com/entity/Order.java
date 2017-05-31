package com.entity;

import java.util.ArrayList;

public class Order {
	String pcode;
	String ccode;
	Integer quantity ;
	
	public String getPcode() {
		return pcode;
	}
	
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	
	public String getCcode() {
		return ccode;
	}
	
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Order [pcode=" + pcode + ", ccode=" + ccode + ", quantity=" + quantity + " total = " + gettotal(Util.ap) + "]";
	}
	
	public Order(String pcode, String ccode, Integer quantity) {
		super();
		this.pcode = pcode;
		this.ccode = ccode;
		this.quantity = quantity;
	}
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public double gettotal(ArrayList<Product> ap){
		return quantity*Util.findpricebypcode(ap,pcode);
	}
}
