package com.techelevator;

import java.math.BigDecimal;

public class CashBox 
{
	private BigDecimal consumerBalance = new BigDecimal(0).setScale(2);
	
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
	public void resetConsumerBalance(BigDecimal money)
	{
		//test me
		//calculate change and print it
		consumerBalance = new BigDecimal(0);
	}
	public BigDecimal getConsumerBalance() {
		return consumerBalance;
	}
}
