package com.entity;

import java.util.ArrayList;

public class Search {
	public int binarysearchCustomer(ArrayList<Customer> a, String ccode){
		Customer c = new Customer();
		c.setCcode(ccode);
		int size = a.size();
		
		int i = 0;
		int j = size - 1;
		
		boolean found = false;
		
		while(!found){
			if(j<i)return -1;
			
			int mid = i+(j-i)/2;
			
			if(Util.ComCustomer.compare(a.get(mid), c)<0) i = mid + 1;
			if(Util.ComCustomer.compare(a.get(mid), c)>0) j = mid - 1;			
			if(Util.ComCustomer.compare(a.get(mid), c)==0) return mid;
		}
		return -1;
	}

	public int binarysearchOrderc(ArrayList<Order> a, String ccode){
		Order c = new Order();
		c.setCcode(ccode);
		int size = a.size();
		
		int i = 0;
		int j = size - 1;
		
		boolean found = false;
		
		while(!found){
			if(j<i)return -1;
			
			int mid = i+(j-i)/2;
			
			if(Util.ComOrderccode.compare(a.get(mid), c)<0) i = mid + 1;
			if(Util.ComOrderccode.compare(a.get(mid), c)>0) j = mid - 1;			
			if(Util.ComOrderccode.compare(a.get(mid), c)==0) return mid;
		}
		return -1;
	}

	public int binarysearchOrderp(ArrayList<Order> a, String ccode){
		Order c = new Order();
		c.setCcode(ccode);
		int size = a.size();
		
		int i = 0;
		int j = size - 1;
		
		boolean found = false;
		
		while(!found){
			if(j<i)return -1;
			
			int mid = i+(j-i)/2;
			
			if(Util.ComOrderpcode.compare(a.get(mid), c)<0) i = mid + 1;
			if(Util.ComOrderpcode.compare(a.get(mid), c)>0) j = mid - 1;
			
			if(Util.ComOrderpcode.compare(a.get(mid), c)==0) return mid;
		}
		return -1;
	}

	public int binarysearchProduct(ArrayList<Product> a, String code){
		Product c = new Product();
		c.setPcode(code);
		int size = a.size();
		
		int i = 0;
		int j = size - 1;
		
		boolean found = false;
		
		while(!found){
			if(j<i)return -1;
			
			int mid = i+(j-i)/2;
			
			if(Util.ComProduct.compare(a.get(mid), c)<0) i = mid + 1;
			if(Util.ComProduct.compare(a.get(mid), c)>0) j = mid - 1;
			
			if(Util.ComProduct.compare(a.get(mid), c)==0) return mid;
		}
		return -1;
	}
}
