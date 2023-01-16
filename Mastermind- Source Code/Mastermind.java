//Elliot Beaver

/*This class file handles the opening of the window and menus */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mastermind extends JFrame {
	
	//driver objects
	private JDesktopPane desktop;
	private JMenuBar menuBar;
	private JMenu menu1;
	private JMenuItem menuItem1, menuItem2, menuItem3, menuItem4;
	private JLabel welcome;
	
	//the number of guesses the player starts with
	private int guesses = 7;

	public Mastermind() {
		
		//create the menu bar and the desktop
		menuBar = new JMenuBar();
		desktop = new JDesktopPane();
		
		//create and add the welcome message
		welcome = new JLabel("Welcome! Start the game or view the rules using the menu!");
		welcome.setFont(new Font("Aerial", Font.PLAIN, 20));
		welcome.setBounds(new Rectangle(new Point(35, 375), welcome.getPreferredSize()));
		desktop.add(welcome);
		
		//create the menu
		menu1 = new JMenu("Options");
		menuItem1 = new JMenuItem("Start Game!");
		menuItem2 = new JMenuItem("Rules");
		menuItem3 = new JMenuItem("Change Difficulty");
		menuItem4 = new JMenuItem("Quit");
		
		//add action listeners to the menu items
		menuItem1.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent a) {
				//create the internal frame to put the panel on and set the size and the loaction on the main frame
				JInternalFrame gameFrame = new JInternalFrame("Game!" , true, true, true, true);	
				gameFrame.setSize(600, 900);
				gameFrame.setLocation(-10, -50);	
				gameFrame.setVisible(true);
				
				//add the movableframe object to the frame, and the frame to the desktop
				gameFrame.add(new GameBoard(guesses));
				desktop.add(gameFrame);
				gameFrame.toFront();
			}
		});
		
		menuItem2.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent a) {
				
				//create the internal frame to put the panel on and set the size and the loaction on the main frame
				JInternalFrame ruleFrame = new JInternalFrame("Rules of Mastermind", true, true, true, true);	
				ruleFrame.setSize(400,400);
				ruleFrame.setLocation(100, 100);		
				ruleFrame.setVisible(true);
				
				//add the movableframe object to the frame, and the frame to the desktop
				ruleFrame.add(new MMRules());
				desktop.add(ruleFrame);
				ruleFrame.toFront();
			}
		});
		
		menuItem3.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent a) {
				
				//when the player selects this menu item, decrement the number of guesses
				guesses--;
				
				//open a frame that tells the player that the number of guesses has decreased
				JInternalFrame turns = new JInternalFrame(":)", true, true, true, true);
				turns.setSize(300, 140);
				turns.setLocation(140, 250);
				turns.setVisible(true);
				
				JLabel decTurns = new JLabel("<html>The number of turns you have will decrease should you start another game.</html>");
				decTurns.setFont(new Font("Aerial", Font.BOLD, 20));
				decTurns.setBounds(new Rectangle(new Point(300, 140), decTurns.getPreferredSize()));				
		
				turns.add(decTurns);
				desktop.add(turns);
				turns.toFront();			
			}
		});
	
		menuItem4.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent ae) {
				System.exit(0);
			}
		});
		
		//add the items to the menu
		menu1.add(menuItem1); 
		menu1.add(menuItem2);
		menu1.add(menuItem3);
		menu1.add(menuItem4);
		
		//add the menu to the menubar
		menuBar.add(menu1);
		setJMenuBar(menuBar);
		
		add(desktop);
		setTitle("Mastermind!");
	} 
	
	public static void main (String [] args) {
		Mastermind newGame = new Mastermind();
		newGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newGame.setSize(600, 900);
		newGame.setVisible(true);
	}

}