package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Product {

	String message = "Chew Chew, Yum!";

	public Gum(BigDecimal price, String productName) {
		super(price, productName);
		// TODO Auto-generated constructor stub
	}
	public BigDecimal getPrice() {
		return super.getPrice();
	}

	public String getProductName() {
		return super.getProductName();
	}
	public String getMessage() {
		return message;
	}

}
