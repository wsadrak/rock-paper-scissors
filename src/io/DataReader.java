package io;

import java.util.Scanner;

public class DataReader {
	private Scanner scanner = new Scanner(System.in);

	public char readCharacter() {
		String value = scanner.nextLine();
		return value.toUpperCase().charAt(0);
	}
}
