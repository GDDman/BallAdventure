package main;

import java.awt.Color;
import java.awt.*;

public class Flag {
	
	private int x;
	private int y;
	private boolean checked;
	private int count; 
	
	public Flag(int o, int r, boolean check) {
		x = o;
		y = r;
		checked = check;
		count = 30;
	}
	
	public void draw(Graphics2D g) {
		
		if (this.checked) {
			
			if (this.count <= 0) {
				this.count = 0;
			}
			
			int xpoints[] = new int [] {this.x,this.x + 16,this.x};
			int ypoints[] = new int[] {this.y + count,this.y + 4 + count,this.y + 8 + count};
			int npoints = 3;
			g.setColor(Color.green);
			g.fillPolygon(xpoints, ypoints, npoints);
			count--;
		}
	
	}
	
	public void checked() {
		this.checked = true;
	}
	
	public int[] getxy() {
		int[] xy = new int[] {this.x,this.y};
		return xy;
	}
	
	public boolean checking() {
		return this.checked;
	}
	
}
