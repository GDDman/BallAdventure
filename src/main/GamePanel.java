package main;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.awt.event.*;

//Game
public class GamePanel extends JPanel implements Runnable, KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  final int WIDTH = 800;
	public  final int HEIGHT = 700;
	private  long starttimer;
	
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
    public  ArrayList<MovingPlatform> plats;
	
	public Player player;
	
	public MovingPlatform platform1;
	public MovingPlatform platform2;
	public MovingPlatform platform3;
	public MovingPlatform platform4;
	public MovingPlatform platform5;
	public MovingPlatform platform6;
	public MovingPlatform platform7;
	public MovingPlatform platform8;
	public MovingPlatform platform9;
	public MovingPlatform platform10;
	public MovingPlatform platform11;
	public MovingPlatform platform12;
	public MovingPlatform platform13;
	public MovingPlatform platform14;
	public MovingPlatform platform15;
	public MovingPlatform platform16;
	public MovingPlatform platform17;
	public MovingPlatform platform18;
	public MovingPlatform platform19;
	public MovingPlatform platform20;
	public MovingPlatform platform21;
	public MovingPlatform platform22;
	public MovingPlatform platform23;
	public MovingPlatform platform24;
	public MovingPlatform platform25;
	public MovingPlatform platform26;
	public  MovingPlatform platform27;
	public  MovingPlatform platform28;
	public  MovingPlatform platform29;
	public  MovingPlatform platform30;
	public  MovingPlatform platform31;
	public  MovingPlatform platform32;
	public  MovingPlatform platform33;
	public  MovingPlatform platform34;
	public  MovingPlatform platform35;
	public  MovingPlatform platform36; 
	public  MovingPlatform platform37;
	public  MovingPlatform platform38;
	public  MovingPlatform platform39;
	public  MovingPlatform platform40;
	public  MovingPlatform platform41;
	public  MovingPlatform platform42;
	public  MovingPlatform platform43;
	public  MovingPlatform platform44;
	public  MovingPlatform platform45;
	public  MovingPlatform platform46;
	public  MovingPlatform platform47;
	public  MovingPlatform platform48;
	public  MovingPlatform platform49;
	public  MovingPlatform platform50;
	public  MovingPlatform platform51;
	public  MovingPlatform platform52;
	public  MovingPlatform platform53;
	public  MovingPlatform platform54;
	public  MovingPlatform platform55;
	public  MovingPlatform platform56;
	public  MovingPlatform platform57;
	public  MovingPlatform platform58;
	public  MovingPlatform platform59;
	public  MovingPlatform platform60;
	public  MovingPlatform platform61;
	public  MovingPlatform platform62;
	public  MovingPlatform platform63;
	public  MovingPlatform platform64;
	public  MovingPlatform platform65;
	public  MovingPlatform platform66;
	public  MovingPlatform platform67;
	public  MovingPlatform platform68;
	public  MovingPlatform platform69;
	public  MovingPlatform platform70;
	public  MovingPlatform platform71;
	public  MovingPlatform platform72;
	public  MovingPlatform platform73;
	public  MovingPlatform platform74;
	public  MovingPlatform platform75;
	public  MovingPlatform platform76;
	public  MovingPlatform platform77;
	public  MovingPlatform platform78;
	public  MovingPlatform platform79;
	public  MovingPlatform platform80;
	public  MovingPlatform platform81;
	public  MovingPlatform platform82;
	public  MovingPlatform platform83;
	public  MovingPlatform platform84;
	public  MovingPlatform platform85;
	public  MovingPlatform platform86;
	public  MovingPlatform platform87;
	public  MovingPlatform platform88;
	public  MovingPlatform platform89;
	public  MovingPlatform platform90;
	public  MovingPlatform platform91;
	public  MovingPlatform platform92;
	public  MovingPlatform platform93;
	public  MovingPlatform platform94;
	public  MovingPlatform platform95;
	public  MovingPlatform platform96;
	public  MovingPlatform platform97;
	public  MovingPlatform platform98;
	public  MovingPlatform platform99;
	public  MovingPlatform platform100;
	public  MovingPlatform platform101;
	public  MovingPlatform platform102;
	public  MovingPlatform platform103;
	public  MovingPlatform platform104;
	public  MovingPlatform platform105;
	public  MovingPlatform platform106;
	public  MovingPlatform platform107;
	public  MovingPlatform platform108;
	public  MovingPlatform platform109;
	public  MovingPlatform platform110;
	public  MovingPlatform platform111;
	public  MovingPlatform platform112;
	public  MovingPlatform platform113;
	public  MovingPlatform platform114;
	public  MovingPlatform platform115;
	public  MovingPlatform platform116;
	public  MovingPlatform platform117;
	public  MovingPlatform platform118;
	public  MovingPlatform platform119;
	public  MovingPlatform platform120;
	public  MovingPlatform platform121;
	public  MovingPlatform platform122;
	public  MovingPlatform platform123;
	public  MovingPlatform platform124;
	public  MovingPlatform platform125;
	public  MovingPlatform platform126;
	public  MovingPlatform platform127;
	public  MovingPlatform platform128;
	public  MovingPlatform platform129;
	public  MovingPlatform platform130;
	public  MovingPlatform platform131;
	public  MovingPlatform platform132;
	public  MovingPlatform platform133;
	public  MovingPlatform platform134;
	public  MovingPlatform platform135;
	public  MovingPlatform platform136;
	public  MovingPlatform platform137;
	public  MovingPlatform platform138;
	public  MovingPlatform platform139;
	public  MovingPlatform platform140;
	public  MovingPlatform platform141;
	public  MovingPlatform platform142;
	public  MovingPlatform platform143;
	public  MovingPlatform platform144;
	public  MovingPlatform platform145;
	public  MovingPlatform platform146;
	public  MovingPlatform platform147;
	public  MovingPlatform platform148;
	public  MovingPlatform platform149;
	public  MovingPlatform platform150;
	public  MovingPlatform platform151;
	public  MovingPlatform platform152;
	public  MovingPlatform platform153;
	
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
		
		//                             x   y   wdth ht dis spd   color   kill   stick  dir    safe?  link? side? changedir? newdir + # offset
		//																			 true = </>			 true = </>		  true = </>
 		platform1 = new MovingPlatform(80, 610, 30, 40, 40, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0);
	 	platform2 = new MovingPlatform(150, 640, 160, 10, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0);
		platform3 = new MovingPlatform(70, 620, 10, 30, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0);
		platform4 = new MovingPlatform(170, 620, 30, 20, 0, 1, Color.blue, false, false, true, false, false, true, false, false, 0, 0);
		platform5 = new MovingPlatform(210, 620, 30, 20, 0, 1, Color.black, false, false, true, false, false, true, false, false, 0, 0);
		platform6 = new MovingPlatform(250, 620, 30, 20, 0, 1, Color.yellow, false, false, true, false, false, true, false, false, 0, 0);
		platform7 = new MovingPlatform(360, 630, 120, 20, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0);
		platform8 = new MovingPlatform(360, 580, 120, 20, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0);
		platform9 = new MovingPlatform(300, 630, 10, 20, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0);
		platform10 = new MovingPlatform(320, 605, 20, 20, 170, 2, Color.gray, false, true, true, false, false, true, false, false, 0, 0);
		platform11 = new MovingPlatform(520, 610, 130, 20, 0, 1, Color.green, false, false, true, true, false, true, false, false, 0, 0);
		platform12 = new MovingPlatform(490, 635, 10, 10, 180, 2, Color.red, true, false, true, false, false, true, false, false, 0, 0);
		platform13 = new MovingPlatform(690, 630, 110, 20, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0);
		platform14 = new MovingPlatform(690, 570, 20, 60, 0, 1, Color.black, false, false, true, false, true, true, false, false, 0, 0);
		platform15 = new MovingPlatform(740, 550, 10, 40, 0, 1, Color.black, false, false, true, false, true, true, false, false, 0, 0);
		platform16 = new MovingPlatform(720, 480, 20, 170, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0);
		platform17 = new MovingPlatform(720, 495, 30, 10, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0);
		platform18 = new MovingPlatform(763, 505, 40, 20, 100, 1, Color.green, false, false, false, true, false, true, false, false, 0, 0);
		platform19 = new MovingPlatform(750, 475, 60, 20, 0, 1, Color.yellow, false, false, true, false, false, true, false, false, 0, 0);
		platform20 = new MovingPlatform(680, 370, 20, 20, 90, 2, Color.gray, false, true, true, false, false, true, true, false, 60, 0);
		platform21 = new MovingPlatform(600, 450, 20, 20, 90, 2, Color.gray, false, true, true, false, false, true, false, false, 0, 0);
		platform22 = new MovingPlatform(550, 500, 50, 20, 0, 1, Color.black, false, false, true, false, false, true, false, false, 0, 0);
		platform23 = new MovingPlatform(520, 530, 40, 20, 90, 2, Color.blue, false, false, true, false, true, false, false, false, 0, 0);
		platform24 = new MovingPlatform(650, 340, 10, 40, 0, 1, Color.blue, false, false, true, false, true, true, false, false, 0, 0);
		platform25 = new MovingPlatform(740, 410, 10, 85, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform26 = new MovingPlatform(460, 380, 30, 30, 150, 3, Color.gray, false, true, true, false, false, false, false, false, 0, 0);
		platform27 = new MovingPlatform(500, 550, 80, 10, 90, 2, Color.red, true, false, true, false, false, true, false, false, 0, 0);
		platform28 = new MovingPlatform(660, 340, 10, 60, 0, 1, Color.red, true, false, true, false, false, true, false, false, 0, 0);
		platform29 = new MovingPlatform(530, 430, 10, 70, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0);
		platform30 = new MovingPlatform(530, 420, 80, 10, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0);
		platform31 = new MovingPlatform(440, 550, 40, 20, 0, 1, Color.yellow, false, false, true, false, false, false, false, false, 0, 0);
		platform32 = new MovingPlatform(430, 370, 60, 50, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0);
		platform33 = new MovingPlatform(310, 320, 490, 20, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0);	
		platform34 = new MovingPlatform(390, 505, 40, 20, 0, 1, Color.blue, false, false, true, false, true, false, false, false, 0, 0);
		platform35 = new MovingPlatform(420, 370, 10, 40, 0, 1, Color.blue, false, false, true, false, true, true, false, false, 0, 0);
		platform36 = new MovingPlatform(430, 420, 10, 110, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0);
		platform37 = new MovingPlatform(690, 550, 30, 20, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0);
		platform38 = new MovingPlatform(480, 420, 10, 180, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0);
		platform39 = new MovingPlatform(400, 550, 40, 20, 0, 1, Color.blue, false, false, true, false, false, false, false, false, 0, 0);
		platform40 = new MovingPlatform(360, 550, 40, 20, 0, 1, Color.black, false, false, true, false, false, false, false, false, 0, 0);
		platform41 = new MovingPlatform(350, 450, 10, 150, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0);
		platform42 = new MovingPlatform(380, 525, 60, 10, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0);
		platform43 = new MovingPlatform(490, 480, 40, 20, 0, 1, Color.black, false, false, true, false, true, false, false, false, 0, 0);
		platform44 = new MovingPlatform(440, 420, 40, 20, 0, 1, Color.black, false, false, true, false, true, false, false, false, 0, 0);
		platform45 = new MovingPlatform(360, 520, 20, 20, 0, 1, Color.yellow, false, false, true, false, false, false, false, false, 0, 0);
		platform46 = new MovingPlatform(360, 450, 50, 10, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform47 = new MovingPlatform(360, 460, 20, 10, 50, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform48 = new MovingPlatform(350, 430, 60, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform49 = new MovingPlatform(0, 220, 750, 10, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0);
		platform50 = new MovingPlatform(300, 340, 10, 170, 0, 1, Color.red, true, false, false, false, false, false, false, false, 0, 0);
		platform51 = new MovingPlatform(300, 430, 10, 10, 40, 4, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform52 = new MovingPlatform(310, 460, 10, 10, 40, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform53 = new MovingPlatform(310, 490, 10, 10, 40, 2, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform54 = new MovingPlatform(310, 530, 40, 20, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0);
		platform55 = new MovingPlatform(250, 530, 60, 20, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0);
		platform56 = new MovingPlatform(10, 450, 60, 20, 230, 1, Color.yellow, false, false, true, false, false, false, false, false, 0, 0);
		platform57 = new MovingPlatform(200, 320, 110, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform58 = new MovingPlatform(10, 500, 60, 20, 230, 1, Color.blue, false, false, true, false, false, false, false, false, 0, 0);
		platform59 = new MovingPlatform(10, 400, 60, 20, 230, 1, Color.black, false, false, true, false, false, false, false, false, 0, 0);
		platform60 = new MovingPlatform(240, 380, 10, 170, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform61 = new MovingPlatform(190, 320, 10, 160, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform62 = new MovingPlatform(130, 380, 10, 160, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform63 = new MovingPlatform(80, 320, 10, 160, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform64 = new MovingPlatform(90, 320, 100, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform65 = new MovingPlatform(0, 540, 250, 10, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform66 = new MovingPlatform(0, 230, 10, 320, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform67 = new MovingPlatform(20, 300, 50, 20, 60, 2, Color.blue, false, false, false, false, false, false, false, false, 0, 0);
		platform68 = new MovingPlatform(80, 230, 20, 90, 180, 1, Color.gray, false, true, true, false, false, false, false, false, 0, 0);
		platform69 = new MovingPlatform(80, 310, 180, 10, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform70 = new MovingPlatform(80, 270, 10, 70, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform71 = new MovingPlatform(120, 220, 10, 30, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform72 = new MovingPlatform(160, 220, 10, 40, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform73 = new MovingPlatform(200, 220, 10, 60, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform74 = new MovingPlatform(240, 220, 10, 70, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform75 = new MovingPlatform(120, 270, 10, 50, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform76 = new MovingPlatform(160, 280, 10, 30, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform77 = new MovingPlatform(200, 300, 10, 20, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform78 = new MovingPlatform(340, 230, 10, 90, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0);
		platform79 = new MovingPlatform(380, 230, 10, 90, 0, 1, Color.blue, false, false, false, false, false, false, false, false, 0, 0);
		platform80 = new MovingPlatform(420, 230, 10, 90, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0);
		platform81 = new MovingPlatform(460, 230, 10, 90, 0, 1, Color.blue, false, false, false, false, false, false, false, false, 0, 0);
		platform82 = new MovingPlatform(500, 230, 10, 90, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0);
		platform83 = new MovingPlatform(540, 230, 10, 90, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0);
		platform84 = new MovingPlatform(580, 230, 10, 90, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0);
		platform85 = new MovingPlatform(620, 230, 10, 90, 0, 1, Color.blue, false, false, false, false, false, false, false, false, 0, 0);
		platform86 = new MovingPlatform(660, 230, 10, 90, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0);
		platform87 = new MovingPlatform(700, 230, 10, 90, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0);
		platform88 = new MovingPlatform(740, 230, 10, 90, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0);
		platform89 = new MovingPlatform(550, 300, 40, 20, 110, 1, Color.green, false, false, true, true, false, false, false, false, 0, 1);
		platform90 = new MovingPlatform(590, 300, 40, 20, 110, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform91 = new MovingPlatform(300, 300, 40, 20, 110, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform92 = new MovingPlatform(10, 250, 80, 20, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0);
		platform93 = new MovingPlatform(360, 280, 10, 40, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform94 = new MovingPlatform(440, 280, 10, 40, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform95 = new MovingPlatform(480, 230, 10, 40, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);		
		platform96 = new MovingPlatform(520, 230, 10, 50, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform97 = new MovingPlatform(280, 230, 40, 36, 0, 1, Color.gray, false, true, true, false, false, false, false, false, 0, 0);
		platform98 = new MovingPlatform(740, 300, 60, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform99 = new MovingPlatform(400, 230, 10, 40, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);	
		platform100 = new MovingPlatform(760, 220, 40, 20, 40, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0);
		platform101 = new MovingPlatform(0, 130, 40, 20, 0, 1, Color.blue, false, false, false, false, false, false, false, false, 0, 0);
		platform102 = new MovingPlatform(560, 270, 10, 50, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform103 = new MovingPlatform(600, 290, 10, 30, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform104 = new MovingPlatform(640, 230, 10, 40, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform105 = new MovingPlatform(680, 280, 10, 40, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform106 = new MovingPlatform(720, 230, 10, 40, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform107 = new MovingPlatform(750, 40, 50, 20, 0, 1, Color.blue, false, false, false, false, false, false, false, false, 0, 0);
		platform108 = new MovingPlatform(760, 0, 30, 30, 170, 1, Color.gray, false, true, false, false, false, false, false, false, 0, 0);
		platform109 = new MovingPlatform(740, 40, 10, 180, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform110 = new MovingPlatform(750, 60, 10, 140, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform111 = new MovingPlatform(790, 60, 10, 140, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform112 = new MovingPlatform(690, 200, 50, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform113 = new MovingPlatform(730, 160, 20, 40, 0, 1, Color.yellow, false, false, true, false, true, true, false, false, 0, 0);
		platform114 = new MovingPlatform(730, 0, 20, 40, 0, 1, Color.yellow, false, false, true, false, true, true, false, false, 0, 0);
		platform115 = new MovingPlatform(730, 0, 10, 160, 0, 1, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform116 = new MovingPlatform(590, 200, 10, 20, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0);
		platform117 = new MovingPlatform(490, 200, 10, 20, 0, 1, Color.blue, false, false, false, false, false, false, false, false, 0, 0);
		platform118 = new MovingPlatform(390, 200, 10, 20, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0);
		platform119 = new MovingPlatform(290, 200, 10, 20, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0);
		platform120 = new MovingPlatform(190, 200, 10, 20, 0, 1, Color.blue, false, false, false, false, false, false, false, false, 0, 0);
		platform121 = new MovingPlatform(90, 200, 10, 20, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0);
		platform122 = new MovingPlatform(40, 190, 10, 10, 650, 10, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform123 = new MovingPlatform(0, 180, 40, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform124 = new MovingPlatform(680, 190, 10, 10, 650, 10, Color.red, true, false, true, false, false, false, false, false, 0, 1);
		platform125 = new MovingPlatform(50, 110, 680, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform126 = new MovingPlatform(50, 100, 630, 10, 0, 1, Color.gray, false, true, false, false, false, false, false, false, 0, 0);
		platform127 = new MovingPlatform(0, 50, 680, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform128 = new MovingPlatform(680, 50, 50, 20, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0);
		platform129 = new MovingPlatform(100, 70, 10, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform130 = new MovingPlatform(150, 90, 10, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform131 = new MovingPlatform(190, 90, 10, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform132 = new MovingPlatform(240, 70, 10, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform133 = new MovingPlatform(290, 90, 10, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform134 = new MovingPlatform(350, 70, 10, 10, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform135 = new MovingPlatform(420, 90, 10, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform136 = new MovingPlatform(470, 90, 10, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform137 = new MovingPlatform(520, 90, 10, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform138 = new MovingPlatform(620, 70, 10, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform139 = new MovingPlatform(560, 90, 10, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform140 = new MovingPlatform(350, 100, 10, 30, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform141 = new MovingPlatform(680, 170, 10, 10, 640, 2, Color.red, true, false, true, false, false, false, false, false, 0, 1);
		platform142 = new MovingPlatform(40, 150, 10, 10, 650, 5, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform143 = new MovingPlatform(40, 100, 10, 30, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform144 = new MovingPlatform(620, 90, 10, 20, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0);
		platform145 = new MovingPlatform(100, 90, 10, 20, 0, 1, Color.yellow, false, false, false, false, false, false, false, false, 0, 0);		
		platform146 = new MovingPlatform(290, 70, 10, 20, 0, 1, Color.black, false, false, false, false, false, false, false, false, 0, 0);
		platform147 = new MovingPlatform(470, 70, 10, 20, 0, 1, Color.blue, false, false, false, false, false, false, false, false, 0, 0);
		platform148 = new MovingPlatform(-780, 70, 760, 40, 760, 4, Color.red, true, false, true, false, false, false, false, false, 0, 0);
		platform149 = new MovingPlatform(670, 90, 60, 40, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform150 = new MovingPlatform(0, 0, 180, 60, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform151 = new MovingPlatform(40, 130, 10, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform152 = new MovingPlatform(30, 200, 20, 20, 0, 1, Color.green, false, false, true, true, false, false, false, false, 0, 0);
		platform153 = new MovingPlatform(340, 35, 10, 10, 300, 15, Color.red, true, false, true, false, false, false, false, false, 0, 0);
	
		
		plats = new ArrayList<MovingPlatform>();
		
		plats.add(platform1);
		plats.add(platform2);
		plats.add(platform3);
		plats.add(platform4);
		plats.add(platform5);
		plats.add(platform6);
		plats.add(platform7);
		plats.add(platform8);
		plats.add(platform9);
		plats.add(platform10);
		plats.add(platform11);
		plats.add(platform12);
		plats.add(platform13);
		plats.add(platform14);
		plats.add(platform15);
		plats.add(platform16);
		plats.add(platform17);
		plats.add(platform18);
		plats.add(platform19);
		plats.add(platform20);
		plats.add(platform21);
		plats.add(platform22);
		plats.add(platform23);
		plats.add(platform24);
		plats.add(platform25);
		plats.add(platform26);
		plats.add(platform27);
		plats.add(platform28);
		plats.add(platform29);
		plats.add(platform30);
		plats.add(platform31);
		plats.add(platform32);
		plats.add(platform33);
		plats.add(platform34);
		plats.add(platform35);
		plats.add(platform36);
		plats.add(platform37);
		plats.add(platform38);
		plats.add(platform39);
		plats.add(platform40);
		plats.add(platform41);
		plats.add(platform42);
		plats.add(platform43);
		plats.add(platform44);
		plats.add(platform45);
		plats.add(platform46);
		plats.add(platform47);
		plats.add(platform48);
		plats.add(platform49);
		plats.add(platform50);
		plats.add(platform51);
		plats.add(platform52);
		plats.add(platform53);
		plats.add(platform54);
		plats.add(platform55);
		plats.add(platform56);
		plats.add(platform57);
		plats.add(platform58);
		plats.add(platform59);
		plats.add(platform60);
		plats.add(platform61);
		plats.add(platform62);
		plats.add(platform63);
		plats.add(platform64);
		plats.add(platform65);
		plats.add(platform66);
		plats.add(platform67);
		plats.add(platform68);
		plats.add(platform69);
		plats.add(platform70);
		plats.add(platform71);
		plats.add(platform72);
		plats.add(platform73);
		plats.add(platform74);
		plats.add(platform75);
		plats.add(platform76);
		plats.add(platform77);
		plats.add(platform78);
		plats.add(platform79);
		plats.add(platform80);
		plats.add(platform81);
		plats.add(platform82);
		plats.add(platform83);
		plats.add(platform84);
		plats.add(platform82);
		plats.add(platform83);
		plats.add(platform84);
		plats.add(platform85);
		plats.add(platform86);
		plats.add(platform87);
		plats.add(platform88);
		plats.add(platform89);
		plats.add(platform90);
		plats.add(platform91);
		plats.add(platform92);
		plats.add(platform93);
		plats.add(platform94);
		plats.add(platform95);
		plats.add(platform96);
		plats.add(platform97);
		plats.add(platform98);
		plats.add(platform99);
		plats.add(platform100);
		plats.add(platform101);
		plats.add(platform102);
		plats.add(platform103);
		plats.add(platform104);
		plats.add(platform105);
		plats.add(platform106);
		plats.add(platform107);
		plats.add(platform108);
		plats.add(platform109);
		plats.add(platform110);
		plats.add(platform111);
		plats.add(platform112);
		plats.add(platform113);
		plats.add(platform114);
		plats.add(platform115);
		plats.add(platform116);
		plats.add(platform117);
		plats.add(platform118);
		plats.add(platform119);
		plats.add(platform120);
		plats.add(platform121);
		plats.add(platform122);
		plats.add(platform123);
		plats.add(platform124);
		plats.add(platform125);
		plats.add(platform126);
		plats.add(platform127);
		plats.add(platform128);
		plats.add(platform129);
		plats.add(platform130);
		plats.add(platform131);
		plats.add(platform132);
		plats.add(platform133);
		plats.add(platform134);
		plats.add(platform135);
		plats.add(platform136);
		plats.add(platform137);
		plats.add(platform138);
		plats.add(platform139);
		plats.add(platform140);
		plats.add(platform141);
		plats.add(platform142);
		plats.add(platform143);
		plats.add(platform144);
		plats.add(platform145);
		plats.add(platform146);
		plats.add(platform147);
		plats.add(platform148);
		plats.add(platform149);
		plats.add(platform150);
		plats.add(platform151);
		plats.add(platform152);
		plats.add(platform153);
		
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
		g.drawString("V", platform10.hit()[0] + 6, platform10.hit()[1] + 15);
		
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