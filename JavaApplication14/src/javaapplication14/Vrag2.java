import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public class Vrag {

	int x;
	int y;
	Doroga d;
	Image img = new ImageIcon("res/post-28598-1175203499.png").getImage();

	public Rectangle getRect() {
		return new Rectangle(x+5, y+5, 30, 120);
	}


	
	public Vrag(int x, int y, Doroga d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

	public void move() {
		x = x - d.p.v;
	}

	
}
