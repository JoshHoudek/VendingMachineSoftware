package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrinkTests {
	Drink drink = null;

	@Before
	public void setUp() {
		drink = new Drink(new BigDecimal(1.55), "Test Drink");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testThatConstructorWorksForDrinkName() {
		Assert.assertEquals("Test Drink", drink.getProductName());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testThatConstructorWorksForDrinkPrice() {
		Assert.assertEquals(new BigDecimal(1.55), drink.getPrice());
	}

}
