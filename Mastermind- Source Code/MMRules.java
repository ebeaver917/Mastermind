//Elliot Beaver

/* This class file handles the rules menu option */

import javax.swing.*;
import java.awt.*;

public class MMRules extends JPanel {
	
	public MMRules() {
		
		//align all text left 
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//write html messages
		String headerHTML = ("<html>Rules of the Game!</html>");
		String rule1HTML = ("<html>* A code of four colors is chosen at random</html>");
		String rule2HTML = ("<html>* You have a bank of six colors to choose from</html>");
		String rule3HTML = ("<html>* Each turn, you will select a combination of colors<br/> and try to guess the code</html>");
		String rule4HTML = ("<html>* The squares to the right of the guesses will show if<br/>a color guessed is in the code but in the wrong<br/>  position (yellow), in the code and in the right<br/>  position(green), or not in the code at all(grey)</html>");
		String rule5HTML = ("<html>* You will have 7 turns to guess the correct code</html>");
		String rule6HTML = ("<html>* You can decrease the number of turns you have<br/>by selecting the 'Change Difficulty' option in the<br/>menu</html>");
		
		//create the labels
		JLabel header = new JLabel(headerHTML);
		JLabel rule1 = new JLabel(rule1HTML);	
		JLabel rule2 = new JLabel(rule2HTML);	
		JLabel rule3 = new JLabel(rule3HTML);	
		JLabel rule4 = new JLabel(rule4HTML);	
		JLabel rule5 = new JLabel(rule5HTML);	
		JLabel rule6 = new JLabel(rule6HTML);
		
		//format the labels
		header.setFont(new Font("Aerial", Font.BOLD, 25));
		rule1.setFont(new Font("Aerial", Font.PLAIN, 17));
		rule2.setFont(new Font("Aerial", Font.PLAIN, 17));
		rule3.setFont(new Font("Aerial", Font.PLAIN, 17));
		rule4.setFont(new Font("Aerial", Font.PLAIN, 17));
		rule5.setFont(new Font("Aerial", Font.PLAIN, 17));
		rule6.setFont(new Font("Aerial", Font.PLAIN, 17));
		
		//add the labels
		add(header);
		add(rule1);
		add(rule2);
		add(rule3);
		add(rule4);
		add(rule5);
		add(rule6);
		
		setVisible(true);		
	}	
}