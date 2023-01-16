//Elliot Beaver

/* This class file handles the gameboard and all related functionalities */

/* The file contains the following sub-classes:												*/
/* ColorSelect: Handles the painting of any colors seen on the display besides the hints 	*/

/* HintColor: Handles the hint colors, must be separate from ColorSelect because hints are 	*/
/* drawn smaller than all other colors.													   	*/

/* Click: Handles what occurs when the mouse is clicked on-screen. 							*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//this class will handle the gameboard and 
public class GameBoard extends JPanel {
	
	private JLabel message;		//lables for the GUI
	private JLabel question;
	private JLabel question2;
	private JLabel M;
	
	public int [] code;			//array that holds the secret code
	private int numGuesses;
	
	Click clicked;				//object of type CLick to handle the game's clicking
	
	//class constructor
	//because the number of guesses is changed when 
	public GameBoard(int guesses) {
		
		//cretae and format the labels
		question = new JLabel("?               ?                ?");
		question2 = new JLabel("                ?");
		message = new JLabel("Guess the Code!");
		M = new JLabel("M");
		question.setFont(new Font("Aerial", Font.BOLD, 30));
		question2.setFont(new Font("Aerial", Font.BOLD, 30));
		message.setFont(new Font("Aerial", Font.BOLD, 40));
		M.setFont(new Font("Aerial", Font.ITALIC, 75));
		
		//add the labels to the board
		setLayout(null);
		message.setBounds(new Rectangle(new Point(140, 80), message.getPreferredSize()));
		question.setBounds(new Rectangle(new Point(70, 200), message.getPreferredSize()));
		question2.setBounds(new Rectangle(new Point(370, 200), message.getPreferredSize()));
		M.setBounds(new Rectangle(new Point(480, 780), message.getPreferredSize()));
		add(message);
		add(question);
		add(question2);
		add(M);
		
		
		//randomly generate the code
		Random rand = new Random();		
		int slot0 = (rand.nextInt(6) + 1);
		int slot1 = (rand.nextInt(6) + 1);
		int slot2 = (rand.nextInt(6) + 1);
		int slot3 = (rand.nextInt(6) + 1);
		
		//initialize the number of guesses per turn, can be changed by the menu option
		numGuesses = guesses;
		
		SetCode(slot0, slot1, slot2, slot3);
		
		//add the Click object to the board. This object will handle all input and painting
		clicked = new Click();
		addMouseListener(clicked);
		//setVisible(true);
	}
	
	//sets the secret code
	private void SetCode(int first, int second, int third, int fourth) {
		code = new int [] {first, second, third, fourth};
		
	}	
	
	//paints the game board
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		
		//draw the outline of the game board
		g.fillRect(10, 20, 1000, 10);		//top outline
		g.fillRect(580, 0, 10, 1000);		//right outline
		g.fillRect(0, 0, 15, 1500);		//left outline
		g.fillRect(0, 855, 1000, 10);		//bottom outline
		
		//draw lines for the color bank
		g.fillRect(440, 330, 10, 1000);
		g.fillRect(0, 750, 700, 15);
		g.fillRect(150, 750, 10, 200);
		g.fillRect(300, 750, 10, 200);
		g.fillRect(0, 807, 450, 10);
		g.fillRect(110, 330, 10, 750);
		g.fillRect(220, 330, 10, 750);
		g.fillRect(330, 330, 10, 750);
		g.fillRect(515, 330, 5, 420);
		
		//fill in the guess spaces
		g.fillRect(0, 690, 600, 10);
		g.fillRect(0, 630, 600, 10);
		g.fillRect(0, 570, 600, 10);
		g.fillRect(0, 510, 600, 10);
		g.fillRect(0, 450, 600, 10);
		g.fillRect(0, 390, 600, 10);
		g.fillRect(0, 390, 600, 10);
		g.fillRect(0, 330, 650, 10);
		
		//fill in the hint spaces
		g.fillRect(440, 362, 200, 5);
		g.fillRect(440, 422, 200, 5);
		g.fillRect(440, 482, 200, 5);
		g.fillRect(440, 542, 200, 5);		
		g.fillRect(440, 602, 200, 5);
		g.fillRect(440, 662, 200, 5);
		g.fillRect(440, 722, 200, 5);
		
		//fill in the colors in the bank
		g.setColor(Color.BLUE);
		g.fillRect(15, 765, 135, 43);
		g.setColor(Color.GREEN);
		g.fillRect(160, 765, 140, 43);
		g.setColor(Color.MAGENTA);
		g.fillRect(310, 765, 130, 43);
		g.setColor(Color.ORANGE);
		g.fillRect(15, 815, 135, 40);
		g.setColor(Color.RED);
		g.fillRect(160, 815, 140, 40);
		g.setColor(Color.CYAN);
		g.fillRect(310, 815, 130, 40);
		
		//fill in the grey boxes
		g.setColor(Color.GRAY);
		g.fillRect(20, 200, 120, 60);
		g.fillRect(160, 200, 120, 60);
		g.fillRect(305, 200, 120, 60);
		g.fillRect(450, 200, 120, 60);		
	}
	
	
	//for each color box component
	public class ColorSelect extends JComponent {
		
		int x, y;		//the position of the color		
		Color color;	//the color 		
		ColorSelect(int x, int y, int colorParam) {
			this.x = x;
			this.y = y;
			
			switch(colorParam) {
				case 1:
					color = Color.BLUE;
					break;
				case 2:
					color = Color.GREEN;
					break;
				case 3:
					color = Color.MAGENTA;
					break;
				case 4:
					color = Color.ORANGE;
					break;
				case 5:
					color = Color.RED;
					break;
				case 6:
					color = Color.CYAN;
					break;					
			}
		}
		
		@Override 
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(color);
			g.fillRect(x, y, 100, 50);
		}
	}
	
	//for each hint box component
	public class HintColor extends JComponent {
		
		int x, y; 		//the position of the color
		Color color;	//the color
		
		HintColor(int x, int y, int colorParam) {
			this.x = x;
			this.y = y;
			
			switch(colorParam) {
				case 1:
					color = Color.GREEN;
					break;
				case 2:
					color = Color.YELLOW;
					break;
				case 3:
					color = Color.GRAY;
					break;
			}
		}
		
		@Override 
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(color);
			g.fillRect(x, y, 65, 23);
		}
	}
	
	public class Click extends MouseAdapter {	
		
		int colorCounter = 0;			//counter variables
		int guessCounter = 0;
		int hintCounter = 0;

		boolean isWin = false;
		
		int [] guesses = new int [4];	//arrays that hold the guesses and hint values
		int [] match = new int[4];

		//override the mousePressed method
		@Override
		public void mousePressed(MouseEvent m) {
			
			int currentChoice = 0;
			int currentGuess = 0;
			int currentHintX = 0;
			int currentHintY = 0;
			
			Point current = m.getPoint();
			
			/* The following section handles the current number of colors selected per turn and the *
			   x position at which the rectangle will be drawn */
			switch(colorCounter) {
				case 0:
					currentChoice = 12;
					break;
				case 1:
					currentChoice = 120;
					break;
				case 2:
					currentChoice = 230;
					break;
				case 3:
					currentChoice = 340;
					break;				
			}
			
			/* The following section handles the current guess the player is on and how it corresponds *
			   to the y position at which the rectangles are drawn */
			
			/* On each turn, the Y position of the first two hints is the same as the Y position of *
			   the colors guessed */
			switch(guessCounter) {
				case 0:
					currentGuess = 700;
					currentHintY = 700;
					break;
				case 1:
					currentGuess = 640;
					currentHintY = 640;
					break;
				case 2:
					currentGuess = 580;
					currentHintY = 580;
					break;
				case 3:
					currentGuess = 520;
					currentHintY = 520;
					break;	
				case 4:
					currentGuess = 460;
					currentHintY = 460;
					break;
				case 5:
					currentGuess = 400;
					currentHintY = 400;
					break;
				case 6:
					currentGuess = 340;
					currentHintY = 340;
					break;
					
			}
			   
			/* The following handles the determination of which color will be drawn based on the position *
			   of the mouse when it is clicked */
			
			if((current.x > 10 && current.x < 145) && (current.y > 765 && current.y < 808)) {
				ColorSelect blue = new ColorSelect(currentChoice, currentGuess, 1);
				setLayout(new BorderLayout());
				GameBoard.this.add(blue, BorderLayout.CENTER);		//add the new component to the board
				guesses[colorCounter] = 1;							//make the value of the current guesses index the value for blue
				colorCounter++;						
			}
				
			else if((current.x > 155 && current.x < 295) && (current.y > 765 && current.y < 808)) {
				ColorSelect green = new ColorSelect(currentChoice, currentGuess, 2);
				setLayout(new BorderLayout());
				GameBoard.this.add(green, BorderLayout.CENTER);
				guesses[colorCounter] = 2;
				colorCounter++;				
			}
			else if((current.x > 305 && current.x < 435) && (current.y > 765 && current.y < 808)) {
				ColorSelect magenta = new ColorSelect(currentChoice, currentGuess, 3);
				setLayout(new BorderLayout());
				GameBoard.this.add(magenta, BorderLayout.CENTER);
				guesses[colorCounter] = 3;				
				colorCounter++;
				
			}
			else if((current.x > 10 && current.x < 145) && (current.y > 818 && current.y < 863)) {
				ColorSelect orange = new ColorSelect(currentChoice, currentGuess, 4);
				setLayout(new BorderLayout());
				GameBoard.this.add(orange, BorderLayout.CENTER);
				guesses[colorCounter] = 4;						
				colorCounter++;
			}
			else if((current.x > 157 && current.x < 300) && (current.y > 818 && current.y < 863)) {
				ColorSelect red = new ColorSelect(currentChoice, currentGuess, 5);
				setLayout(new BorderLayout());
				GameBoard.this.add(red, BorderLayout.CENTER);
				guesses[colorCounter] = 5;
				colorCounter++;
			}
			else if((current.x > 305 && current.x < 435) && (current.y > 818 && current.y < 863)) {
				ColorSelect cyan = new ColorSelect(currentChoice, currentGuess, 6);
				setLayout(new BorderLayout());
				GameBoard.this.add(cyan, BorderLayout.CENTER);
				guesses[colorCounter] = 6;
				colorCounter++;
			}
			else {
				
			}		
			
			//paint after every selection 
			GameBoard.this.validate();
			GameBoard.this.repaint();
			
			//if the guess counter reaches four, fill the array and check it against the code array
			if(colorCounter == 4) {				
				//first check for a win
				if(Arrays.equals(guesses, GameBoard.this.code)) {
					isWin = true;
					JLabel win = new JLabel("You Win!");
					win.setFont(new Font("Aerial", Font.BOLD, 50));
					win.setBounds(new Rectangle(new Point(190, 260), win.getPreferredSize()));
					GameBoard.this.add(win);
					//if the game is won or lost, remove the mouseListener
					GameBoard.this.removeMouseListener(GameBoard.this.clicked);
				}
				
				//then check for a loss if the user runs out of guesses
				if(guessCounter == (GameBoard.this.numGuesses - 1) && isWin == false) {
					JLabel lose = new JLabel("You Lose");
					lose.setFont(new Font("Aerial", Font.BOLD, 50));
					lose.setBounds(new Rectangle(new Point(190, 260), lose.getPreferredSize()));
					GameBoard.this.add(lose);
					//if the game is won or lost, remove the mouseListener
					GameBoard.this.removeMouseListener(GameBoard.this.clicked);
				}
				
				//find the correct hint values
				for(int i = 0; i < 4; i ++) {
					switch(hintCounter) {
						case 0:
							currentHintX = 450;
							break;
						case 1:
							currentHintX = 520;
							break;
					}
					
					//if the indicies match, the color is green
					if(guesses[i] == GameBoard.this.code[i]) {
						HintColor green = new HintColor(currentHintX, currentHintY, 1);
						GameBoard.this.add(green);
						GameBoard.this.validate();
						GameBoard.this.repaint();
						match[i] = 1;
					} 
					
					//if the values match but they are in the wrong indicies, the color is yellow
					for(int k = 0; k < 4; k++) {
						if((guesses[i] == GameBoard.this.code[k]) && match[i] != 1) {
							HintColor yellow = new HintColor(currentHintX, currentHintY, 2);
							GameBoard.this.add(yellow);
							GameBoard.this.validate();
							GameBoard.this.repaint();
							match[i] = 2;
						}
					}
					
					//if there is no match, the color is grey
					if(guesses[i] != GameBoard.this.code[i]) {
						HintColor gray = new HintColor(currentHintX, currentHintY, 3);
						GameBoard.this.add(gray);
						GameBoard.this.validate();
						GameBoard.this.repaint();
						match[i] = 3;
					}	
					
					//increase the current hint that is being printed on the screen
					hintCounter++;
					
					//if the current hint intertion is 1, move the rectangles being printed down 27 pixels
					if(i == 1) {
						currentHintY += 27;
						hintCounter = 0;
					}
				} 
				
				//reset the array
				for(int i = 0; i < 4; i++) {
					guesses[i] = 0;
				}
				
				//reset the counters;
				hintCounter = 0;
				colorCounter = 0;
				guessCounter++;
			}			
		}
	}
}