package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class KataWordsToNumbersTest {
	KataWordsToNumbers words = new KataWordsToNumbers();

	@Test
	public void intZeroToTwentyToWordsTest() {
		Assert.assertEquals(0, words.convertWordToInt("zero"));
		Assert.assertEquals(6, words.convertWordToInt("six"));
	}
}