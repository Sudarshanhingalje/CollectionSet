package com.demo.beans;

import java.time.LocalDate;
import java.util.Objects;

public class Product implements Comparable<Product>{

	private int id;
	private String name;
	private int qty;
	private float price;
	private LocalDate expdate;
	public Product() {
		super();
	}
	public Product(int id, String name, int qty, float price, LocalDate expdate) {
		super();
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.expdate = expdate;
		
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return id == other.id;
	}
	public Product(int id) {
		super();
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public LocalDate getExpdate() {
		return expdate;
	}
	public void setExpdate(LocalDate expdate) {
		this.expdate = expdate;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", qty=" + qty + ", price=" + price + ", expdate=" + expdate
				+ "]";
	}
	
	@Override
	public int compareTo(Product o) {
		return this.id-o.id;
		//return this.name.compareTo(o.name);
	}
	
	
}
