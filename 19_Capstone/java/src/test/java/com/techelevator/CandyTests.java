package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyTests {
	Candy candy = null;

	@Before
	public void setUp() {
		candy = new Candy(new BigDecimal(1.15), "Test Candy");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testThatConstructorWorksForCandyName() {
		Assert.assertEquals("Test Candy", candy.getProductName());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testThatConstructorWorksForCandyPrice() {
		Assert.assertEquals(new BigDecimal(1.15), candy.getPrice());
	}

}
