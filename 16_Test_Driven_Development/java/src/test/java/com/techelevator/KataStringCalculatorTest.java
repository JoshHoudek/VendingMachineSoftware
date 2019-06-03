package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataStringCalculatorTest 
{
	KataStringCalculator calc = new KataStringCalculator();
	@Test
	public void basicTest()
	{	
		Assert.assertEquals(0, calc.add(""));
		Assert.assertEquals(1, calc.add("1"));
		Assert.assertEquals(5,  calc.add("2,3"));
		Assert.assertEquals(12,  calc.add("12"));
		Assert.assertEquals(24, calc.add("5,7,12"));
		Assert.assertEquals(10, calc.add("5\n3,2"));
		Assert.assertEquals(14, calc.add("3\n5\n2,4"));
	}
}
