import javax.swing.JFrame;

public class BubbleDrawGUI extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Romain's BubbleDraw GUI App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new BubblePanel());
		frame.setSize(new java.awt.Dimension(600,400));
		frame.setVisible(true);
		
	}

}
