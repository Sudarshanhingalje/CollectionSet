package com.demo.dao;
import java.time.LocalDate;
import java.util.HashSet;
import com.demo.comparaters.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
//import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.demo.beans.*;
public class ProductDaoImpl implements ProductDao{

	static Set<Product> pset  ;
	static {
		pset=new HashSet<>();
		pset.add(new Product(1, "Lays" , 3, 20, LocalDate.of(2022, 12, 11)));
		pset.add(new Product(3, "Bourbon" , 5, 25, LocalDate.of(2019, 12, 01)));
		pset.add(new Product(2, "Maggi" , 2, 15, LocalDate.of(2021, 2, 11)));
		pset.add(new Product(5, "KinderJoy" , 1, 50, LocalDate.of(2014, 5, 07)));
		pset.add(new Product(4, "HidenSeek" , 7, 30, LocalDate.of(2022, 4, 02)));
	}
	@Override
	public boolean save(Product p) {

		return pset.add(p);
		
		
	}
	@Override
	public Set<Product> findall() {
		
		return pset;
	}
	@Override
	public Product displayById(int id) {
	
		for(Product p :pset)
		{
			if(p.getId()==id)
			{
				return p;
			}
		}
		
     	return null;
	}
	@Override
	public List<Product> findByName(String nm) {
		 List<Product> lst=new ArrayList<>();
		 for(Product p:pset)
		 {
			 if(p.getName().equals(nm))
			 {
				 lst.add(p);
			 }
		 }
	      if(lst.isEmpty())
	    {
		       return null;
		
	   } return lst;
}
	@Override
	public List<Product> findByPrice(float price) {
		List <Product> lst = pset.stream()
				.filter(ob->ob.getPrice()>price)
				.collect(Collectors.toList());
		return lst;
	}
	@Override
	public boolean deleteById(int id) {
		
		return pset.remove(new Product(id));
	}
	@Override
	public boolean updateById(int id, int qty, float price) {
		Product p = displayById(id);
		if(p!= null) {
			p.setQty(qty);
			p.setPrice(price);
		return true;
		}
		return false;

	
		
	}
	@Override
	public Set<Product> arrangeById() {
		Set<Product> tset = new TreeSet<>();
		for(Product p : pset) {
			tset.add(p);
		}
		
		return tset;
	}
	@Override
	public List<Product> arrangebyname() {
		List<Product> lst = new ArrayList<>();
		for(Product p : pset) {
			lst.add(p);
		}
		
		lst.sort(new MyNameComparator());
		return lst;
	}
	@Override
	public List<Product> arrangeByPrice() {
		List<Product> lst = new ArrayList<>();
		for(Product p : pset) {
			lst.add(p);
		}
		
		lst.sort(new MyPriceComparator());
		return lst;
	}
	
	
	
	}

