import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class BubblePanel extends JPanel {
	Random rand = new Random();
	ArrayList<Bubble> bubbleList;
	int size = 25;
	Timer timer;
	int delay = 33;
	JSlider slider;
	
	public BubblePanel() {
		timer = new Timer(delay, new BubbleListener());
	
		bubbleList = new ArrayList<Bubble>();
		setBackground(Color.BLACK);
		
		JPanel panel = new JPanel();
		add(panel);
		
		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				if (btn.getText().equals("Pause")) {
					timer.stop();
					btn.setText("Start");
				} else {
					timer.start();
					btn.setText("Pause");
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Animation Speed:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblNewLabel);
		
		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int speed = slider.getValue() + 1;
				int delay = 1000 / speed;
				timer.setDelay(delay);
			}
		});
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(30);
		slider.setMaximum(120);
		slider.setMinorTickSpacing(5);
		panel.add(slider);
		panel.add(btnPause);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				bubbleList = new ArrayList<Bubble>();
				repaint();
			}
		});
		panel.add(btnClear);
		//testBubbles();
		addMouseListener(new BubbleListener());
		addMouseMotionListener(new BubbleListener());
		addMouseWheelListener(new BubbleListener());
		timer.start();
	}
	
	public void paintComponent(Graphics canvas) {
		super.paintComponent(canvas);
		for(Bubble b : bubbleList) {
			b.draw(canvas);
		}
	}
	
	public void testBubbles() {
		for(int n=0;n<1000;n++) {
			int x = rand.nextInt(600);
			int y = rand.nextInt(400);
			int size = rand.nextInt(50);
			bubbleList.add(new Bubble(x,y,size));
		}
		repaint();
	}
	
	private class BubbleListener extends MouseAdapter
	implements ActionListener{
		public void mousePressed(MouseEvent e) {
			bubbleList.add(new Bubble(e.getX(),e.getY(), size));
			repaint();
		}
		public void mouseDragged(MouseEvent e) {
			bubbleList.add(new Bubble(e.getX(),e.getY(), size));
			repaint();
		}
		public void mouseWheelMoved(MouseWheelEvent e) {
			size += e.getUnitsToScroll();
			if (size<3)
				size = 3;
		}
		public void actionPerformed(ActionEvent e) {
			for (Bubble b : bubbleList)
				b.update();
			repaint();
		}
	}
	private class Bubble{
		private int x;
		private int y;
		private int size;
		private Color color;
		private int xspeed, yspeed;
		private final int MAX_SPEED = 5;
		
		public Bubble(int newX, int newY, int newSize) {
			x=newX;
			y=newY;
			size=newSize;
			color = new Color( rand.nextInt(256),//r
								rand.nextInt(256),//g
								rand.nextInt(256),//b
								rand.nextInt(256));//alpha
			xspeed = rand.nextInt(MAX_SPEED * 2 + 1) - MAX_SPEED;
			yspeed = rand.nextInt(MAX_SPEED * 2 + 1) - MAX_SPEED;
			if (xspeed == 0 && yspeed == 0)
				xspeed=yspeed=1;//does multiple assignment work this way?
		}
		
		public void draw(Graphics canvas) {
			canvas.setColor(color);
			canvas.fillOval(x-size/2, y - size/2, size,size);
		}
		
		public void update() {
			x += xspeed;
			y += yspeed;
			if (x - size/2 <= 0 || x + size/2 >= getWidth())
				xspeed = -xspeed;
			if (y - size/2 <= 0 || y +size/2 >= getHeight())
				yspeed = -yspeed;
		}
	}
	
}
