package com.demo.test;
import com.demo.beans.Product;
import com.demo.service.*;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
public class TestProduct {

	public static void main(String[] args) {
		
		ProductService pservice = new ProductServiceImpl();
		Scanner sc = new Scanner(System.in);
		
		
		int choice = 0;
		do {
				System.out.println("1.Add new product \t 2.Display all \t 3.Display by id");
				System.out.println("4.display by name \t 5.display by Price \t 6.Sorted by id");
				System.out.println("7.Sorted by name \t8.Sorted By Price \t 9.Delete by id");
				System.out.println("10.Modify Product \\t 11.Exit");
				System.out.println("enter choice");
				 choice = sc.nextInt();
				 switch(choice) {
				 case 1:
					 
				boolean result = pservice.addProduct();
				if(result) {
					System.out.println("Product added");
				}
				else
					System.out.println("error......");
				break;
				
				 case 2:
					 Set<Product>plist=pservice.displayALL();
					 plist.stream().forEach(System.out::println);
					 
					 break;
					
				 case 3:
					 System.out.println("enter id ");
					 int id = sc.nextInt();
					 
					 Product p  = pservice.findById(id);
					 
					 if(p != null)
					 {System.out.println("hi");
						 System.out.println(p);
					 }
					 else
					 {
						 System.out.println("product not found");
					 }
					 break;
				 case 4: System.out.println("enter name");
				 String nm = sc.next();
				 List<Product> lst = pservice.displayByName(nm);
				 lst.stream().forEach(ob->System.out.println(ob));
	
				 break;
				 
				 case 5:
					 System.out.println("Enter price");
					 float price = sc.nextFloat();
					 lst = pservice.displayByPrice(price);
					lst.stream().forEach(ob->System.out.println(ob));
					 break;
					 
				 case 6:
					 plist = pservice.sortById();
					 plist.stream().forEach(System.out::println);
					
					 break;
				 case 7:
					 lst = pservice.sortByName();
					 lst.stream().forEach(System.out::println);
					
					 break;
					 
				 case 8:
					 lst = pservice.sortByPrice();
					 lst.stream().forEach(System.out::println);
				 case 9:
					 System.out.println("Enter id");
					  id = sc.nextInt();
					boolean result1 = pservice.removeById(id);
					 
					 if(result1)
					 System.out.println("deleted Successfully");
					 
					 System.out.println("enter valid id");
					 break;
					 
				 case 10:
						System.out.println("Enter id");
						id = sc.nextInt();
						System.out.println("Enter Quantity");
						int qty = sc.nextInt();
						System.out.println("Enter Price");
					    price = sc.nextFloat();
					    
					    result1 = pservice.modifyById(id,qty,price);
					    
					    if( result1) {
					    	System.out.println("Modified Succesful");
					    }
					    else {
					    	System.out.println("Not Found");
					    }
					    
					   
						break;
				 case 11:
					 System.out.println(" thank you");
					 break;
					 default :
						 System.out.println(" wrong choice");
						 
						 sc.close();
						 break;
					 
 		}
				 
		}	
		
		while(choice!=11);
	}

}
