package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Log {
	private Queue<String> log = new LinkedList<>();
//log keeps track of all incoming and outgoing transactions in a queue, and then prints them to a file in printLog();
	public void logAddMoney(String moneyAdded, BigDecimal currentMoney) {
		log.add(String.format("%-43s%-12s%s", logDate() + " FEED MONEY: ", "$" + new BigDecimal(moneyAdded).setScale(2),
				"$" + currentMoney));
	}

	public void logPurchase(BigDecimal prePurchaseMoney, String itemName, BigDecimal currentMoney) {
		log.add(String.format("%-43s%-12s%s", logDate() + " " + itemName, "$" + prePurchaseMoney, "$" + currentMoney));
	}

	public String logDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
		Date date = new Date();
		return dateFormat.format(date);
	}
	public void printLog() {
		File file = new File("Log.txt");
			try (PrintWriter writer = new PrintWriter(file)){
				
				while(!log.isEmpty())
				{
					writer.println(log.poll());
				}
			} catch (FileNotFoundException e) {
				System.out.println("File not found.");
			}
			
	}
	public Queue<String> getLog() {
		return log;
	}
}
