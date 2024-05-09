package com.demo.service;

import java.util.List;
import java.util.Set;

import com.demo.beans.Product;

public interface ProductService {

	boolean addProduct();

	Set<Product> displayALL();

	Product findById(int id);
	
List<Product> displayByName(String nm);

List<Product> displayByPrice(float price);


	boolean removeById(int id);

	boolean modifyById(int id, int qty, float price);

	Set<Product> sortById();

	List<Product> sortByName();

	List<Product> sortByPrice();

	
	

}
