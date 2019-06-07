package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class InventoryLoaderTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void inventoryLoaderTests() {
		ItemQualities itemQualities = new ItemQualities();
		ItemStock itemStock = new ItemStock();
		InventoryLoader inventoryLoader = new InventoryLoader();
		inventoryLoader.InventoryLoader(itemQualities, itemStock);
		Assert.assertTrue(itemQualities.getIdMap().containsKey("A1"));
		Assert.assertTrue(itemQualities.getIdMap().containsKey("D2"));
		Assert.assertTrue(itemQualities.getIdMap().containsKey("C3"));
		Assert.assertTrue(itemQualities.getIdMap().containsKey("B4"));
	}

}
