import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SecretMessagesGUI extends JFrame {
	private JTextField textKey;
	private JTextArea textIn;
	private JTextArea textOut;
	private JSlider slider;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	public String encode(String message, int keyVal) {
		String output = "";
		char key = (char) keyVal;
		for (int x = 0; x<message.length();x++) { //line for right way round message
		//for (int x = message.length() - 1; x >= 0; x--) { //line to reverse message
			char input = message.charAt(x);
			if (input >= 'A' && input <= 'Z') {
				input += key;
				if (input > 'Z')
					input -= 26;
				if (input < 'A')
					input += 26;
			}
			else if (input >= 'a' && input <= 'z') {
				input += key;
				if (input > 'z')
					input -=26;
				if (input < 'a')
					input += 26;
			}
			else if (input >= '0' && input <= '9')
			{
				input += (keyVal %10);
				if (input > '9')
					input -= 10;
				if (input < '0')
					input +=10;
			}
			output += input;
		}
		return output;
	}
	

	public SecretMessagesGUI() {
		getContentPane().setBackground(new Color(0, 0, 128));
		setTitle("Romain's Secret Message App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 26, 418, 99);
		getContentPane().add(scrollPane);
		
		textIn = new JTextArea();
		scrollPane.setViewportView(textIn);
		textIn.setWrapStyleWord(true);
		textIn.setLineWrap(true);
		textIn.setFont(new Font("Parchment", Font.BOLD | Font.ITALIC, 36));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(42, 197, 432, 153);
		getContentPane().add(scrollPane_1);
		
		textOut = new JTextArea();
		scrollPane_1.setViewportView(textOut);
		textOut.setWrapStyleWord(true);
		textOut.setLineWrap(true);
		textOut.setFont(new Font("Parchment", Font.BOLD | Font.ITALIC, 36));
		
		textKey = new JTextField();
		textKey.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {slider.setValue(Integer.parseInt(textKey.getText()));}
				catch (Exception ex) {}
			}
		});
		textKey.setHorizontalAlignment(SwingConstants.CENTER);
		textKey.setText("3");
		textKey.setBounds(233, 136, 86, 20);
		getContentPane().add(textKey);
		textKey.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Key:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(177, 139, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JButton EncodeButton = new JButton("Encode/Decode");
		EncodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String message = textIn.getText();
				int key =Integer.parseInt(textKey.getText());
				String output = encode(message, key);
				textOut.setText(output);
			}catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Please enter a whole number for the encryption key");
				textKey.requestFocus();
				textKey.selectAll();
			}
			}
		});
		EncodeButton.setBounds(329, 136, 131, 23);
		getContentPane().add(EncodeButton);
		
		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textKey.setText(""+ slider.getValue());
				String message = textIn.getText();
				int key = slider.getValue();
				String output = encode(message,key);
				textOut.setText(output);
			}
		});
		slider.setMajorTickSpacing(13);
		slider.setPaintLabels(true);
		slider.setValue(3);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setMinimum(-26);
		slider.setMaximum(26);
		slider.setBackground(new Color(0, 0, 128));
		slider.setBounds(52, 125, 136, 59);
		getContentPane().add(slider);
		
		JButton MoveUpButton = new JButton("^ Move Up ^");
		MoveUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textIn.setText(textOut.getText());
			int key=slider.getValue();
			key = -key;
			slider.setValue(key);
			
			}
		});
		MoveUpButton.setBounds(243, 167, 97, 23);
		getContentPane().add(MoveUpButton);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecretMessagesGUI theApp = new SecretMessagesGUI();
		theApp.setSize(new java.awt.Dimension(600,400));
		theApp.setVisible(true);
	}
}
