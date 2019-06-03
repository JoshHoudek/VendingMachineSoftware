package com.techelevator;

public class KataStringCalculator 
{
	public int add(String numbers)
	{
		int sum = 0;
		
		if(numbers.length() > 0)
		{
			numbers = numbers.replaceAll("\n", ",");
			String[] splitNumbers = numbers.split(",");
			for(int i = 0; i < splitNumbers.length; i ++)
			{
				sum += Integer.parseInt(splitNumbers[i]);
			}
		}
		return sum;
	}
}
