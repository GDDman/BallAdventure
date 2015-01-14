package main;

import java.awt.*;

public class Player extends GamePanel {

	// fields 
	private static final long serialVersionUID = 1L;
	private int jumpcounter;
	private boolean jumping;
	private boolean win;
	private int jumpcount;
	
	private int x;
	private int y;
	private int r;
	private int deaths;
	private int spawnx;
	private int spawny;

	private int dx;
	private int dy;
	private int speed;
	
	private boolean left;
	private boolean right;
	private boolean up;
	
	private Color color1;
	private String currentcolor;
	private Color colmatch;
	
	private boolean kill;
	private int[] hitdetect;
	private int[] dimensions; 
	private boolean stick;
	private int[] stickxy;
	private boolean dir;
	private boolean safe;
	private boolean touch;
	private boolean portaled;
	private boolean portalstart;
	private int portalspd;

	private boolean contact; 
	private boolean falling;
	private boolean fall;
	public static Flag flag2;
	public static Flag flag3;
	public static Flag flag4;
	public static Flag flag5;
	public static Flag flag6;
	
	// player object	
	public Player() {
		
		flag2 = new Flag(381, 400, false);
		flag3 = new Flag(280, 290, false);
		flag4 = new Flag(710, 170, false);
		flag5 = new Flag(10, 150, false);
		flag6 = new Flag(580, 580, false);
		
		x = 23;
		y = 660;
		r = 5;
		
		jumpcounter = 0;
		jumping = false;
		deaths = 0;
		contact = false;	
		falling = true;
		touch = false;
		portaled = false;
		portalstart = false;
		portalspd = 0;
		spawnx = 23;
		spawny = 650;
		win = false;
		jumpcount = 0;
		fall = false;
		
		dx = 0;
		dy = 0;
		speed = 5;
		
		color1 = Color.yellow;
	}
	
	// functions 
	public void setLeft(boolean b) {left = b;}
	public void setRight(boolean b) {right = b;}
	public void setUp(boolean b) {up = b;}
	public void setColorg(Color g) {color1 = g;}
	public void setColory(Color y) {color1 = y;}
	public void setColorb(Color b) {color1 = b;}
	
	public void setColorv(Color v) {
		
		if (y < 220 || y > 320) {
			color1 = v;
		}
		else if (x < 280) {
			color1 = v;
		}

	}
	
	public void update() {
		
		checkPoint();
		checkv();
		checkWin();
		
		for (int i = 0; i < plats.size(); i++) {
			
		checkTouch(plats.get(i));	
		
		}
		
		if(left) {
			dx = -speed;
		}
		if(right) {
			dx = speed;
		}
		if(up) {
			
			jumping = true;
			
			if (contact && !fall) {
				
				jumpcounter = 0;
				contact = false;
				jumpcount++;
				
				if (dx == 0) {
					
					for (int i = 0; i < plats.size(); i++) {
						
						plats.get(i).touchfalse();	
						
					}	
				}
			} 
		}
		
		if (jumping) {
			
			jumpcounter++;
	    	
		    dy = -((650*jumpcounter) - (50*jumpcounter*jumpcounter))/300; 
		    
		    if (jumpcounter >= 17) {
		    	jumpcounter = 17;
		    }
		    
		}	
		
		for (int i = 0; i < plats.size(); i++) {
			if (plats.get(i).returnLink() == false) {
				phits(plats.get(i), null);	
			}
		}
		
		//linking portals
		phits(platform14, platform15);
		phits(platform15, platform14);
		phits(platform23, platform24);
		phits(platform24, platform23);
		phits(platform34, platform35);
		phits(platform35, platform34);
		phits(platform43, platform44);
		phits(platform44, platform43);
		phits(platform113, platform114);
		phits(platform114, platform113);
		
		if (portaled) {
			
			if (portalstart) {
				portalspd = -7;
				portalstart = false;
			}
			
			if (right) {
				portalspd += speed;
			}
			if (left) {
				portalspd += -speed;
			}
			
			if (portalspd < -10) {
				portalspd = -10;
			}
			if (portalspd > 10) {
				portalspd = 10;
			}
			
			dx = portalspd;
		
		}

		x += dx;
		y += dy; 
		
		checkFall();
		
		if(x<r) {x=r; portaled = false;}
		if(y<r) {y=r; falling = true;}
		if(x > GamePanel.WIDTH - r) {x = GamePanel.WIDTH - r; portaled = false;}
		if(y > GamePanel.HEIGHT - 10*r) {y = GamePanel.HEIGHT - 11*r;  jumping = false; contact = true; falling = false; fall = false;}
		
		dx = 0;
		dy = 0;
		
	}
	
