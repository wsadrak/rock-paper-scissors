package io;

import java.util.Scanner;

public class DataReader {
	private Scanner scanner = new Scanner(System.in);

	public char readCharacter() {
		String value = scanner.nextLine();
		
		if(value.length() == 0) {
			return ' ';
		}
		return value.toUpperCase().charAt(0);
	}
}
