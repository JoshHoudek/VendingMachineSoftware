package com.techelevator;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		FindAndReplace findAndReplace = new FindAndReplace();

		System.out.println("Please enter the source file:");
		String sourceFileString = in.nextLine();

		File file = new File(sourceFileString);

		System.out.println("Please enter the destination file:");
		String destinationFileString = in.nextLine();

		// alices_adventures_in_wonderland.txt
		File destinationFile = new File(destinationFileString);

		System.out.print("Please enter the search word: ");
		String searchWord = in.nextLine();

		System.out.print("Please enter the word to replace the search word with: ");
		String replacementWord = in.nextLine();

		try {
			Scanner sourceFile = new Scanner(file);

			PrintWriter writer = new PrintWriter(destinationFile);

			findAndReplace.writeCopy(searchWord, replacementWord, writer, sourceFile);
		} catch (Exception e) {

			System.out.println("You entered an invalid file");
			System.exit(1);
		}

	}

	public void writeCopy(String searchWord, String replacementWord, PrintWriter writer, Scanner sourceFile) {

		while (sourceFile.hasNextLine()) {
			String nextLine = sourceFile.nextLine();
			nextLine = nextLine.replaceAll(searchWord, replacementWord);
			writer.println(nextLine);

		}

	}
}
