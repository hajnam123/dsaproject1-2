package com.entity;

import java.util.ArrayList;

public class Sort {
	
	private int partitionc(ArrayList<Customer> ac, int left, int right){
		int i=left;
		int j=right;
		Customer temp;
		Customer pivot = ac.get((i+j)/2);
		while (i <= j) {
            while (Util.ComCustomer.compare(ac.get(i), pivot)<0)i++;
            while (Util.ComCustomer.compare(ac.get(j), pivot)>0)j--;
            if (i <= j) {
            	temp = ac.get(i);
            	ac.set(i, ac.get(j));
            	ac.set(j, temp);
                i++;
                j--;
            }
      };
      return i;
	}
	
	public void quickSortCustomer(ArrayList<Customer> ac, int left, int right) {
		System.out.println("left " + left);
		System.out.println("right " + right);
	      int index = partitionc(ac, left, right);
	      System.out.println("index " + index);
	      if (left < index - 1){
	    	  quickSortCustomer(ac, left, index - 1);
	      }else{
	      }
	      if (index < right){
	    	  quickSortCustomer(ac, index, right);
	      }else{
	      }
	}
	
	private int partitionp(ArrayList<Product> ap, int left, int right){
		int i=left;
		int j=right;
		Product temp;
		Product pivot = ap.get((i+j)/2);
		while (i <= j) {
            while (Util.ComProduct.compare(ap.get(i), pivot)<0)i++;
            while (Util.ComProduct.compare(ap.get(j), pivot)>0)j--;
            if (i <= j) {
            	temp = ap.get(i);
            	ap.set(i, ap.get(j));
            	ap.set(j, temp);
                i++;
                j--;
            }
      };
      return i;	
	}
		
	public void quickSortProduct(ArrayList<Product> ac, int left, int right) {
		System.out.println("left " + left);
		System.out.println("right " + right);
	      int index = partitionp(ac, left, right);
	      System.out.println("index " + index);
	      if (left < index - 1){
	    	  quickSortProduct(ac, left, index - 1);
	      }else{
	      }
	      if (index < right){
	    	  quickSortProduct(ac, index, right);
	      }else{
	      }
	}
	
	private int partitionoc(ArrayList<Order> ap, int left, int right){
		int i=left;
		int j=right;
		Order temp;
		Order pivot = ap.get((i+j)/2);
		while (i <= j) {
            while (Util.ComOrderccode.compare(ap.get(i), pivot)<0)i++;
            while (Util.ComOrderccode.compare(ap.get(j), pivot)>0)j--;
            if (i <= j) {
            	temp = ap.get(i);
            	ap.set(i, ap.get(j));
            	ap.set(j, temp);
                i++;
                j--;
            }
      };
      return i;	
	}

	private int partitionop(ArrayList<Order> ap, int left, int right){
		int i=left;
		int j=right;
		Order temp;
		Order pivot = ap.get((i+j)/2);
		while (i <= j) {
            while (Util.ComOrderpcode.compare(ap.get(i), pivot)<0)i++;
            while (Util.ComOrderpcode.compare(ap.get(j), pivot)>0)j--;
            if (i <= j) {
            	temp = ap.get(i);
            	ap.set(i, ap.get(j));
            	ap.set(j, temp);
                i++;
                j--;
            }
      };
      return i;	
	}
	
	public void quickSortOrderc(ArrayList<Order> ac, int left, int right) {
		System.out.println("left " + left);
		System.out.println("right " + right);
	      int index = partitionoc(ac, left, right);
	      System.out.println("index " + index);
	      if (left < index - 1){
	    	  quickSortOrderc(ac, left, index - 1);
	      }else{
	      }
	      if (index < right){
	    	  quickSortOrderc(ac, index, right);
	      }else{
	      }
	}

	public void quickSortOrderp(ArrayList<Order> ac, int left, int right) {
		System.out.println("left " + left);
		System.out.println("right " + right);
	    int index = partitionop(ac, left, right);
	    System.out.println("index " + index);
	    if (left < index - 1){
	  	  quickSortOrderp(ac, left, index - 1);
	    }else{
	    }
	    if (index < right){
	  	  quickSortOrderp(ac, index, right);
	    }else{
	    }
	}
}