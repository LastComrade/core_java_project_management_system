package com.deloitte.main;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.deloitte.model.Product;

public class ProductManagementSystem {
	private HashMap<Integer, Product> productMap;
	double averagePrice;
	
	/**
	 * Prints the properties of the products object
	 * 
	 * @Time - O(1)
	 * @param product
	 */
	private void printProduct(Product product) {
		if (product == null) {
			return;
		}

		System.out.print("Product ID: " + product.getProductId());
		System.out.print(", Product Name: " + product.getProductName());
		System.out.print(", Product Price: " + product.getPrice());
		System.out.println();
	}

	public ProductManagementSystem() {
		productMap = new LinkedHashMap<>();
		averagePrice = 0.0;
	}

	/**
	 * This function adds the product in the product list
	 * 
	 * @Time - O(1)
	 * @param Product model - product object
	 */
	public void addProduct(Product product) {
		if (productMap.containsKey((Object) product.getProductId())) {
			System.out.println("Product with the Product ID " + product.getProductId() + " already exists.");
			return;
		}

		productMap.put(product.getProductId(), product);
		averagePrice += product.getPrice();
		System.out.println("Producted added successfuly!");
	}

	/**
	 * Display all the products in the list
	 * 
	 * @Time - O(N)
	 */
	public void displayAllProducts() {
		if (productMap.size() > 0) {
			for (int productId : productMap.keySet()) {
				printProduct(productMap.get(productId));
			}
			
			return;
		} 
		
		System.out.println("No products in the list");
	}

	/**
	 * Find the product by Product ID and print the products details 
	 * 
	 * @Time - O(1)
	 * @param productId
	 */
	public void findProductById(String productId) {
		try {
			int id = Integer.parseInt(productId);

			if (productMap.containsKey((Object) id)) {
				printProduct(productMap.get(id));
			} else {
				System.out.println("Product with ID: " + id + " doesn't exist");
			}
		} catch (Exception e) {
			System.out.println("Invalid input!");
		}
	}

	/**
	 * Remove the product by Product ID
	 * 
	 * @Time - O(1)
	 * @param productId
	 */
	public void removeProductById(String productId) {
		try {
			int id = Integer.parseInt(productId);

			if (productMap.containsKey((Object) id)) {
				averagePrice -= productMap.remove(id).getPrice();
				System.out.println("Product removed successfully");
			} else {
				System.out.println("Product with ID: " + id + " doesn't exist");
			}
		} catch (Exception e) {
			System.out.println("Invalid input!");
		}
	}

	
	/**
	 * Prints the average price of the products in the product list
	 * 
	 * @Time - O(1)
	 */
	public void calculateAverageprice() {
		if (productMap.size() == 0) {
			System.out.println("No products are in the list");
			return;
		}

		System.out.println("Average Product Price: $" + (averagePrice / productMap.size()));
	}
}
