package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class ItemStock 
{
	Map<String, Integer> inventory = new HashMap<>();
	
	

	public Map<String, Integer> getInventory() {
		return inventory;
	}

	public void setInventory(Map<String, Integer> inventory) {
		this.inventory = inventory;
	}
}
