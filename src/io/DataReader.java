package io;

import java.util.Scanner;

public class DataReader {
	private Scanner input = new Scanner(System.in);

	public char readCharacter() {
		String character = input.nextLine();
		if (character.length() == 0) {
			return ' ';
		}
		return character.toUpperCase().charAt(0);
	}
}
