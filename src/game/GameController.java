package game;

import enums.GameStatus;
import io.ConsolePrinter;
import io.DataReader;

public class GameController {
	private GameStatus gameStatus = GameStatus.GAME_IN_PROGRESS;
	private Statistics statistics = new Statistics();
	private Game game = new Game();

	
	public void mainLoop() {
		boolean isNextRound = true;
		do {
			playSingleRound();
			isNextRound = validateNextRound();
		} while (isNextRound);
	}

	private boolean validateNextRound() {
		DataReader dataReader = new DataReader();
		ConsolePrinter printer = new ConsolePrinter();
		printer.printLine("Do you want to play again? Press 'Y' to continue, or any key to quit");
		if (dataReader.readCharacter() == 'Y') {
			return true;
		}
		return false;
	}

	private void playSingleRound() {
		doPlayersMoves();
		updateGame();
		displayInfo();
	}

	private void doPlayersMoves() {
		game.getPlayersChoices();
	}

	private void updateGame() {
		gameStatus = updateStatus();
		updateStatistics();
	}

	private GameStatus updateStatus() {
		return game.updateStatus();
	}

	private void updateStatistics() {
		statistics.update(gameStatus);
	}

	private void displayInfo() {
		displayResult();
		displayStatistics();
	}

	private void displayStatistics() {
		statistics.printStats();
	}

	private void displayResult() {
		game.displayResult(gameStatus);
	}
}
