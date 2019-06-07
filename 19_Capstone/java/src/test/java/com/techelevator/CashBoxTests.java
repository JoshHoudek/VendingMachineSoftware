package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CashBoxTests {

	@Before
	public void cashBoxTests() throws Exception {
	}

	@Test
	public void TestLargeDepositAndDeductionAndBalance() {
		CashBox cashBox = new CashBox();

		Assert.assertEquals(cashBox.getConsumerBalance(), new BigDecimal(0).setScale(2, RoundingMode.HALF_UP));

		cashBox.addConsumerBalance(new BigDecimal(666));
		Assert.assertEquals(cashBox.getConsumerBalance(), new BigDecimal(666).setScale(2, RoundingMode.HALF_UP));

		cashBox.deductConsumerBalance(new BigDecimal(66));
		Assert.assertEquals(cashBox.getConsumerBalance(), new BigDecimal(600).setScale(2, RoundingMode.HALF_UP));
		int[] coins = cashBox.resetConsumerBalance();
		Assert.assertArrayEquals(coins, new int[] { 2400, 0, 0 });

		cashBox.addConsumerBalance(new BigDecimal(1.15));
		Assert.assertEquals(new BigDecimal(1.15).setScale(2, RoundingMode.HALF_UP), cashBox.getConsumerBalance());
		coins = cashBox.resetConsumerBalance();
		Assert.assertArrayEquals(new int[] { 4, 1, 1 }, coins);

	}

	@Test
	public void TestSmallerAmountsOfChange() {
		CashBox cashBox = new CashBox();

		cashBox.addConsumerBalance(new BigDecimal(0.40));
		int[] coins = cashBox.resetConsumerBalance();

		Assert.assertArrayEquals(new int[] { 1, 1, 1 }, coins);
	}

}
