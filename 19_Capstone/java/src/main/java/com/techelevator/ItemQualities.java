package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class ItemQualities {
	Map<String, Product> idMap = new HashMap<>();
//map which holds the item location IDs as keys and product objects as values
	public Map<String, Product> getIdMap() {
		return idMap;
	}

}
