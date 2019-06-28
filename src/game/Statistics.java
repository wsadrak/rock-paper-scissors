package game;

import enums.GameStatus;
import io.ConsolePrinter;

public class Statistics {
	private int wins = 0;
	private int ties = 0;
	private int loses = 0;
	private ConsolePrinter printer = new ConsolePrinter();

	public void printStats() {
		printer.printLine("You've played " + (wins+loses+ties) + " games");
		printer.printLine("WINS: " + wins);
		printer.printLine("TIES: " + ties);
		printer.printLine("LOSES: " + loses);
	}

	 public void update(GameStatus gameStatus) {
		if (gameStatus == GameStatus.WIN) {
			wins++;
		} else if (gameStatus == GameStatus.TIE) {
			ties++;
		} else if (gameStatus == GameStatus.LOSE) {
			loses++;
		}
	}
	


}
