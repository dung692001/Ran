package View;

import java.io.IOException;
import java.sql.SQLException;

import Controller.SnakeGame;

public class StartGame {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		new SnakeGame();
	}
}
