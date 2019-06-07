package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GumTests {
	Gum gum = null;
	@Before
	public void setUp() {
		gum = new Gum(new BigDecimal(1.10), "Test Gum");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testThatConstructorWorksForGumName() {
		
		Assert.assertEquals("Test Gum", gum.getProductName());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testThatConstructorWorksForGumPrice() {
		Assert.assertEquals(new BigDecimal(1.10), gum.getPrice());
	}
	
}
