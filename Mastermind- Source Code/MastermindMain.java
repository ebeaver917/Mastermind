// Elliot Beaver

/* Game must be run on a display with a >= 900 pixel y resolution 	*/
/* Run game from this file. 										*/

import javax.swing.*;

public class MastermindMain {
	public static void main (String [] args) {
		Mastermind newGame = new Mastermind();
		newGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newGame.setSize(600, 900);
		newGame.setVisible(true);
	}
}