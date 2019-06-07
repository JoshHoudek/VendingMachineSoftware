package com.techelevator;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class LogTests {
	Log log;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void queueTest() {
		log = new Log();
		log.logAddMoney("10", new BigDecimal(5));
		log.logPurchase(new BigDecimal(5), "u bought this", new BigDecimal(3));
		Assert.assertEquals((String.format("%-43s%-12s%s", log.logDate() + " FEED MONEY: ", "$" + new BigDecimal("10").setScale(2),
				"$" + new BigDecimal(5))), log.getLog().poll());
		Assert.assertEquals(String.format("%-43s%-12s%s", log.logDate() + " " + "u bought this", "$" + new BigDecimal(5), "$" + new BigDecimal(3)), log.getLog().poll());
		
	}

}
