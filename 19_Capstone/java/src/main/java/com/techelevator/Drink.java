package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Product {

	String message = "Glug Glug, Yum!";
	public Drink(BigDecimal price, String productName) {
		super(price, productName);
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
}
