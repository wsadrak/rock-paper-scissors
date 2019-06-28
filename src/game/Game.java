package game;

import enums.Choices;
import enums.GameStatus;
import io.ConsolePrinter;
import model.Computer;
import model.Player;
import model.User;

public class Game {
	private ConsolePrinter printer = new ConsolePrinter();

	private Player user = new User();
	private Player computer = new Computer();

	private Choices userChoice;
	private Choices computerChoice;

	public void getPlayersChoices() {
		userChoice = getChoice(user);
		computerChoice = getChoice(computer);
	}

	private Choices getChoice(Player player) {
		return player.getChoice();
	}

	public GameStatus updateStatus() {
		if (userChoice == computerChoice) {
			return GameStatus.TIE;
		}
		switch (userChoice) {
		case ROCK:
			return (computerChoice == Choices.SCISSORS ? GameStatus.WIN : GameStatus.LOSE);
		case PAPER:
			return (computerChoice == Choices.ROCK ? GameStatus.WIN : GameStatus.LOSE);
		case SCISSORS:
			return (computerChoice == Choices.PAPER ? GameStatus.WIN : GameStatus.LOSE);
		}

		return GameStatus.GAME_IN_PROGRESS;
	}

	public void displayResult(GameStatus gameStatus) {
		printer.printLine("User's choice: " + userChoice);
		printer.printLine("Computer's choice: " + computerChoice);
		switch (gameStatus) {
		case WIN:
			printer.printLine(userChoice + " beats " + computerChoice + ". User WINS");
			break;
		case LOSE:
			printer.printLine(userChoice + " lose to " + computerChoice + ". Computer WINS");
			break;
		case TIE:
			printer.printLine(userChoice + " equals to " + computerChoice + ". It's TIE");
			break;
		case GAME_IN_PROGRESS:
			printer.printLine("Game in progress");
			break;
		}
	}

}
