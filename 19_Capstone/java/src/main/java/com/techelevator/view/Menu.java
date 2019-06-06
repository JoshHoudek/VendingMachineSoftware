package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import com.techelevator.ItemQualities;
import com.techelevator.ItemStock;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public int mainMenu(ItemQualities itemQualities, ItemStock itemStock) {
				
		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		Scanner scanner = new Scanner(System.in);
		if (scanner.nextLine().equals("1")) {
			
			
			
			
			// do 1 stuff
		} else if (scanner.nextLine().equals("2")) {
			//go to purchase menu
		}
		
		itemStock.getInventory();
		int userResponse= 0;
		
		
		return userResponse;
	}
	
	public void purchaseMenu (ItemQualities itemQualities, ItemStock itemStock) {
		
		
		
	}
	
	
	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
		
		
		
	}


}
