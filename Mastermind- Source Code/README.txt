Hello! This is my final project for COP 3252: Advanced Programming in Java for 2022. For this project,
I created a Mastermind game using Swing. The project implements a GUI with a gameboard and menu with
four separate options. I will first describe the menu, then how to use the GUI.

Menu: 
Item 1: Start Game
When the program first begins its run, a prompt to start the game or view the rules using the menu appears. 
The menu is located in the top left of the frame. To start the game, simply click on the 'Start Game' menu
option. You can select this at any point during program run, and a new game will be started. 

Item 2: Rules
Clicking on this menu option will cause a pop-up window to emerge which gives a synposis of the game of 
Mastermind and how to play. You can open this window using the menu at any point during the program
run.

Item 3: Change Difficulty
Clicking this option will decrease the number of turns you have when you next select the 'Start Game' 
option by one. A pop-up will appear indicating this.

Item 4: Quit
Selecting this option quits the program.

GUI:
The Game Board: 
On the bottom of the game board, you have a bank of colors to choose from to make your guesses.
Clicking on any one of these colors will cause it to appear in the bottom-left of the grid above the 
bank, and clicking another will cause it to appear to the right of the previous, and so on. After every 
guess (four color selections), the smaller grid to the right of the full row will be filled with colors 
corresponding to the correctness of the user's guess. If the color guessed is in the correct position and
is the correct color, the square corresponding to the square of the guessed color will turn green. If the 
color is correct but in the wrong position, the square corresponding to the guessed square will turn yellow,
and if the color is wrong all together, the square will turn gray. This process of guessing the code and 
being given a hint  will repeat until the player has either guessed the code, or has used their alloted 
guess amount. This sounds more confusing than it is, so you have to give it a try!