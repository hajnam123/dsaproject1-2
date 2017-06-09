package com.entity;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class Util {
	static Gson gson = new Gson();
	
	private static final String e2Products = "data\\1e2\\products.json";
	private static final String e2Customers = "data\\1e2\\customers.json";
	private static final String e2Orders = "data\\1e2\\orders.json";
	private static final String e5Products = "data\\1e5\\products.json";
	private static final String e5Customers = "data\\1e5\\customers.json";
	private static final String e5Orders = "data\\1e5\\orders.json";
	
	private static final String toProducts = "data\\products.json";
	private static final String toCustomers = "data\\customers.json";
	private static final String toOrders = "data\\orders.json";

	public static ArrayList<Product> ap = new ArrayList<>();
	private static boolean productpcodesorted = false;
	
	public static ArrayList<Order> ao = new ArrayList<>();
	private static boolean orderpcodesorted = false;
	private static boolean ordercccodesorted = false;
	
	public static ArrayList<Customer> ac = new ArrayList<>();
	private static boolean customerccodesorted = false;
	
	public static void init(){
		try {
			ap = gson.fromJson(new FileReader(Util.e2Products), Util.prodarrtype(ap));

			ao = gson.fromJson(new FileReader(Util.e2Orders), Util.ordarrtype(ao));
			
			ac = gson.fromJson(new FileReader(Util.e2Customers), Util.custarrtype(ac));
			
			productpcodesorted = false;
			orderpcodesorted = false;
			ordercccodesorted = false;
			customerccodesorted = false;
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void init10k(){
		try {
			ap = gson.fromJson(new FileReader(Util.e5Products), Util.prodarrtype(ap));

			ao = gson.fromJson(new FileReader(Util.e5Orders), Util.ordarrtype(ao));
			
			ac = gson.fromJson(new FileReader(Util.e5Customers), Util.custarrtype(ac));

			productpcodesorted = false;
			orderpcodesorted = false;
			ordercccodesorted = false;
			customerccodesorted = false;
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void tofile1 (ArrayList<Product> ap){
		Gson gson = new Gson();
		PrintWriter out = null;
		try {
			out = new PrintWriter(toProducts);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		out.print(gson.toJson(ap));
		out.flush();
		out.close();
		System.out.println("Product list saved to " + Util.toProducts);
	}
	
	public static void tofile2 (ArrayList<Customer> ac){
		Gson gson = new Gson();
		PrintWriter out = null;
		try {
			out = new PrintWriter(toCustomers);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		out.print(gson.toJson(ac));
		out.flush();
		out.close();
		System.out.println("Customer list saved to " + Util.toCustomers);
	}
	
	public static void tofile3 (ArrayList<Order> ao){
		Gson gson = new Gson();
		PrintWriter out = null;
		try {
			out = new PrintWriter(toOrders);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		out.print(gson.toJson(ao));
		out.flush();
		out.close();
		System.out.println("Order list saved to " + Util.toOrders);
	}
	
	private static final Type prodarrtype(ArrayList<Product> ap){
		return new TypeToken<ArrayList<Product>>(){}.getType();
	}
	
	private static final Type ordarrtype(ArrayList<Order> ao){
		return new TypeToken<ArrayList<Order>>(){}.getType();
	}
	
	private static final Type custarrtype(ArrayList<Customer> ac){
		return new TypeToken<ArrayList<Customer>>(){}.getType();
	}
	
	public static final Comparator<Product> ComProduct = new Comparator<Product>() {
		@Override
		public int compare(Product o1, Product o2) {
			return o1.getPcode().compareTo(o2.getPcode());
		}
	};
	
	public static final Comparator<Order> ComOrderpcode = new Comparator<Order>() {
		@Override
		public int compare(Order o1, Order o2) {
			return o1.getPcode().compareTo(o2.getPcode());
		}
	};

	public static final Comparator<Order> ComOrderccode = new Comparator<Order>() {
		@Override
		public int compare(Order o1, Order o2) {
			return o1.getCcode().compareTo(o2.getCcode());
		}
	};	

	public static final Comparator<Customer> ComCustomer = new Comparator<Customer>() {
		@Override
		public int compare(Customer o1, Customer o2) {
			return o1.getCcode().compareTo(o2.getCcode());
		}
	};
	
	static double findpricebypcode(ArrayList<Product> ap,String pcode){
		try{
			if(!productpcodesorted)sortproductbypcode(ap);
			//int i = Collections.binarySearch(ap, new Product(pcode),ComProduct);
			Search s = new Search();
			int i = s.binarysearchProduct(ap, pcode);
			return ap.get(i).getPrice();
		}catch(Exception e){
			return 0;
		}
	}
	
	public static Product findbypcode(ArrayList<Product> ap, String pcode){
		try{
			if(!productpcodesorted)sortproductbypcode(ap);
			//int i = Collections.binarySearch(ap, new Product(pcode),ComProduct);
			Search s = new Search();
			int i = s.binarysearchProduct(ap, pcode);
			return ap.get(i);			
		}catch(Exception e){
			System.out.println("Not found. " + e.toString());
		}
		return null;
	}
	
	public static Product deletebypcode(ArrayList<Product> ap, String pcode){
		try{
			if(!productpcodesorted)sortproductbypcode(ap);
			//int i = Collections.binarySearch(ap, new Product(pcode),ComProduct);
			Search s = new Search();
			int i = s.binarysearchProduct(ap, pcode);
			Product p = ap.get(i);
			ap.remove(i);
			return p;			
		}catch(Exception e){
			System.out.println("Not found. " + e.toString());
		}
		return null;
	}
	
	public static Product deleteafterpcode(ArrayList<Product> ap, String pcode){
		try{
			Search s = new Search();		
			int i = s.binarysearchProduct(ap, pcode);
			Product p = ap.get(i+1);
			ap.remove(i+1);
			return p;			
		}catch(Exception e){
			System.out.println("Not found. " + e.toString());
		}
		if(!productpcodesorted)sortproductbypcode(ap);
		return null;
	}		
	
	public static Customer findbyccode(ArrayList<Customer> ac, String ccode){
		try{
			if(!customerccodesorted)sortcustomerbyccode(ac);
			//int i = Collections.binarySearch(ac, new Customer(ccode),ComCustomer);
			Search s = new Search();
			int i = s.binarysearchCustomer(ac, ccode);
			return ac.get(i);
			
		}catch(Exception e){
			System.out.println("Not found. " + e.toString());
		}
		return null;
	}

	public static Customer deletebyccode(String ccode) {
		try{
				if(!customerccodesorted)sortcustomerbyccode(ac);
				//int i = Collections.binarySearch(ac, new Customer(s),ComCustomer);
				Search s = new Search();
				int i = s.binarysearchCustomer(ac, ccode);
				Customer c = ac.get(i);
				ac.remove(i);
				return c;	
		}catch(Exception e){
			System.out.println("Not found. " + e.toString());
		}
		return null;
	}
	
	public static void sortorderbypcode(ArrayList<Order> ao){
		//Collections.sort(ao, ComOrderpcode);
		//orderpcodesorted = true;
		//ordercccodesorted = false;

		Sort s = new Sort();
		s.quickSortOrderp(ao, 0, ao.size()-1);
		orderpcodesorted = true;
		ordercccodesorted = false;
	}
	
	public static void sortorderbyccode(ArrayList<Order> ao){
		////Collections.sort(ao, ComOrderccode);
		//ordercccodesorted = true;
		//orderpcodesorted = false;
		
		Sort s = new Sort();
		s.quickSortOrderc(ao, 0, ao.size()-1);
		ordercccodesorted = true;
		orderpcodesorted = false;
	}
	
	public static void sortproductbypcode(ArrayList<Product> ap){
		//Collections.sort(ap, ComProduct);
		//productpcodesorted = true;
		
		Sort s = new Sort();
		s.quickSortProduct(ap, 0, ap.size()-1);
		productpcodesorted = true;
	}
	
	public static void sortcustomerbyccode(ArrayList<Customer> ac){
		//Collections.sort(ac, ComCustomer);
		Sort s = new Sort();
		s.quickSortCustomer(ac, 0, ac.size()-1);
		customerccodesorted = true;
	}
}
