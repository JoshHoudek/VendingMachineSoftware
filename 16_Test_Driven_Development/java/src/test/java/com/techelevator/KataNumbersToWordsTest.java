package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class KataNumbersToWordsTest {
	KataNumbersToWords number = new KataNumbersToWords();

	@Test
	public void intZeroToTwentyToWordsTest() {
		Assert.assertEquals("zero", number.convertIntToWordString(0));
		Assert.assertEquals("one", number.convertIntToWordString(1));
		Assert.assertEquals("eleven", number.convertIntToWordString(11));
		Assert.assertEquals("twenty", number.convertIntToWordString(20));
	}

	@Test
	public void intTwentyOneToNinetyNineToWordsTest() {
		Assert.assertEquals("thirty-five", number.convertIntToWordString(35));
		Assert.assertEquals("ninety-nine", number.convertIntToWordString(99));
		Assert.assertEquals("ninety", number.convertIntToWordString(90));

	}
	@Test
	public void intOneHundredToNineHundredNinetyNineWordsTest() {
		Assert.assertEquals("one hundred and eleven", number.convertIntToWordString(111));

		Assert.assertEquals("one hundred", number.convertIntToWordString(100));

		Assert.assertEquals("six hundred", number.convertIntToWordString(600));

		Assert.assertEquals("two hundred and seven", number.convertIntToWordString(207));
		Assert.assertEquals("six hundred and sixty-six", number.convertIntToWordString(666));
		Assert.assertEquals("nine hundred and ninety-nine", number.convertIntToWordString(999));

	}
	@Test
	public void intOneThousandToOneMillionWordsTest() {
		Assert.assertEquals("one thousand", number.convertIntToWordString(1000));

		Assert.assertEquals("eleven thousand and two hundred and twenty-two", number.convertIntToWordString(11222));

		Assert.assertEquals("five hundred thousand", number.convertIntToWordString(500000));
		Assert.assertEquals("three hundred and thirty-three thousand and three hundred and thirty-three", number.convertIntToWordString(333333));
		Assert.assertEquals("nine hundred and ninety-nine thousand and nine hundred and ninety-nine", number.convertIntToWordString(999999));

	}
	
	
	
	
}
