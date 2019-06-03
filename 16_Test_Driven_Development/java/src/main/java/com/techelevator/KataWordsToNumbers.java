package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class KataWordsToNumbers {
	Map<String, Integer> conversionMap = new HashMap<>();

	public int convertWordToInt(String number) {
		firstTwentyMap();
//		
//		if (number < 21) {
//			
//			if(conversionMap..
//		}
		
		
		return conversionMap.get(number).intValue();
	}
	private void firstTwentyMap() {
	
		conversionMap.put("zero", new Integer(0));
		conversionMap.put("one", new Integer(1));
		conversionMap.put("two", new Integer(2));
		conversionMap.put("three", new Integer(3));
		conversionMap.put("four", new Integer(4));
		conversionMap.put("five", new Integer(5));
		conversionMap.put("six", new Integer(6));
		conversionMap.put("seven", new Integer(7));
		conversionMap.put("eight", new Integer(8));
		conversionMap.put("nine", new Integer(9));
		conversionMap.put("ten", new Integer(10));

	}
}