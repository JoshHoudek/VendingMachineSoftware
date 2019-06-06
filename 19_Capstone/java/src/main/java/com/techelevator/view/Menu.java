package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

import com.techelevator.CashBox;
import com.techelevator.ItemQualities;
import com.techelevator.ItemStock;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public int mainMenu(ItemQualities itemQualities, ItemStock itemStock) {

		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		Scanner scanner = new Scanner(System.in);
		String scannerStatus = scanner.nextLine();
		// main menu. if user types 1, loops through and lists all product values onto
		// the console
		if (scannerStatus.equals("1")) {
			System.out.println(String.format("%-4s%-22s%-7s%s", "ID", "Product Name", "Price", "Qty Left"));

			for (String keys : itemQualities.getIdMap().keySet()) {
				// future note: account for SOLD OUT
				System.out.println(String.format("%-4s%-22s%-9s%s", keys,
						itemQualities.getIdMap().get(keys).getProductName(),
						"$" + itemQualities.getIdMap().get(keys).getPrice(), itemStock.getInventory().get(keys)));

			}
		} else if (scannerStatus.equals("2")) {
			purchaseMenu(itemQualities, itemStock);

		}

		itemStock.getInventory();
		int userResponse = 0;

		return userResponse;
	}

	public void purchaseMenu (ItemQualities itemQualities, ItemStock itemStock) 
	{
		CashBox cashBox = new CashBox();
		boolean stayOnPurchaseMenu = true;
		
		while (stayOnPurchaseMenu == true) 
		{
			System.out.println("(1) Feed Money");
			System.out.println("(2) Select Product");
			System.out.println("(3) Finish Transaction");
			System.out.println("Current Money Provided: $" + cashBox.getConsumerBalance());
			
			Scanner scanner = new Scanner(System.in);
			String scannerStatus = scanner.nextLine();
		/////new comment
			if (scannerStatus.equals("1")) 
			{
				System.out.println("How much money would you like to deposit?");
				
				String depositAmount = scanner.nextLine();
				///ask experts about try catch exceptions 2mrw
				BigDecimal depositBDAmount = new BigDecimal(depositAmount);
				double depositDouble = depositBDAmount.doubleValue();
				System.out.println(depositBDAmount);
				boolean wholeNumber = depositBDAmount.equals(depositBDAmount.ROUND_DOWN);
				System.out.println(depositBDAmount);
				boolean positiveNumber = depositBDAmount.doubleValue() > 0;
				
				System.out.println(depositBDAmount.doubleValue());
				if(depositDouble != (int)depositDouble||!positiveNumber)
				{
					System.out.println("not a valid amount dumbass");	
				}
				else 
				{					
					cashBox.addConsumerBalance(depositBDAmount);
				}
				
			}
			else if (scannerStatus.equals("2")) 
			{
				System.out.println("Please enter the ID location of the item you want to buy");
				String buyThisID = scanner.nextLine();
				
				////try catch to make sure id is valid********
				if (!itemQualities.getIdMap().containsKey(buyThisID)) {
					System.out.println("You entered an invalid key. Try again!");	
				} else if (itemStock.getInventory().get(buyThisID) < 1){
					System.out.println("That item is out of stock! Buy something else!");	
				} else {
					itemStock.deductInventory(itemStock.getInventory(), buyThisID);
					
					
				}
				
			}
		}
	}
		
	

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);

	}

}
