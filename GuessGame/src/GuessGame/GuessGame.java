package GuessGame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension; //used for dimension for GUI

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
public class GuessGame extends JFrame{
	private JTextField txtGuess;
	//adding lblOutput to access it
	private JLabel lblOutput;
	//adding number to guess
	private int theNumber; 
	//adding method to check player's guess
	public void checkGuess() {
		//retrieving from GUI txtGuess
		String guessText = txtGuess.getText();
		String message = "";
		//Adding way to deal with exceptions
		try {
		//Converting String to number
		int guess = Integer.parseInt(guessText);
		//logic to check if too low or high
		if (guess < theNumber)
			message = guess + " is too low. Please try again.";
		else if (guess > theNumber)
			message = guess + " is too high. Please try again.";
		else {
			message = guess + " is correct! You win!";
			//adding a newGame method after we win
			newGame();
		}
		} catch (Exception e) {
			message = "Not valid. Please enter a whole number between 1 and 100";
		} finally {
		//showing message to the user
		lblOutput.setText(message);
		//Focusing on txtGuess and selecting data to  overwrite
		txtGuess.requestFocus();
		txtGuess.selectAll();
	}
		}
	//Adding option for New Game
	public void newGame() {
		theNumber=(int)(Math.random()*100+1);
	}
	public GuessGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("George's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("George's Hi-Lo Guessing Game");
		lblNewLabel.setBounds(0, 27, 434, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100");
		lblNewLabel_1.setBounds(90, 71, 253, 53);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblNewLabel_1);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.setBounds(137, 151, 159, 25);
		btnGuess.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//adding GUI functionality to use checGuess method
				checkGuess();
			}
		});
		getContentPane().add(btnGuess);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//allowing users to press Enter to Guess
				checkGuess();
			}
		});
		txtGuess.setBounds(337, 86, 76, 25);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOutput.setBounds(27, 201, 451, 33);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		//setting up the GUI to initialize the program
		//creating new GuessGame called theGame
		GuessGame theGame = new GuessGame();
		//calling theGame to start a new game
		theGame.newGame();
		//setting window size by creating Dimension object
		theGame.setSize(new Dimension (500,400));
		//making the GUI visible
		theGame.setVisible(true);
	}
}
