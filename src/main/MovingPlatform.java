package main;

import java.awt.*;

public class MovingPlatform extends Player {

	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int length;
	private int height;
	private int dx;
	private int dy;
	private int counter;
	private int[] location;
	private int moving;
	private int[] dims;
	private int multiplier;
	private Color color;
	private boolean kill; 
	private boolean stick;
	private boolean dir;
	private int[] dirs;
	private boolean safe;
	private boolean touching;
	private boolean link;
	private boolean side;
	private boolean changedir;
	private boolean dirc;
	private int newmove;
	private int counter2;
	private boolean newdir;
	private int offset;
	private boolean tempoffset;
	
	public MovingPlatform (int x, int y, int l, int h, int move, int mult, Color col, boolean kill, boolean stick, 
						   boolean dir, boolean safe, boolean link, boolean side, boolean changedir, boolean dirc, int newmove, int oset) {
		
		this.x = x;
		this.y = y;
		this.length = l;
		this.height = h;
		this.moving = move;
		this.dx = 0;
		this.dy = 0;
		this.counter = 0;
		this.counter2 = 0;
		this.multiplier = mult;
		this.color = col; 
		this.kill = kill;
		this.stick = stick;
		this.dir = dir;
		this.safe = safe;
		this.touching = false;
		this.link = link;
		this.side = side;
		this.changedir = changedir;
		this.dirc = dirc;
		this.newmove = newmove;
		this.newdir = false;
		this.offset = oset;
		this.tempoffset = true;
		
	}

	// functions 
	public void update () {
		this.platdir(dir);
	}
	
	public void draw (Graphics2D g) {
		
		if (this.link && this.side) {
		g.setColor(Color.orange);
		g.fillRect(this.x - 3, this.y, 3, this.height);
		g.fillRect(this.x + this.length, this.y,  3,  this.height);
		}
		if (this.link && !this.side) {
		g.setColor(Color.orange);
		g.fillRect(this.x, this.y - 3, this.length, 3);
		g.fillRect(this.x, this.y + this.height,  this.length, 3);
		}
		
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.length, this.height);
		
