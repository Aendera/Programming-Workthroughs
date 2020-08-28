import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MadLibGUI extends JFrame {
	private JTextField textAdjective;
	private JTextField textPastVerb;
	private JTextField textColor;
	private JTextField textNoun;
	private JLabel textMadLib;
	public void displayText() {
		String message;
		message="<html>The " + textColor.getText() + " dragon " + textPastVerb.getText()
				+ " at the " + textAdjective.getText() + " " + textNoun.getText() +".";
		message += "<br>";
		message += "And they lived happily ever after. <br> The end.</html>";
		System.out.println(message);
		textMadLib.setText(message);
	}
	public MadLibGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Romain's Wacky  MadLibs App");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 675, 51);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter an Adjective: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(38, 136, 181, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter a color: ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(337, 136, 142, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter a Verb ending in -ed: ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setBounds(38, 181, 181, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Enter a noun: ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4.setBounds(361, 181, 118, 14);
		getContentPane().add(lblNewLabel_4);
		
		textMadLib = new JLabel("<html><br><br><br></html>");
		textMadLib.setBackground(Color.WHITE);
		textMadLib.setBounds(38, 286, 647, 133);
		getContentPane().add(textMadLib);
		
		JButton btnNew = new JButton("Press Here To View Your MadLib Creation!");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayText();
			}
		});
		btnNew.setBounds(10, 241, 675, 23);
		getContentPane().add(btnNew);
		
		textAdjective = new JTextField();
		textAdjective.setBounds(229, 133, 85, 20);
		getContentPane().add(textAdjective);
		textAdjective.setColumns(10);
		
		textPastVerb = new JTextField();
		textPastVerb.setBounds(228, 178, 86, 20);
		getContentPane().add(textPastVerb);
		textPastVerb.setColumns(10);
		
		textColor = new JTextField();
		textColor.setBounds(489, 133, 86, 20);
		getContentPane().add(textColor);
		textColor.setColumns(10);
		
		textNoun = new JTextField();
		textNoun.setBounds(489, 178, 86, 20);
		getContentPane().add(textNoun);
		textNoun.setColumns(10);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MadLibGUI MadLib = new MadLibGUI();
		MadLib.setSize(new Dimension(800,600));
		MadLib.setVisible(true);
	}

}
