package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

import com.techelevator.CashBox;
import com.techelevator.ItemQualities;
import com.techelevator.ItemStock;
import com.techelevator.exceptions.UnableToPurchaseException;

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
			purchaseMenu(itemQualities, itemStock, scanner);

		}
		else if(scannerStatus.equals("3"))
		{
			
		}

		itemStock.getInventory();
		int userResponse = 0;

		return userResponse;
	}

	public void purchaseMenu(ItemQualities itemQualities, ItemStock itemStock, Scanner scanner) {
		CashBox cashBox = new CashBox();
		boolean stayOnPurchaseMenu = true;

		while (stayOnPurchaseMenu == true) {
			String response = readPurchaseMenu(cashBox, scanner);

			///// new comment
			if (response.equals("1")) {
				try {
					depositMoney(cashBox, scanner);
				} catch (Exception e) {
					System.out.println("This machine only accepts 1's, 2's, 5's, and 10's");
				}
			} else if (response.equals("2")) {
				selectItem(cashBox, itemStock, itemQualities, scanner);
				

				

			}
		}

	}

	private void selectItem(CashBox cashBox, ItemStock itemStock, ItemQualities itemQualities, Scanner scanner) {
		System.out.println("Please enter the ID location of the item you want to buy");
		String buyThisID = scanner.nextLine();

		try {
			verifySelectItem(itemQualities, itemStock, buyThisID, cashBox);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	public void verifySelectItem(ItemQualities itemQualities, ItemStock itemStock, String buyThisID, CashBox cashBox) throws UnableToPurchaseException {
		UnableToPurchaseException insufficient = new UnableToPurchaseException("You do not have enough money to purchase this item.");
		UnableToPurchaseException invalidID = new UnableToPurchaseException("Please enter a valid item ID.");
		UnableToPurchaseException outOfStock = new UnableToPurchaseException("That item is out of stock! Buy something else!");
	//// try catch to make sure id is valid********
			if (!itemQualities.getIdMap().containsKey(buyThisID)) {
				throw invalidID;
			} else if (itemStock.getInventory().get(buyThisID) < 1) {
				throw outOfStock;
			} else if (itemQualities.getIdMap().get(buyThisID).getPrice().compareTo(cashBox.getConsumerBalance()) > 0) {
				throw insufficient;
			}
			 else {
				itemStock.deductInventory(itemStock.getInventory(), buyThisID);
				cashBox.deductConsumerBalance(itemQualities.getIdMap().get(buyThisID).getPrice());
				
			}
		
	}

	private void depositMoney(CashBox cashBox, Scanner scanner) throws Exception {
		System.out.println("How much money would you like to deposit?");
		String depositAmount = scanner.nextLine();
		try {
			verifyDepositAmount(depositAmount);
			cashBox.addConsumerBalance(new BigDecimal(depositAmount));
		} catch (Exception e) {
			throw new Exception();
		}

	}

	private void verifyDepositAmount(String depositAmount) throws Exception {
		Double doubleDeposit = Double.valueOf(depositAmount);
		if (doubleDeposit != 1 && doubleDeposit != 2 && doubleDeposit != 5 && doubleDeposit != 10) {
			throw new Exception();
		}

	}

	private String readPurchaseMenu(CashBox cashBox, Scanner scanner) {
		System.out.println("(1) Feed Money");
		System.out.println("(2) Select Product");
		System.out.println("(3) Finish Transaction");
		System.out.println("Current Money Provided: $" + cashBox.getConsumerBalance());

	
		String scannerStatus = scanner.nextLine();
		return scannerStatus;
	}

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);

	}

}