		g.setColor(Color.white);
		g.fillRect(490, 500, 40, 3);
		g.fillRect(727, 0, 3, 40);
		g.fillRect(710, 570, 10, 60);
		g.setColor(Color.red);
		g.fillRect(440, 417, 40, 3);
		g.fillRect(430, 370, 3, 40);
		g.fillRect(740, 160, 13, 40);
	}
	
	public void platdir(boolean dir) {
		
		if (!this.changedir) {
			
			this.counter += this.multiplier;
			this.counter2 += this.multiplier;
			
			if (this.offset > 0 && tempoffset) {
				this.counter = this.moving;
				tempoffset = false;
			}
			
			if (dir) {
				
				if (this.moving < 2) {
					this.counter = 0;
				}
				else if (this.counter < this.moving) {
					this.dx = this.multiplier;
				}
				else if (this.counter >= this.moving && this.counter < (this.moving*2) - (2*this.multiplier)) {
					this.dx = -this.multiplier;
				}
				else {
					this.counter = 0; 
				}
				
				this.x += this.dx;
			}
		
			if (!dir) {
			
				if (this.moving < 2) {
					this.counter = 0;
				}
				else if (this.counter < this.moving) {
					this.dy = this.multiplier;
				}
				else if (this.counter >= this.moving && this.counter < (this.moving*2) - (2*this.multiplier)) {
					this.dy = -this.multiplier;
				}
				else {
					this.counter = 0; 
				}
		
				this.y += this.dy;
			}
		}
		if (this.changedir) {
			
			if (dir) {
				
				if (this.counter == 0 && this.counter2 == 0) {
					this.counter = multiplier;
					this.counter2 = multiplier;
					this.newdir = false;
				}
				else if (this.counter < this.moving && this.counter > 0) {
					this.dx = this.multiplier;
					this.counter += multiplier;
					this.newdir = false;
				}
				else if (this.counter2 < this.newmove && this.counter >= this.moving) {
					if (this.dirc) {
						this.dy = -this.multiplier;
					}
					if (!this.dirc) {
						this.dy = this.multiplier;
					}
					this.counter2 += this.multiplier;
					this.dx = 0;
					this.newdir = true;
				}
				else if (this.counter2 >= this.newmove && this.counter2 < (this.newmove*2) - (this.multiplier) && this.counter >= moving) {
					if (!this.dirc) {
						this.dy = -this.multiplier;;
					}
					if (this.dirc) {
						this.dy = this.multiplier;
					}
					this.counter2 += this.multiplier;
					this.dx = 0;
					this.newdir = true;
				}
				else if (this.counter >= this.moving && this.counter < (this.moving*2) - (3*this.multiplier) && this.counter2 >= (this.newmove*2) - (this.multiplier)) {
					this.dx = -this.multiplier;
					this.dy = 0;
					this.counter += this.multiplier;
					this.newdir = false;
				}
				else {
					this.counter = 0;
					this.counter2 = 0;
				}
				
				this.x += this.dx;
				this.y += this.dy;
			}
		
			if (!dir) {
				
				if (this.counter == 0 && this.counter2 == 0) {
					this.counter = multiplier;
					this.counter2 = multiplier;
					this.newdir = false;
				}
				else if (this.counter < this.moving && this.counter > 0) {
					this.dy = this.multiplier;
					this.counter += multiplier;
					this.newdir = false;
				}
				else if (this.counter2 < this.newmove && this.counter >= this.moving) {
					if (this.dirc) {
						this.dx = -this.multiplier;
						this.dy = 0;
					}
					if (!this.dirc) {
						this.dx = this.multiplier;
						this.dy = 0;
					}
					this.counter2 += this.multiplier;
					this.newdir = true;
				}
				else if (this.counter2 >= this.newmove && this.counter2 < (this.newmove*2) - (this.multiplier) && this.counter >= moving) {
					if (!this.dirc) {
						this.dx = -this.multiplier;
						this.dy = 0;
					}
					if (this.dirc) {
						this.dx = this.multiplier;
						this.dy = 0;
					}
					this.counter2 += this.multiplier;
					this.newdir = true;
				}
				else if (this.counter >= this.moving && this.counter < (this.moving*2) - (3*this.multiplier) && this.counter2 >= (this.newmove*2) - (this.multiplier)) {
					this.dy = -this.multiplier;
					this.dx = 0;
					this.counter += this.multiplier;
					this.newdir = false;
				}
				else {
					this.counter = 0;
					this.counter2 = 0;
				}
				
				this.x += this.dx;
				this.y += this.dy;
			}
		}
	}		
	
	// getters 
	public int[] coords() {
		location = new int[] {this.x,this.y};
		return location;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int[] dimensions() {
		dims = new int[] {this.length, this.height};
		return dims;	
	}
	
	public int getLength() {
		return this.length;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public Color getCol() {		
		return this.color; 	
	}
	
	public boolean getKill() {
		return this.kill;
	}
	
	public boolean getStick() {
		return this.stick;
	}
	
	public int[] getDir() {
		dirs = new int[] {this.dx, this.dy};
		return dirs;
	}
	
	public boolean getSDir() {
		return this.dir;
	}
	
	public boolean getSafe() {
		return this.safe;
	}
	
	public void touchfalse() {
		this.touching = false;
	}
	
	public void touchtrue() {
		this.touching = true;
	}
	
	public boolean returntouch() {
		return this.touching;
	}
	
	public boolean returnLink() {
		return this.link;
	}
	
	public boolean returnSide() {
		return this.side;
	}
	
	public boolean returnChange() {
		return this.changedir;
	}
	
	public boolean returnState() {
	return this.newdir;
	}

	public int returnMove() {
		return this.moving;
	}

	public int returnDx() {
		return this.dx;
	}
}

