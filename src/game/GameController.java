package app;

import enums.Choices;
import enums.GameStatus;
import io.ConsolePrinter;
import io.DataReader;
import model.Computer;
import model.Player;
import model.Stats;

public class GameController {
	DataReader dataReader = new DataReader();
	ConsolePrinter printer = new ConsolePrinter();
	private GameStatus gameStatus;
	private Player player;
	private Computer computer;
	private Choices playerChoice;
	private Choices computerChoice;
	private static int ties = 0;
	private static int loses = 0;
	private static int wins = 0;
	
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
		updateStats();
		displayResult();
	}

	private void updateStats() {
		if(gameStatus == GameStatus.WIN) {
			wins++;
		} else if(gameStatus == GameStatus.TIE) {
			ties++;
		} else if(gameStatus == GameStatus.LOSE) {
			loses++;
		}
	}

	private void displayResult() {
		
		printer.printLine("Player: " + playerChoice);
		printer.printLine("Computer: " + computerChoice);
		
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
		printer.printLine("You've played " + (wins + ties + loses) + " games");
		printer.printLine("WINS: " + wins);
		printer.printLine("TIES: " + ties);
		printer.printLine("LOSES: " + loses);
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
