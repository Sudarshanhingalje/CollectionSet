package com.demo.comparaters;

import java.util.Comparator;

import com.demo.beans.Product;

public class MyPriceComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
	
		return  (int)(o1.getPrice() - o2.getPrice());
	}

}
