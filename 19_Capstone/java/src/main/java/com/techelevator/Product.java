package com.techelevator;

import java.math.BigDecimal;

public abstract class Product 
{
	private BigDecimal price;
	private String productName;
	private String message;
	
	public Product(BigDecimal price, String productName)
	{
		this.price = price;
		this.productName = productName;
	}
	

	public String getMessage() {
		return message;
	}


	public BigDecimal getPrice() {
		return price;
	}

	public String getProductName() {
		return productName;
	}
}