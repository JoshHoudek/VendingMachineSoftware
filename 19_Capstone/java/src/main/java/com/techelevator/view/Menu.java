package com.techelevator.view;

import java.math.BigDecimal;
import java.util.Scanner;

import com.techelevator.CashBox;
import com.techelevator.ItemQualities;
import com.techelevator.ItemStock;
import com.techelevator.Log;
import com.techelevator.exceptions.UnableToPurchaseException;

public class Menu {

	public void mainMenu(ItemQualities itemQualities, ItemStock itemStock) {
		//Shows main menu options and requests a selection
		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		
		Scanner scanner = new Scanner(System.in);

			String scannerStatus = scanner.nextLine();
			// if user types 1, loops through and lists all product values onto
			// the console
			try{
				if (scannerStatus.equals("1")) {
					//Produces a layout of purchaseable items
					System.out.println(String.format("%-4s%-22s%-9s%s", "ID", "Product Name", "Price", "Qty Left"));
					
					displayVendingMachineItems(itemQualities, itemStock);
							
					
				} else if (scannerStatus.equals("2")) {
					//Moves into the purchase menu
					purchaseMenu(itemQualities, itemStock, scanner);
	
				} else 
				{
					//Throws an exception to inform the user to enter a valid response
					throw new Exception();
					
				}
			}
			catch(Exception e){
				System.out.println("You must enter 1 or 2.");
			}

	}

	public void purchaseMenu(ItemQualities itemQualities, ItemStock itemStock, Scanner scanner) {
		Log log = new Log();
		CashBox cashBox = new CashBox();
		//Initializes and declares secondary objects
		boolean stayOnPurchaseMenu = true;

		while (stayOnPurchaseMenu == true) {
			String response = readPurchaseMenu(cashBox, scanner);
			//Maintains loops while the user selects purchase options
			try
			{
				if (response.equals("1")) {
					//Prompts users to deposit money
					try {
						depositMoney(cashBox, scanner, log);
					} catch (Exception e) {
						System.out.println("This machine only accepts 1's, 2's, 5's, and 10's");
					}
				} else if (response.equals("2")) {
					//Prompts user to select item to purchase
					selectItem(cashBox, itemStock, itemQualities, scanner, log);
	
				} else if (response.equals("3")) {
					//Ends user's transaction
					reset(cashBox);
					log.printLog();
					stayOnPurchaseMenu = false;
					}
				else
				{
					//Throws exception to inform user to enter a valid input
					throw new Exception();
				}
			}
			catch(Exception e)
			{
				System.out.println("You must enter 1, 2, or 3.");
			}
				
		}

	}
	private void displayVendingMachineItems(ItemQualities itemQualities, ItemStock itemStock) {
		//Produces item selections and checks if items are sold out
		String quantity = "";
		for (String keys : itemQualities.getIdMap().keySet()) {
			quantity = itemStock.getInventory().get(keys).toString();
			if(itemStock.getInventory().get(keys).intValue() == 0)
			{
				quantity = "SOLD OUT";
			}
			System.out.println(String.format("%-4s%-22s%-9s%s", keys,
					itemQualities.getIdMap().get(keys).getProductName(),
					"$" + itemQualities.getIdMap().get(keys).getPrice(), quantity));

		}
	}

	

	private void selectItem(CashBox cashBox, ItemStock itemStock, ItemQualities itemQualities, Scanner scanner, Log log) 
	{
		//Receives the ID location of desired item
		System.out.println("Please enter the ID location of the item you want to buy");
		String buyThisID = scanner.nextLine();

		try {
			verifySelectItem(itemQualities, itemStock, buyThisID, cashBox, log);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void verifySelectItem(ItemQualities itemQualities, ItemStock itemStock, String buyThisID, CashBox cashBox, Log log) throws UnableToPurchaseException {
		UnableToPurchaseException insufficient = new UnableToPurchaseException("You do not have enough money to purchase this item.");
		UnableToPurchaseException invalidID = new UnableToPurchaseException("Please enter a valid item ID.");
		UnableToPurchaseException outOfStock = new UnableToPurchaseException("That item is out of stock! Buy something else!");
		//Verifies that the item is purchasable
			if (!itemQualities.getIdMap().containsKey(buyThisID)) {
				throw invalidID;
			} else if (itemStock.getInventory().get(buyThisID) < 1) {
				throw outOfStock;
			} else if (itemQualities.getIdMap().get(buyThisID).getPrice().compareTo(cashBox.getConsumerBalance()) > 0) {
				throw insufficient;
			}
			 else {
				itemStock.deductInventory(itemStock.getInventory(), buyThisID);
				BigDecimal balancePrePurchase = cashBox.getConsumerBalance();
				cashBox.deductConsumerBalance(itemQualities.getIdMap().get(buyThisID).getPrice());
				String logItemString = itemQualities.getIdMap().get(buyThisID).getProductName() + " " + buyThisID;
				log.logPurchase(balancePrePurchase,  logItemString, cashBox.getConsumerBalance());
				
				System.out.println(itemQualities.getIdMap().get(buyThisID).getMessage());
				
			}
		
	}

	private void depositMoney(CashBox cashBox, Scanner scanner, Log log) throws Exception {
		//Receives money and deposits it in the cash box.
		System.out.println("How much money would you like to deposit?");
		String depositAmount = scanner.nextLine();
		try {
			verifyDepositAmount(depositAmount);			
			cashBox.addConsumerBalance(new BigDecimal(depositAmount));
			log.logAddMoney(depositAmount, cashBox.getConsumerBalance());
		} catch (Exception e) {
			throw new Exception();
		}

	}

	private void verifyDepositAmount(String depositAmount) throws Exception {
		//Ensures that the amount of money is a valid increment.
		Double doubleDeposit = Double.valueOf(depositAmount);
		if (doubleDeposit != 1 && doubleDeposit != 2 && doubleDeposit != 5 && doubleDeposit != 10) {
			throw new Exception();
		}

	}

	private String readPurchaseMenu(CashBox cashBox, Scanner scanner) {
		//Reads off the purchase menu selection.
		System.out.println("(1) Feed Money");
		System.out.println("(2) Select Product");
		System.out.println("(3) Finish Transaction");
		System.out.println("Current Money Provided: $" + cashBox.getConsumerBalance());

	
		String scannerStatus = scanner.nextLine();
		return scannerStatus;
	}


	public void reset(CashBox cashBox) {
		//Empties the cash box and returns change to the user.
		int[] change = cashBox.resetConsumerBalance();
		if (change[0] > 0 || change[1] > 0 || change[2] > 0) {
			System.out.print("Your change is");
			if (change[0] > 0) {
				System.out.print(" " + change[0] + " quarter");
				if (change[0] > 1) {
					System.out.print("s");
				}
			}
			if (change[1] > 0) {
				System.out.print(" " + change[1] + " dime");
				if (change[1] > 1) {
					System.out.print("s");
				}
			}
			if (change[2] > 0) {
				System.out.print(" " + change[2] + " nickle");
				if (change[2] > 1) {
					System.out.print("s");
				}
			}
			System.out.println();

		}
	}
}
