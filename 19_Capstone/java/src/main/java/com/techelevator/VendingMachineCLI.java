package com.techelevator;

import com.techelevator.ItemQualities;
import com.techelevator.view.Menu;

public class VendingMachineCLI {
	
	private Menu menu;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run(ItemQualities itemQualities, ItemStock itemStock) {
		while(true) {
			menu.mainMenu(itemQualities, itemStock);
			
			
			/*
			 *  Display the Starting menu and get the user's choice
			 *  
			 *  IF the User Choice is 'Display Vending Machine Items
			 *     THEN display vending machine items.
			 *  ELSE if the User's Choice is Purchase
			 *     THEN go to purchase menu
			 *  ETC...   
			 *     
			 *  HINT:  This code should be fairly clean. Make sure you delegate to other classes and / or methods to keep this code as clean as possible   
			 *  
			 *  ANOTHER HINT - DO NOT START CODING until you have gone through the design process or Steve will be an unhappy camper. Steve
			 *  only likes to be a happy camper. He likes smores, campfires and adult beverages. 
			 *  
			 *  ANOTHER HINT - You got this!  Remember this is FUN!!!  You "GET" to do this! You could be driving a septic cleaning truck right now, cleaning 
			 *  septic tanks.  
			 *  
			 *  ANOTHER HINT - Be a good pair partner and be nice to each other!
			 *  
			 *  ANOTHER HINT - DELETE these comments. Or your program will self-destruct in 3 2 1 ..... (But DO add comments to your code so your code is easy to 
			 *  follow.  Before completing, make sure all code compiles, dead/unised code is removed, and stuff is well formatted for readability/whitespace, etc.
			 *     
			 */

		}
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		
		InventoryLoader loader = new InventoryLoader();
		ItemQualities itemQualities = new ItemQualities();
		ItemStock itemStock = new ItemStock();
		loader.InventoryLoader(itemQualities, itemStock);
		
		cli.run(itemQualities, itemStock);

	}
}