	public void phits (MovingPlatform m, MovingPlatform b) {
		
	 	hitdetect = m.hit(); 
		dimensions = m.redim();
		colmatch = m.getCol();
		kill = m.getKill();
		stick = m.getStick();
		stickxy = m.getDir();
		dir = m.getSDir();
		safe = m.getSafe();
		touch = m.returntouch();
		
		if (touch == true) {
			
			if (kill) {
	    		x = spawnx;
	    		y = spawny;
	    		deaths++;
	    		falling = true;
			}	
			
			if ((colmatch == color1) || (safe == true)) {
				
				if (!m.returnLink()) {
				portaled = false; 
				}
						
				if (stick) {
					if (dir) {
						dx = stickxy[0];
						dy = 0;
						if (m.returnChange() && m.returnState()) {
							dy = stickxy[1];
							dx = 0;
						}
						falling= true;		
					}
					else {
						dy = stickxy[1];
						dx = 0;
						if (m.returnChange() && m.returnState()) {
							dx = stickxy[0];
							dy = 0;
						}
						falling = true;
					}
				}
				
				if (stick == false) {		
					
					if (y < hitdetect[1] + dimensions[1]/2 && x > hitdetect[0] - 2 && x < hitdetect[0] + dimensions[0] + 2) {   						
						
						if (dy >= 0 && !m.returnLink()) {
							dy = 0;
							y = hitdetect[1] - r;
							contact = true;
							falling = true;
						}
						
						if (m.returnLink() && !m.returnSide() && !b.returnSide()) {
							y = b.hit()[1] + b.redim()[1] + r + 1;
							x = b.hit()[0] + b.redim()[0]/2;
						}
						
						if (m.returnLink() && !m.returnSide() && b.returnSide()) {
							x = b.hit()[0] - r - 1;
							y = b.hit()[1] + b.redim()[1]/2;
							falling = true;
							portaled = true;
							portalstart = true;
						}
					} 
					
					if (y > hitdetect[1] + dimensions[1]/2 && x > hitdetect[0] - 2 && x < hitdetect[0] + dimensions[0] + 2) {
						
						if (!m.returnLink()) {
						
							y = hitdetect[1] + dimensions[1] + r;
							falling = true;
						
							if (dy < 0) {
								dy = 0;
							}
							
						}
						
						if (m.returnLink() && !m.returnSide() && !b.returnSide()) {
							y = b.hit()[1] - r - 1;
							x = b.hit()[0] + b.redim()[0]/2;
							falling = true;
						}
						
						if (m.returnLink() && !m.returnSide() && b.returnSide()) {
							x = b.hit()[0] + b.redim()[0] + r + 1;
							y = b.hit()[1] + b.redim()[1]/2;
							falling = true;
						}
					}
					
					if (x < hitdetect[0]) {
						
						if (dx >= 0) {
							
							if (!m.returnLink()) {
								dx = 0;
								x = hitdetect[0] - r;
							}
							
							if (m.returnLink() && m.returnSide() && b.returnSide()) {
								x = b.hit()[0] + b.redim()[0] + r;
								y = b.hit()[1] + b.redim()[1]/2;
								falling = true;
							}
							
							if (m.returnLink() && m.returnSide() && !b.returnSide()) {
								y = b.hit()[1] - r;
								x = b.hit()[0] + b.redim()[0]/2;
								falling = true;
							}
						}
					}
					
					if (x > hitdetect[0] + dimensions[0]) {
						
						if (dx < 0) {
							
							if (!m.returnLink()) {
								dx = 0;
								x = hitdetect[0] + dimensions[0] + r;
							}
							
							if (m.returnLink() && m.returnSide() && b.returnSide()) {
								x = b.hit()[0] - r;
								y = b.hit()[1] + b.redim()[1]/2;
								falling = true;
							}
							
							if (m.returnLink() && m.returnSide() && b.returnSide() == false) {
								y = b.hit()[1] + b.redim()[1] + r;
								x = b.hit()[0] + b.redim()[0]/2;
								falling = true;
							}
						}
					}
					if (m.returnMove() > 0) {
						dx = m.returnDx();
						if (left) {
							dx = -speed;
						}
						if (right) {
							dx = speed;
						}
					}
				}
			}
	    }
		else if (touch == false && falling) {
			jumpcounter = 13;
			jumping = true;
			falling = false;
		}
	}
	
