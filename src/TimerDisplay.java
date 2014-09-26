import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Timer;

public class TimerDisplay {
	private JLabel timeLabel;
	private Timer timer;
	private long startTime;
	private DecimalFormat timeFormatter;
	
	public TimerDisplay() {
		timeLabel = new JLabel("0.00", JLabel.CENTER);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1000,1000));
		frame.setLayout(new FlowLayout());
		
		frame.addKeyListener(new KeyListener() {
			private boolean running = false;
			private boolean activated = false;
			
			public void keyPressed(KeyEvent e) {
				if(running) {
					timer.stop();
					running = false;
				}
			}
			
			public void keyTyped(KeyEvent e) {
				if(!activated && e.getKeyCode() == KeyEvent.VK_SPACE) {
					activated = true;
				}
			}
			
			public void keyReleased(KeyEvent e) {
				if(activated && e.getKeyCode() == KeyEvent.VK_SPACE) {
					activated = false;
					startTime = System.currentTimeMillis();
					timer.start();
				}
			}
		});
		
		frame.add(timeLabel);
		
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startTime = System.currentTimeMillis();
				timer.start();
			}
		});
		frame.add(startButton);
		
		JButton stopButton = new JButton("Stop");
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
			}
		});
		frame.add(stopButton);
		
		timeFormatter = new DecimalFormat("00");
		
		timer = new Timer(10, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long now = System.currentTimeMillis();
				long diff = now - startTime;
				
				long minutes = diff / (60 * 1000);
				diff = Math.round(diff % (60*1000));
				long seconds = diff / 1000;
				diff = Math.round(diff % 1000);
				long centiseconds = diff / 10;
				
				timeLabel.setText(timeFormatter.format(minutes) + ":"
						+ timeFormatter.format(seconds) + "."
						+ timeFormatter.format(centiseconds));
			}
		});
		
		frame.pack();
		frame.setVisible(true);
	}
}
