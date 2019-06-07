package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ItemQualitiesTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void getIdMapTest() {

		InventoryLoader loader = new InventoryLoader();
		ItemQualities itemQualities = new ItemQualities();
		ItemStock itemStock = new ItemStock();
		loader.InventoryLoader(itemQualities, itemStock);
		
		Assert.assertTrue(itemQualities.idMap.containsKey("A1"));
		Assert.assertEquals(itemQualities.idMap.get("A1").getProductName(), "Potato Crisps");
		Assert.assertEquals(itemQualities.idMap.get("A1").getPrice(), new BigDecimal(3.05).setScale(2, RoundingMode.HALF_UP));
		Assert.assertTrue(itemQualities.idMap.containsKey("D4"));
		Assert.assertEquals(itemQualities.idMap.get("D4").getProductName(), "Triplemint");
		Assert.assertEquals(itemQualities.idMap.get("D4").getPrice(), new BigDecimal(0.75).setScale(2, RoundingMode.HALF_UP));
	}

}
