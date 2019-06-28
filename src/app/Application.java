package app;

import game.GameController;

public class Application {

	public static void main(String[] args) {
		GameController game = new GameController();
		game.mainLoop();
	}

}
