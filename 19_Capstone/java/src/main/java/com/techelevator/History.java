package com.techelevator;

import java.util.LinkedList;
import java.util.Queue;

public class History {
	private Queue<String> consumptionQueue = new LinkedList<String>();
	private Queue<String> transactionQueue = new LinkedList<String>();

	public void printConsumption()
	{
		////maybe bad
		for(String value : consumptionQueue) {
			System.out.println(consumptionQueue.poll());
			
		}
	}
	
	public void appendConsumption(String message) {
		consumptionQueue.offer(message);
	}
	public void appendTransaction(String message) {
		transactionQueue.offer(message);
	}
}
