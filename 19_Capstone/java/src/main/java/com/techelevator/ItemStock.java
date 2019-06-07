package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class ItemStock 
{
	private Map<String, Integer> inventory = new HashMap<>();
	
	

	public Map<String, Integer> getInventory() {
		return inventory;
	}

	public void setInventory(Map<String, Integer> inventory) {
		this.inventory = inventory;
	}
	
	public void deductInventory(Map<String, Integer> inventory, String key) {
		this.inventory.put(key,  new Integer(this.inventory.get(key).intValue() -1));
	}
}
