package com.techelevator;

import com.techelevator.ItemQualities;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run(ItemQualities itemQualities, ItemStock itemStock) {
		while (true) {
			menu.mainMenu(itemQualities, itemStock);

		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		VendingMachineCLI cli = new VendingMachineCLI(menu);

		InventoryLoader loader = new InventoryLoader();
		ItemQualities itemQualities = new ItemQualities();
		ItemStock itemStock = new ItemStock();
		loader.InventoryLoader(itemQualities, itemStock);

		cli.run(itemQualities, itemStock);

	}
}
