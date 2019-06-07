package com.techelevator.view;

import org.junit.Assert;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.CashBox;
import com.techelevator.InventoryLoader;
import com.techelevator.ItemQualities;
import com.techelevator.ItemStock;
import com.techelevator.exceptions.UnableToPurchaseException;

public class MenuTests {
	Menu menu = new Menu(System.in, System.out);
	ItemQualities itemQualities = new ItemQualities();
	ItemStock itemStock = new ItemStock();
	InventoryLoader inventoryLoader = new InventoryLoader();
	CashBox cashBox = new CashBox();

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void verifySelectItemTest() {
		inventoryLoader.InventoryLoader(itemQualities, itemStock);
		cashBox.addConsumerBalance(new BigDecimal(100));

		try {
			menu.verifySelectItem(itemQualities, itemStock, "A1", cashBox);
		} catch (UnableToPurchaseException e) {
		} finally {
			Assert.assertEquals(new Integer(4), itemStock.getInventory().get("A1"));
		}
	}

	@Test
	public void verifyUnsuccessfulSelectItemTest() {
		inventoryLoader.InventoryLoader(itemQualities, itemStock);
		cashBox.addConsumerBalance(new BigDecimal(1));

		try {
			menu.verifySelectItem(itemQualities, itemStock, "A1", cashBox);
		} catch (UnableToPurchaseException e) {
		} finally {
			Assert.assertEquals(new Integer(5), itemStock.getInventory().get("A1"));
		}

	}

	@Test
	public void verifyExactChangeSuccessfulSelectItemTest() {
		inventoryLoader.InventoryLoader(itemQualities, itemStock);
		cashBox.addConsumerBalance(new BigDecimal(3.05));

		try {
			menu.verifySelectItem(itemQualities, itemStock, "A1", cashBox);
		} catch (UnableToPurchaseException e) {
		} finally {
			Assert.assertEquals(new Integer(4), itemStock.getInventory().get("A1"));
		}

	}
}
