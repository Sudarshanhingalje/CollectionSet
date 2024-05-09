package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{

	private ProductDao pdao;
	
	public ProductServiceImpl() {
		super();
		pdao= new ProductDaoImpl();
	}

	@Override
	public boolean addProduct() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id");
		int id = sc.nextInt();
		System.out.println("Enter name");
		String nm = sc.next();
		System.out.println("Enter quantity");
		int qty = sc.nextInt();
		System.out.println("Enter price");
		float pr = sc.nextInt();
		System.out.println("Enter expiry date in format(dd/MM/yyyy");
		String exdt = sc.next();
		
		LocalDate ldt = LocalDate.parse(exdt, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Product p = new Product(id,nm,qty,pr,ldt);
		return pdao.save(p);
	}

	@Override
	public Set<Product> displayALL() {

		return pdao.findall();
	}

	@Override
	public Product findById(int id) {
		
		return pdao.displayById(id);
	}
	

	@Override
	public List<Product> displayByName(String nm) {
		
		return pdao.findByName(nm);
	}
	
	

	@Override
	public List<Product> displayByPrice(float price) {
		
		return pdao.findByPrice(price);
	}

	@Override
	public boolean removeById(int id) {
		
		return pdao.deleteById(id);
	}

	@Override
	public boolean modifyById(int id, int qty, float price) {
		
		return pdao.updateById(id,qty,price);
	}

	@Override
	public Set<Product> sortById() {
		
		return pdao.arrangeById();
	}

	@Override
	public List<Product> sortByName() {
		
		return pdao.arrangebyname();
	}

	@Override
	public List<Product> sortByPrice() {
		
		return pdao.arrangeByPrice();
	}

	
	

}
