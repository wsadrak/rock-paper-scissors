package model;

import enums.Choices;
import io.ConsolePrinter;
import io.DataReader;

public class Player {
	private ConsolePrinter printer = new ConsolePrinter();
	private DataReader dataReader = new DataReader();
	public Choices getChoice() {
	
		printer.printLine("Please enter your choice: R=ROCK, P=PAPER, S=SCISSORS");
		char playerChoice = dataReader.readCharacter();
		
	
		switch(playerChoice) {
		case 'R':
			return Choices.ROCK;
		case 'P':
			return Choices.PAPER;
		case 'S':
			return Choices.SCISSORS;
		}
		printer.printLine("Invalid input!");
		return getChoice();
	}

}
