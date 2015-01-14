package main;

import javax.swing.JFrame;

public class Game {

	public static void main(String[] args) {
		
		final JFrame frame = new JFrame("Ball Adventure 2");
		final GamePanel panel = new GamePanel();
		
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
