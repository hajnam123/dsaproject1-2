package com.entity;

public class Product {
	String pcode;
	String pro_name;
	Integer quantity;
	Integer sale;
	Double price;
	String pro_image_url;
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getSale() {
		return sale;
	}
	public void setSale(Integer saled) {
		this.sale = saled;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getPro_image_url() {
		return pro_image_url;
	}
	public void setPro_image_url(String pro_image_url) {
		this.pro_image_url = pro_image_url;
	}
	
	
	public Product(String pcode) {
		super();
		this.pcode = pcode;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [pcode=" + pcode + ", pro_name=" + pro_name + ", quantity=" + quantity + ", sale=" + sale
				+ ", price=" + price + ", pro_image_url=" + pro_image_url + "]";
	}
	
	
	
}
