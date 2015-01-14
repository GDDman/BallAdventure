package main;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.awt.event.*;

//Game
public class GamePanel extends JPanel implements Runnable, KeyListener {
	
	private static final long serialVersionUID = 1L;
	public  final static int WIDTH = 800;
	public  final static int HEIGHT = 700;
	private long starttimer;
	
	private Sounds music;
	private Sounds jumpsound;
	private Sounds killsound;
	private Sounds flagsound;
	private Sounds winsound;
	private boolean play;
	
	private Thread thread6;
	private Thread thread4;
	private Thread thread3;
	private Thread thread2;
	public  Thread thread;
	private boolean running;
	private int score;
	private int deathcount;
	private int jumps;
	private boolean flagged1;
	private boolean flagged2;
	private boolean flagged3;
	private boolean flagged4;
	private boolean flagged5;
	
	private BufferedImage image; 
	private Graphics2D g; 
	
	private int FPS = 30;
    public  static ArrayList<MovingPlatform> plats;
	public  Player player;
	
	// panel stuff 
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
	}

	//notifies when the JFrame is loaded, creates a new thread. 
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			thread.start();
		}
		addKeyListener(this);
	}
	
	//starts running the program
	public void run() {
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		play = true;
		
		while (play) {
			
			startScreen();
			gameDraw();
			try {
				Thread.sleep(500);
			} catch (Exception e) { }
		}
		
		starttimer = System.nanoTime();
		
		running = true;
		score = 10000;
		deathcount = 0;
		jumps = 0;
		flagged1 = false;
		flagged2 = false;
		flagged3 = false;
		flagged4 = false;
		flagged5 = false;
		jumpsound = new Sounds();
		killsound = new Sounds();
		flagsound = new Sounds();
		winsound = new Sounds();
		
		long startTime;
		long URDTimeMillis;
		long waitTime;
		
		long targetTime = 800/FPS;
		
		player = new Player();
		
		thread2 = new Thread() {
			public void run() {
				
				music = new Sounds();
				
				while (running) {
					music.starting("/Resources/a.wav", 0f);
				}	
			}
		};
		
		thread3 = new Thread() {
			public void run() {
				
				while (running) {
					
					long tTime = 800/30; 
					long sTime = System.nanoTime();
					
					if (player.getdeaths() > deathcount) {
						killsound.starting("/Resources/c.wav", - 3.0f);
						deathcount = player.getdeaths();
					}

					if (player.flagCheck2() && !flagged1) {
						flagsound.starting("/Resources/d.wav", -3.0f);
						flagged1 = true;
					}
					if (player.flagCheck3() && !flagged2) {
						flagsound.starting("/Resources/d.wav", -3.0f);
						flagged2 = true;
					}
					if (player.flagCheck4() && !flagged3) {
						flagsound.starting("/Resources/d.wav", -3.0f);
						flagged3 = true;
					}
					if (player.flagCheck5() && !flagged4) {
						flagsound.starting("/Resources/d.wav", -3.0f);
						flagged4 = true;
					}
					if (player.flagCheck6() && !flagged5) {
						flagsound.starting("/Resources/d.wav", -3.0f);
						flagged5 = true;
					}
					
					long midTime = (System.nanoTime()- sTime)/1000000;
					
					long wTime = tTime-midTime;	
					
					try {
						Thread.sleep(wTime);
					} catch (Exception e) { }
				}
			}
		};
		
		thread4 = new Thread() {
			public void run() {
				
				while (running) {
					
					long tTime = 800/30; 
					long sTime = System.nanoTime();
					
					if (player.returnJumps() > jumps) {
						jumpsound.starting("/Resources/b.wav", - 5.0f);
						jumps = player.returnJumps();
					}

					long midTime = (System.nanoTime()- sTime)/1000000;
					
					long wTime = tTime-midTime;	
					
					try {
						Thread.sleep(wTime);
					} catch (Exception e) { }
				}
			}
		};
		
		thread2.start();
		thread3.start();
		thread4.start();
		
		plats = new ArrayList<MovingPlatform>();

		//                           x   y   wdth ht dis spd   color   kill   stick  dir    safe?  link? side? changedir? newdir + # offset
		//																			 true = </>			 true = </>		  true = </>
 		plats.add(new MovingPlatform(80, 610, 30, 40, 40, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0));
	 	plats.add(new MovingPlatform(150, 640, 160, 10, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0));
	 	plats.add(new MovingPlatform(70, 620, 10, 30, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0));
	 	plats.add(new MovingPlatform(170, 620, 30, 20, 0, 1, Color.blue, false, false, true, false, false, true, false, false, 0, 0));
	 	plats.add(new MovingPlatform(210, 620, 30, 20, 0, 1, Color.black, false, false, true, false, false, true, false, false, 0, 0));
	 	plats.add(new MovingPlatform(250, 620, 30, 20, 0, 1, Color.yellow, false, false, true, false, false, true, false, false, 0, 0));
	 	plats.add(new MovingPlatform(360, 630, 120, 20, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0));
	 	plats.add(new MovingPlatform(360, 580, 120, 20, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0));
		plats.add(new MovingPlatform(300, 630, 10, 20, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0));
		plats.add(new MovingPlatform(320, 605, 20, 20, 170, 2, Color.gray, false, true, true, false, false, true, false, false, 0, 0));
		plats.add(new MovingPlatform(520, 610, 130, 20, 0, 1, Color.green, false, false, true, true, false, true, false, false, 0, 0));
		plats.add(new MovingPlatform(490, 635, 10, 10, 180, 2, Color.red, true, false, true, false, false, true, false, false, 0, 0));
		plats.add(new MovingPlatform(690, 630, 110, 20, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0));
		plats.add(new MovingPlatform(690, 570, 20, 60, 0, 1, Color.black, false, false, true, false, true, true, false, false, 0, 0));
		plats.add(new MovingPlatform(740, 550, 10, 40, 0, 1, Color.black, false, false, true, false, true, true, false, false, 0, 0));
		plats.add(new MovingPlatform(720, 480, 20, 170, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0));
		plats.add(new MovingPlatform(720, 495, 30, 10, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0));
		plats.add(new MovingPlatform(763, 505, 40, 20, 100, 1, Color.green, false, false, false, true, false, true, false, false, 0, 0));
		plats.add(new MovingPlatform(750, 475, 60, 20, 0, 1, Color.yellow, false, false, true, false, false, true, false, false, 0, 0));
		plats.add(new MovingPlatform(680, 370, 20, 20, 90, 2, Color.gray, false, true, true, false, false, true, true, false, 60, 0));
		plats.add(new MovingPlatform(600, 450, 20, 20, 90, 2, Color.gray, false, true, true, false, false, true, false, false, 0, 0));
		plats.add(new MovingPlatform(550, 500, 50, 20, 0, 1, Color.black, false, false, true, false, false, true, false, false, 0, 0));
		plats.add(new MovingPlatform(520, 530, 40, 20, 90, 2, Color.blue, false, false, true, false, true, false, false, false, 0, 0));
		plats.add(new MovingPlatform(650, 340, 10, 40, 0, 1, Color.blue, false, false, true, false, true, true, false, false, 0, 0));
		plats.add(new MovingPlatform(740, 410, 10, 85, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(460, 380, 30, 30, 150, 3, Color.gray, false, true, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(500, 550, 80, 10, 90, 2, Color.red, true, false, true, false, false, true, false, false, 0, 0));
		plats.add(new MovingPlatform(660, 340, 10, 60, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0));
		plats.add(new MovingPlatform(530, 430, 10, 70, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(530, 420, 80, 10, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(440, 550, 40, 20, 0, 1, Color.yellow, false, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(430, 370, 60, 50, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(310, 320, 490, 20, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0));	
		plats.add(new MovingPlatform(390, 505, 40, 20, 0, 1, Color.blue, false, false, true, false, true, false, false, false, 0, 0));
		plats.add(new MovingPlatform(420, 370, 10, 40, 0, 1, Color.blue, false, false, true, false, true, true, false, false, 0, 0));
		plats.add(new MovingPlatform(430, 420, 10, 110, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(690, 550, 30, 20, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(480, 420, 10, 180, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(400, 550, 40, 20, 0, 1, Color.blue, false, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(360, 550, 40, 20, 0, 1, Color.black, false, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(350, 450, 10, 150, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(380, 525, 60, 10, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(490, 480, 40, 20, 0, 1, Color.black, false, false, true, false, true, false, false, false, 0, 0));
		plats.add(new MovingPlatform(440, 420, 40, 20, 0, 1, Color.black, false, false, true, false, true, false, false, false, 0, 0));
		plats.add(new MovingPlatform(360, 520, 20, 20, 0, 1, Color.yellow, false, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(360, 450, 50, 10, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(360, 460, 20, 10, 50, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(350, 430, 60, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(0, 220, 750, 10, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(300, 340, 10, 170, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(300, 430, 10, 10, 40, 4, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(310, 460, 10, 10, 40, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(310, 490, 10, 10, 40, 2, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(310, 530, 40, 20, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(250, 530, 60, 20, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(10, 450, 60, 20, 230, 1, Color.yellow, false, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(200, 320, 110, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(10, 500, 60, 20, 230, 1, Color.blue, false, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(10, 400, 60, 20, 230, 1, Color.black, false, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(240, 380, 10, 170, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(190, 320, 10, 160, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(130, 380, 10, 160, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(80, 320, 10, 160, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(90, 320, 100, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(0, 540, 250, 10, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(0, 230, 10, 320, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(20, 300, 50, 20, 60, 2, Color.blue, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(80, 230, 20, 90, 180, 1, Color.gray, false, true, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(80, 310, 180, 10, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(80, 270, 10, 70, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(120, 220, 10, 30, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(160, 220, 10, 40, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(200, 220, 10, 60, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(240, 220, 10, 70, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(120, 270, 10, 50, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(160, 280, 10, 30, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(200, 300, 10, 20, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(340, 230, 10, 90, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(380, 230, 10, 90, 0, 1, Color.blue, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(420, 230, 10, 90, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(460, 230, 10, 90, 0, 1, Color.blue, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(500, 230, 10, 90, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(540, 230, 10, 90, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(580, 230, 10, 90, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(620, 230, 10, 90, 0, 1, Color.blue, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(660, 230, 10, 90, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(700, 230, 10, 90, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(740, 230, 10, 90, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(550, 300, 40, 20, 110, 1, Color.green, false, false, true, true, false, false, false, false, 0, 1));
		plats.add(new MovingPlatform(590, 300, 40, 20, 110, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(300, 300, 40, 20, 110, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(10, 250, 80, 20, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(360, 280, 10, 40, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(440, 280, 10, 40, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(480, 230, 10, 40, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));		
		plats.add(new MovingPlatform(520, 230, 10, 50, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(280, 230, 40, 36, 0, 1, Color.gray, false, true, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(740, 300, 60, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(400, 230, 10, 40, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));	
		plats.add(new MovingPlatform(760, 220, 40, 20, 40, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(0, 130, 40, 20, 0, 1, Color.blue, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(560, 270, 10, 50, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(600, 290, 10, 30, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(640, 230, 10, 40, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(680, 280, 10, 40, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(720, 230, 10, 40, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(750, 40, 50, 20, 0, 1, Color.blue, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(760, 0, 30, 30, 170, 1, Color.gray, false, true, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(740, 40, 10, 180, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(750, 60, 10, 140, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(790, 60, 10, 140, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(690, 200, 50, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(730, 160, 20, 40, 0, 1, Color.yellow, false, false, true, false, true, true, false, false, 0, 0));
		plats.add(new MovingPlatform(730, 0, 20, 40, 0, 1, Color.yellow, false, false, true, false, true, true, false, false, 0, 0));
		plats.add(new MovingPlatform(730, 0, 10, 160, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(590, 200, 10, 20, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(490, 200, 10, 20, 0, 1, Color.blue, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(390, 200, 10, 20, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(290, 200, 10, 20, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(190, 200, 10, 20, 0, 1, Color.blue, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(90, 200, 10, 20, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(40, 190, 10, 10, 650, 10, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(0, 180, 40, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(680, 190, 10, 10, 650, 10, Color.red, true, false, true, false, false, false, false, false, 0, 1));
		plats.add(new MovingPlatform(50, 110, 680, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(50, 100, 630, 10, 0, 1, Color.gray, false, true, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(0, 50, 680, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(680, 50, 50, 20, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(100, 70, 10, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(150, 90, 10, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(190, 90, 10, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(240, 70, 10, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(290, 90, 10, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(350, 70, 10, 10, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(420, 90, 10, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(470, 90, 10, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(520, 90, 10, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(620, 70, 10, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(560, 90, 10, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(350, 100, 10, 30, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(680, 170, 10, 10, 640, 2, Color.red, true, false, true, false, false, false, false, false, 0, 1));
		plats.add(new MovingPlatform(40, 150, 10, 10, 650, 5, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(40, 100, 10, 30, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(620, 90, 10, 20, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(100, 90, 10, 20, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0));		
		plats.add(new MovingPlatform(290, 70, 10, 20, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(470, 70, 10, 20, 0, 1, Color.blue, false, false, false, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(-780, 70, 760, 40, 760, 4, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(670, 90, 60, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(0, 0, 180, 60, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(40, 130, 10, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(30, 200, 20, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0));
		plats.add(new MovingPlatform(340, 35, 10, 10, 300, 15, Color.red, true, false, true, false, false, false, false, false, 0, 0));
		
		// GAME LOOP
		while(running) {
				
			startTime = System.nanoTime();
	
			winner();
			
			gameUpdate();
			gameRender();
			gameDraw();
			
			URDTimeMillis = (System.nanoTime()- startTime)/1000000;
			
			waitTime = targetTime-URDTimeMillis;	
			
			try {
				Thread.sleep(waitTime);
			} catch (Exception e) { }
			
			if (!running) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) { }
			}
		}
		
		thread6 = new Thread() {
			public void run() {
				winsound.starting("/Resources/e.wav", -2.0f);	
			}
		};
		
		thread6.start();
		
		while (!running) {
			scoreScreen();
			gameDraw();
			try {
				Thread.sleep(3000);
			} catch (Exception e) { }
		}
		
	}
	
	//game logic
	private void gameUpdate() {
		
		for (int i = 0; i < plats.size(); i++) {
		
		plats.get(i).update();	
		
		}

		player.update();
		
	}
	
	//draws everything off screen
	private void gameRender() {
		
		long currenttime = System.nanoTime() - starttimer;
		double interimtime = (double)(currenttime/1000000000);
		double timer = Math.floor(interimtime);
		
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT - 50);
		g.setColor(new Color(0,255,0));
		g.fillRect(0, HEIGHT - 50, WIDTH, 50);
		
		g.setColor(Color.pink);
		g.fillRect(200, 10, 80, 20);
		
		g.setColor(Color.black); //flag
		g.setStroke(new BasicStroke(2));
		g.drawLine(23, 649, 23, 613);
		g.drawLine(380, 400, 380, 430);
		g.drawLine(280, 290, 280, 320);
		g.drawLine(710, 170, 710, 200);
		g.drawLine(200, 10, 200, 50);
		g.drawLine(280, 10, 280, 50);
		g.drawLine(10, 150, 10, 180);
		g.drawLine(580, 610, 580, 580);
		g.drawString("F I N I S H", 210, 25);

		int xpoints[] = new int [] {24,40,24};
		int ypoints[] = new int[] {615,619,623};
		int npoints = 3;

		g.setColor(Color.green);
		g.fillPolygon(xpoints, ypoints, npoints);
		
		for (int i = 0; i < plats.size(); i++) {	
			plats.get(i).draw(g);		
		}
		
		g.setColor(Color.black);
		g.drawString("Z", 180, 635);
		
		g.setColor(Color.white);
		g.drawString("V", plats.get(9).getX() + 6, plats.get(9).getY() + 15);
		
		g.setColor(Color.yellow);
		g.drawString("X", 220, 635);
		
		g.setColor(Color.blue);
		g.drawString("C", 260, 635);
		
		g.setColor(Color.black);
		g.drawString("Time: " + (int)timer, 30, 25);
		score = 10000 - (int)timer - (player.getdeaths() * 10);
		g.drawString("Score: " + score, 30, 45);
		
		player.draw(g);
	
	}
	
	//draw on screen
	private void gameDraw() {
		Graphics g2 = this.getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
		
	}

	private void winner() {
		if (player.returnWin()) {
			running = false;
		}
	}
	
	private void scoreScreen() {
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.gray);
		Font f = new Font(Font.SANS_SERIF, 24, 24);
		g.setFont(f);
		g.drawString("Y O U   H A V E   C O M P L E T E D ", WIDTH/2 - 200, HEIGHT/2 -200);
		g.drawString("B A L L   A D V E N T U R E   2", WIDTH/2 - 170, HEIGHT/2  - 170);
		
		Font p = new Font(Font.SANS_SERIF, 24, 16);
		g.setFont(p);
		
		g.setColor(Color.green);
		g.drawString("F I N A L   S C O R E:   " + score, 300, 400);
		g.setColor(Color.red);
		g.drawString("D E A T H S:   " + player.getdeaths(), 340, 440);
		g.setColor(Color.blue);
		g.drawString("T O T A L   T I M E:   " + (10000 - score - (player.getdeaths() * 10)), 320, 480);
	}
	
	private void startScreen() {
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.black);
		g.drawString("P R E S S   E N T E R   T O   S T A R T", WIDTH/2 - 108, HEIGHT/2 + 80);
		g.drawString("I N S T R U C T I O N S", WIDTH/2 - 70, HEIGHT/2 - 140);
		
		g.setColor(Color.gray);
		g.drawString(" Move with the arrow keys ", WIDTH/2 - 83, HEIGHT/2 - 70);
		g.drawString(" Figure the rest out yourself ", WIDTH/2 - 83, HEIGHT/2 - 10);

		g.setColor(Color.red);
		g.drawString("Red", WIDTH/2 - 33, HEIGHT/2 - 40);
		g.drawString(" = bad", WIDTH/2 - 11, HEIGHT/2 - 40);
		
	}
	
	public void keyTyped(KeyEvent e) {}
	
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		if (keyCode == KeyEvent.VK_LEFT) {
			player.setLeft(true);
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			player.setRight(true);
		}
		if (keyCode == KeyEvent.VK_UP) {
			player.setUp(true);
		}
		if (keyCode == KeyEvent.VK_Z) {
			player.setColorg(Color.blue);
		}
		if (keyCode == KeyEvent.VK_C) {
			player.setColory(Color.yellow);
		}
		if (keyCode == KeyEvent.VK_X) {
			player.setColorb(Color.black);
		}
		if (keyCode == KeyEvent.VK_V) {
			player.setColorv(Color.gray);
		}
		if (keyCode == KeyEvent.VK_ENTER) {
			play = false;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
	
		if (keyCode == KeyEvent.VK_LEFT) {
			player.setLeft(false);
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			player.setRight(false);
		}
		if (keyCode == KeyEvent.VK_UP) {
			player.setUp(false);
		}
		
	}	

}