package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class KataNumbersToWords {
	Map<Integer, String> conversionMap = new HashMap<Integer, String>();

	public String convertIntToWordString(int n) {
		firstTwentyMap();

		String answer = "";
		if (n >= 1000) {
			answer += threeDigitSet(n / 1000) + " thousand";
			if (n % 1000 != 0) {
				answer += " and " + threeDigitSet(n % 1000);
			}
		} else {
			answer += threeDigitSet(n);
		}
		return answer;
	}

	public String threeDigitSet(int n) {
		String answer = "";
		if (n < 100) {
			answer += getUnderHundred(n);
		} else if (n < 1000) {
			answer += getUnderThousand(n);
			n = n % 100;
			if (n != 0) {
				answer += " and ";
				answer += getUnderHundred(n);
			}
		}

		return answer;
	}

	public String getUnderHundred(int n) {
		if (n < 21) {
			return conversionMap.get(n);
		} else {

			if (n % 10 == 0) {
				return conversionMap.get((n / 10) * 10);
			} else {
				return conversionMap.get((n / 10) * 10) + "-" + conversionMap.get(n % 10);
			}
		}
	}

	public String getUnderThousand(int n) {
		String answer = "";
		answer += conversionMap.get(n / 100) + " ";
		answer += "hundred";
		return answer;
	}

	private void firstTwentyMap() {

		conversionMap.put(new Integer(0), "zero");
		conversionMap.put(new Integer(1), "one");
		conversionMap.put(new Integer(2), "two");
		conversionMap.put(new Integer(3), "three");
		conversionMap.put(new Integer(4), "four");
		conversionMap.put(new Integer(5), "five");
		conversionMap.put(new Integer(6), "six");
		conversionMap.put(new Integer(7), "seven");
		conversionMap.put(new Integer(8), "eight");
		conversionMap.put(new Integer(9), "nine");
		conversionMap.put(new Integer(10), "ten");
		conversionMap.put(new Integer(11), "eleven");
		conversionMap.put(new Integer(12), "twelve");
		conversionMap.put(new Integer(13), "thirteen");
		conversionMap.put(new Integer(14), "fourteen");
		conversionMap.put(new Integer(15), "fifteen");
		conversionMap.put(new Integer(16), "sixteen");
		conversionMap.put(new Integer(17), "seventeen");
		conversionMap.put(new Integer(18), "eighteen");
		conversionMap.put(new Integer(19), "nineteen");
		conversionMap.put(new Integer(20), "twenty");
		conversionMap.put(new Integer(30), "thirty");
		conversionMap.put(new Integer(40), "forty");
		conversionMap.put(new Integer(50), "fifty");
		conversionMap.put(new Integer(60), "sixty");
		conversionMap.put(new Integer(70), "seventy");
		conversionMap.put(new Integer(80), "eighty");
		conversionMap.put(new Integer(90), "ninety");
	}
}
