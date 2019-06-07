package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ItemStockTests {

	@Before
	public void setUp() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		InventoryLoader loader = new InventoryLoader();
		ItemQualities itemQualities = new ItemQualities();
		ItemStock itemStock = new ItemStock();
		loader.InventoryLoader(itemQualities, itemStock);

		Assert.assertEquals(new Integer(5), itemStock.getInventory().get("A1"));
		itemStock.deductInventory(itemStock.getInventory(), "A1");
		Assert.assertEquals(new Integer(4), itemStock.getInventory().get("A1"));
		Assert.assertEquals(new Integer(5), itemStock.getInventory().get("B2"));
		itemStock.deductInventory(itemStock.getInventory(), "B2");
		Assert.assertEquals(new Integer(4), itemStock.getInventory().get("B2"));
	}

}