	public void checkFall() {
		if (dy > 0) {
			fall = true;
		} else {
			fall = false;
		}
	}
	
	public void checkPoint() {
		
		if (x > 380 && x < 390 && y < 430 && y > 400 && !flag2.checking()) {
			spawnx = flag2.getxy()[0];
			spawny = flag2.getxy()[1] + 24;
			flag2.checked();
		}
		if (x > 275 && x < 285 && y < 320 && y > 290 && !flag3.checking()) {
			spawnx = flag3.getxy()[0];
			spawny = flag3.getxy()[1] + 24;
			flag3.checked();
		}
		if (x > 705 && x < 715 && y < 200 && y > 180 && !flag4.checking()) {
			spawnx = flag4.getxy()[0];
			spawny = flag4.getxy()[1] + 24;
			flag4.checked();
		}
		if (x > 5 && x < 15 && y < 180 && y > 150 && !flag5.checking()) {
			spawnx = flag5.getxy()[0];
			spawny = flag5.getxy()[1] + 24;
			flag5.checked();
		}
		if (x > 575 && x < 585 && y < 615 && y > 580 && !flag6.checking()) {
			spawnx = flag6.getxy()[0];
			spawny = flag6.getxy()[1] + 24;
			flag6.checked();
		}
		
		
	}
	
	public void checkv() {
		if (x > 280 && y > 220 && y < 320) {
			if (color1 == Color.gray) {
				color1 = Color.yellow;
			}
		}
	}
	
	public void checkWin() {
		if (x > 200 && x < 280 && y < 40 && y > 20) {
			win = true;
		}
	}
	
	public boolean returnWin() {
		return win;
	}
	
	public void checkTouch(MovingPlatform m) {
	 	
		hitdetect = m.hit(); 
		dimensions = m.redim();
		
		if (x >= hitdetect[0] - r && x <= hitdetect[0] + dimensions[0] + r && y >= hitdetect[1] - r && y <= hitdetect[1] + dimensions[1] + r) {
			m.touchtrue();
			fall = false;
		}
		else {
			m.touchfalse();
		}
	}
	
	public void draw(Graphics2D g) {
		
		if (color1 == Color.yellow) {
			currentcolor = "yellow";
		}
		if (color1 == Color.gray) {
			currentcolor = "gray";
		}
		if (color1 == Color.black) {
			currentcolor = "black";
		}
		if (color1 == Color.blue) {
			currentcolor = "blue";
		}

		g.setColor(Color.white);
		g.drawString("No V", 285, 245);
		g.drawString("Zone", 285, 260);
		
		flag2.draw(g);
		flag3.draw(g);
		flag4.draw(g);
		flag5.draw(g);
		flag6.draw(g);
		
		g.setColor(color1);
		g.fillOval(x - r, y - r, 2*r, 2*r);
		g.drawString("Ball color: " + currentcolor, WIDTH - 180, 678);
		
		g.setStroke(new BasicStroke(3));
		g.setColor(color1.darker());
		g.drawOval(x -r, y - r, 2*r, 2*r);
		g.setStroke(new BasicStroke(1));
		
		g.setColor(Color.black);
		g.drawString("Deaths: " + deaths, 90, 678); 
		
	}
	
	public int getdeaths() {
		return this.deaths;
	}
	
	public int returnJumps() {
		return this.jumpcount;
	}
	
	public boolean flagCheck2() {
		return flag2.checking();
	}
	
	public boolean flagCheck3() {
		return flag3.checking();
	}	
	
	public boolean flagCheck4() {
		return flag4.checking();
	} 
	
	public boolean flagCheck5() {
		return flag5.checking();
	}
	
	public boolean flagCheck6() {
		return flag6.checking();
	}
	
}
