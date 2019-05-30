package app;

import enums.Choices;
import enums.GameStatus;
import io.ConsolePrinter;
import io.DataReader;
import model.Computer;
import model.Player;

public class GameController {
	DataReader dataReader = new DataReader();
	ConsolePrinter printer = new ConsolePrinter();
	private GameStatus gameStatus;
	private Player player;
	private Computer computer;
	private Choices playerChoice;
	private Choices computerChoice;
	
	public GameController() {
		gameStatus = GameStatus.GAME_IN_PROGRESS;
		player = new Player();
		computer = new Computer();
	}

	public void mainLoop() {
		char value = ' ';

		while (value != 'N') {
			play();
			printer.printLine("Do you want to play again? Press any key to continue, or 'N' to quit");
			value = dataReader.readCharacter();
		}
		printer.printLine("bye");

	}

	private void play() {
		playerChoice = player.getChoice();
		computerChoice = computer.getChoice();
		gameStatus = updateStatus();
		displayResult();
	}

	private void displayResult() {
		switch(gameStatus) {
		case WIN:
			printer.printLine(playerChoice + " beats " + computerChoice + ". Player WINS");
			break;
		case LOSE:
			printer.printLine(playerChoice + " lose to " + computerChoice + ". Computer WINS");
			break;
		case TIE:
			printer.printLine(playerChoice + " equals to " + computerChoice + ". It's TIE");
			break;
		case GAME_IN_PROGRESS:
			printer.printLine("something went wrong");
			break;
		}
	}

	private GameStatus updateStatus() {
		if(playerChoice == computerChoice) {
			return GameStatus.TIE;
		}
		
		switch(playerChoice) {
		case ROCK:
			return (computerChoice == Choices.SCISSORS ? GameStatus.WIN : GameStatus.LOSE);
		case PAPER:
			return (computerChoice == Choices.ROCK ? GameStatus.WIN : GameStatus.LOSE);
		case SCISSORS:
			return (computerChoice == Choices.PAPER ? GameStatus.WIN : GameStatus.LOSE);
		}
		
		return null;
	}

}
