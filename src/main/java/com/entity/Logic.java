package com.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Logic {
	BufferedReader br;
	
	public Logic(){
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	
	public void start(){
		boolean in = true;
		while(in){
			System.out.println("1. Load 10e2 data");
			System.out.println("2. Load 10e5 data");			
			System.out.println("3. Add Product");
			System.out.println("4. Display product");
			System.out.println("5. Save Product list to file");
			System.out.println("6. Search Product by pcode");
			System.out.println("7. Delete product by pcode");
			System.out.println("8. Sort product by pcode");
			System.out.println("9. Delete product after product with pcode");
			System.out.println("================");
			System.out.println("10. Add Customer");
			System.out.println("11. Display all customer");
			System.out.println("12. Sort all customer by ccode");
			System.out.println("13. Save customer list to file");
			System.out.println("14. Search customer by ccode");
			System.out.println("15. Delete customer by ccode");			
			System.out.println("================");
			System.out.println("16. Add order");
			System.out.println("17. Display order with total");
			System.out.println("18. Sort order by pcode");
			System.out.println("19. Sort order by ccode");
			System.out.println("20. Save order list to file");;
			System.out.println("0. Exit");
			System.out.print("Input choice: ");
			try {
				Integer i = Integer.parseInt(br.readLine());
				switch(i){
				case 0: in = false;break;
				case 1: this.load10e2();break;
				case 2: this.load10e5();break;
				case 3: this.addproduct();break;
				case 4: this.displayproduct();break;
				case 5: this.saveproduct();break;
				case 6: this.findproduct();break;
				case 7: this.deleteproduct();break;
				case 8: this.sortproduct();break;
				case 9: this.deleteproductafter();break;
				case 10: this.addcustomer();break;
				case 11: this.displaycustomer();break;
				case 12: this.sortcustomer();break;
				case 13: this.savecustomer();break;
				case 14: this.searchcusomer();break;
				case 15: this.deletecustomer();break;
				case 16: this.addorder();break;
				case 17: this.displayorder();break;
				case 18: this.sortorderpcode();break;
				case 19: this.sortorderccode();break;
				case 20: this.saveorder();break;				
				}
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	}
	
	public void load10e2(){
		Util.init();
	}
	
	public void load10e5(){
		Util.init10k();
	}
	
	public void addproduct(){
		Product p = new Product();
		try {
			System.out.print("Input pcode: ");p.setPcode(br.readLine());
			System.out.print("Input pro_name: ");p.setPro_name(br.readLine());
			System.out.print("Input quantity: ");p.setQuantity(Integer.parseInt(br.readLine()));
			System.out.print("Input Saled: ");p.setSale(Integer.parseInt(br.readLine()));
			System.out.print("Input price: ");p.setPrice(Double.parseDouble(br.readLine()));
			System.out.print("Input Image URL: ");p.setPro_image_url(br.readLine());

			Util.ap.add(p);
			
			System.out.println("Added: "+p.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void displayproduct(){
		try{
			for(Product p : Util.ap){
				System.out.println(p.toString());
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void saveproduct(){
		try{
			Util.tofile1(Util.ap);
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void findproduct(){
		try{
			System.out.print("Input pcode: ");String pcode = br.readLine();
			Product p = Util.findbypcode(Util.ap, pcode);
			System.out.println(p.toString());
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void deleteproduct(){
		try{
			System.out.print("Input pcode: ");String pcode = br.readLine();
			Product p = Util.deletebypcode(Util.ap, pcode);
			System.out.println("Deleted :" + p.toString());
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void sortproduct(){
		try{
			Util.sortproductbypcode(Util.ap);
			System.out.println("Product sorted.");
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void deleteproductafter(){
		try{
			System.out.print("Input pcode: ");String pcode = br.readLine();
			Product p = Util.deleteafterpcode(Util.ap, pcode);
			System.out.println("Deleted :" + p.toString());
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void addcustomer(){
		Customer c = new Customer();
		try{
			System.out.print("Input ccode: ");c.setCcode(br.readLine());
			System.out.print("Input cus_name: ");c.setCus_name(br.readLine());
			System.out.print("Input phone: ");c.setPhone(br.readLine());
			Util.ac.add(c);
			System.out.println("Added :" + c.toString());
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void displaycustomer(){
		try{
			for(Customer c : Util.ac){
				System.out.println(c.toString());
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void sortcustomer(){
		try{
			Util.sortcustomerbyccode(Util.ac);
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void savecustomer(){
		try{
			Util.tofile2(Util.ac);
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void searchcusomer(){
		Customer c = new Customer();
		try{
			System.out.print("Input ccode: ");c.setCcode(br.readLine());
			c = Util.findbyccode(Util.ac, c.getCcode());
			System.out.println(c.toString());
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void deletecustomer(){
		Customer c = new Customer();
		try{
			System.out.print("Input ccode: ");c.setCcode(br.readLine());
			c = Util.deletebyccode(c.getCcode());
			System.out.println("Deleted: " + c.toString());
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void addorder(){
		Order o = new Order();
		try{
			System.out.print("Input pcode: ");o.setPcode(br.readLine());
			System.out.print("Input ccode: ");o.setCcode(br.readLine());
			System.out.print("Input quantity: ");o.setQuantity(Integer.parseInt(br.readLine()));
			Double price = Util.findpricebypcode(Util.ap, o.getPcode());
			if(price==0){
				System.out.println("Invalid pcode");
			}else{
				Util.ao.add(o);
				System.out.println("Added :" + o.toString());
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void displayorder(){
		try{
			for(Order o : Util.ao){
				System.out.println(o.toString());
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void sortorderpcode(){
		try{
			Util.sortorderbypcode(Util.ao);
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	public void sortorderccode(){
		try{
			Util.sortorderbyccode(Util.ao);
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void saveorder(){
		try{
			Util.tofile3(Util.ao);
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
}
