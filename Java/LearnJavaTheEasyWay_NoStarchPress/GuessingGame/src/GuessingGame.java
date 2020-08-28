import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;

	public void checkGuess() {
		String guessText=txtGuess.getText();
		String message="";
		try {
			int guess=Integer.parseInt(guessText);
			if (guess < theNumber)
				message=guess+" is too low. Try again.";
			else if (guess > theNumber)
				message=guess+" is too high. Try again.";
			else {
				message=guess+" is correct. You win! Let's play again!";
				newGame();
			}

		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100.";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}

	}

	public void newGame() {
		theNumber=(int)(Math.random()*100+1);
	}

	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cthal's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Cthal's Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 38, 414, 19);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100: ");
		lblNewLabel_1.setBounds(118, 95, 193, 14);
		getContentPane().add(lblNewLabel_1);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setBounds(321, 92, 41, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(3);

		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(172, 147, 89, 23);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(10, 208, 414, 14);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame=new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}
