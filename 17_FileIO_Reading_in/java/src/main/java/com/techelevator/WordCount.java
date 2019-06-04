package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WordCount {
	public static void main(String[] args) {
		
		File file = new File("alices_adventures_in_wonderland.txt");
		int wordCounter = 0;
		int sentenceCounter = 0;
		String test = "ladsdgfsdfanb";
		hasLetters(test);
		
		try (Scanner in = new Scanner(file)) {
			while (in.hasNextLine()) {
				String line = in.nextLine();
				
				wordCounter += getWordCount(line);
				
				sentenceCounter += getSentenceCount(line);
							
			}
		} catch (Exception e) {
			System.out.println("File not found");
		}
		
		System.out.println("The number of words in the document is: " + wordCounter);
		System.out.println("The number of sentences in the document is: " + sentenceCounter);
	}
	private static int getSentenceCount(String line) {
		String[] wordCount = line.split(" ");
		int sentenceCounter = 0;
		for(int i = 0; i < wordCount.length; i++)
		{
			if(wordCount[i].contains(".")||wordCount[i].contains("?")||wordCount[i].contains("!"))
			{
				sentenceCounter += 1;
			}
		}
		return sentenceCounter;
	}
	private static int getWordCount(String line) 
	{
		String[] sentenceCount = line.split(" ");
		int wordCounter = 0;
		for(int i = 0; i < sentenceCount.length; i++)
		{
			if(hasLetters(sentenceCount[i]))
			{
				wordCounter += 1;
			}
			
		}	
		return wordCounter;
	}
	public static boolean hasNumeral(String test)
	{
		if(test.contains("0"))
		{
			return true;
		}
		if(test.contains("1"))
		{
			return true;
		}
		if(test.contains("2"))
		{
			return true;
		}
		if(test.contains("3"))
		{
			return true;
		}
		if(test.contains("4"))
		{
			return true;
		}
		if(test.contains("5"))
		{
			return true;
		}
		if(test.contains("6"))
		{
			return true;
		}
		if(test.contains("7"))
		{
			return true;
		}
		if(test.contains("8"))
		{
			return true;
		}
		if(test.contains("9"))
		{
			return true;
		}
		
		return false;
	}
	public static boolean hasLetters(String test)
	{
		if(Pattern.matches("[a-zA-Z'-.,?!]+", test))
		{
			return true;
		}
		return false;
	}
}
