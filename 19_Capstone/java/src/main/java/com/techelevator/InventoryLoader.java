package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryLoader {
	// takes inventory and fills with items from input file
	public void InventoryLoader(ItemQualities itemQualities, ItemStock itemStock) {
		Map<String, Integer> stockMap = new HashMap<>();
		Map<String, Product> productMap = new HashMap<>();

		File inventoryFile = new File("vendingmachine.csv");
		try {
			Scanner scanner = new Scanner(inventoryFile);

			while (scanner.hasNextLine()) {
				String nextLine = scanner.nextLine();
				String[] array = nextLine.split("\\|");
				stockMap.put(array[0], 5);

				if (array[3].equals("Chip")) {
					productMap.put(array[0], new Chip(new BigDecimal(array[2]).setScale(2), array[1]));
				} else if (array[3].equals("Gum")) {
					productMap.put(array[0], new Gum(new BigDecimal(array[2]).setScale(2), array[1]));
				} else if (array[3].equals("Candy")) {
					productMap.put(array[0], new Candy(new BigDecimal(array[2]).setScale(2), array[1]));
				} else if (array[3].equals("Drink")) {
					productMap.put(array[0], new Drink(new BigDecimal(array[2]).setScale(2), array[1]));
				}

			}

		} catch (Exception e) {
			System.out.println("File not found");
		}
	}

}
