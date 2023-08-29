package com.deloitte.main;

import java.util.Scanner;

import com.deloitte.model.Product;

public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Welcome to Product Management System!\n");

			mainUtility(sc);
		} catch (Exception e) {
			System.out.println("Some error has occured. Try restarting the program");
		}
	}

	/**
	 * Utility function for the main method to loop the menu prompt
	 * 
	 * @param sc
	 */
	public static void mainUtility(Scanner sc) {
		boolean performAction = true;
		int choice = -1;
		ProductManagementSystem pms = new ProductManagementSystem();

		while (performAction) {
			choice = menuPrompt(sc);

			switch (choice) {
			case 1:
				pms.addProduct(getProductDetails(sc));
				break;
			case 2:
				pms.displayAllProducts();
				sc.nextLine();
				break;
			case 3:
				pms.findProductById(getProductId(sc));
				break;
			case 4:
				pms.removeProductById(getProductId(sc));
				break;
			case 5:
				pms.calculateAverageprice();
				sc.nextLine();
				break;
			case 6:
				performAction = false;
				break;
			default:
				System.out.println("Invalid input!");
				sc.nextLine();
			}

			if (performAction) {
				System.out.print("\nDo you want to re-run the program? [Y/N]: ");

				String reRun = sc.nextLine();
				performAction = reRun.equals("Y") || reRun.equals("y") ? true : false;
			}
		}
		
		System.out.println("Product Management System terminated. Goodbye!");
	}

	
	/**
	 * Gets the input of the Product Id
	 * 
	 * @param sc
	 * @return
	 */
	private static String getProductId(Scanner sc) {
		String productId = "";

		try {
			sc.nextLine();
			System.out.print("Enter Product ID to find: ");
			productId = sc.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid input!");
		}

		return productId;
	}

	
	/**
	 * Gets the product details
	 * 
	 * @Time O(1)
	 * @param sc
	 * @return
	 */
	private static Product getProductDetails(Scanner sc) {
		int productId;
		String productName = "";
		double price = 0.0;

		System.out.print("Enter Product ID: ");
		productId = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Product Name: ");
		productName = sc.nextLine();
		System.out.print("Enter Product Price: ");
		price = sc.nextDouble();
		sc.nextLine();

		return new Product(productId, productName, price);
	}

	
	/**
	 * Takes the choice input for the feature menu
	 * 
	 * @param sc
	 * @return int 
	 */
	public static int menuPrompt(Scanner sc) {
		int choice = -1;

		System.out.println("\n1. Add Product");
		System.out.println("2. Display All Products");
		System.out.println("3. Find Product by ID");
		System.out.println("4. Remove Product by ID");
		System.out.println("5. Calculate Average Price");
		System.out.println("6. Exit\n");

		System.out.print("Enter your choice: ");

		try {
			choice = sc.nextInt();
		} catch (Exception e) {
			choice = -1;
		}

		return choice;
	}
}
