package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashBox 
{
	private BigDecimal consumerBalance = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
	
	public void addConsumerBalance(BigDecimal money)
	{
		//test me
		consumerBalance = consumerBalance.add(money);
	}
	public void deductConsumerBalance(BigDecimal money)
	{
		//test me
		consumerBalance = consumerBalance.subtract(money);
	}
	public int[] resetConsumerBalance()
	{
		int[] coins = new int[3];
		double totalChange= this.getConsumerBalance().setScale(2, RoundingMode.HALF_UP).doubleValue() * 100;
		totalChange = Math.round(totalChange);
		coins[0] = (int)(totalChange/25);
		totalChange = totalChange%25;
		coins[1] = (int)(totalChange/10);
		totalChange = totalChange%10;
		coins[2] = (int)(totalChange/5);
		
		consumerBalance = new BigDecimal(0);
		
		return coins;
	}
	public BigDecimal getConsumerBalance() {
		return consumerBalance.setScale(2, RoundingMode.HALF_UP);
	}
}
