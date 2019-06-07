package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChipTests {
	Chip chip = null;

	@Before
	public void setUp() {
		chip = new Chip(new BigDecimal(1.25), "Test Chip");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testThatConstructorWorksForChipName() {
		Assert.assertEquals("Test Chip", chip.getProductName());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testThatConstructorWorksForChipPrice() {
		Assert.assertEquals(new BigDecimal(1.25), chip.getPrice());
	}
}
