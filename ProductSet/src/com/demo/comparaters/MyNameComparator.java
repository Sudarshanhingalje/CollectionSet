package com.demo.comparaters;
import java.util.Comparator;

import com.demo.beans.*;

public class MyNameComparator implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		
		return o1.getName().compareTo(o2.getName());
	}
	
}


