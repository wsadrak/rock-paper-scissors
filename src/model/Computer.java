package model;

import java.util.Random;

import enums.Choices;

public class Computer implements Player{
	private Random rand = new Random();

	@Override
	public Choices getChoice() {
		int choice = 1 + rand.nextInt(3);
		
		switch(choice) {
		case 1:
			return Choices.ROCK;		case 2:
			return Choices.PAPER;
		}
		return Choices.SCISSORS;
	}

}
