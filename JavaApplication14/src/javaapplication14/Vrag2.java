import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Vrag2 {
	int x;
	int y;
	Doroga2 d;
	Image img = new ImageIcon("res/post-28598-1175203499.png").getImage();

	public Rectangle getRect() {
		return new Rectangle(x+5, y+3, 30, 120);
	}


	
	public Vrag2(int x, int y, Doroga2 d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

	public void move() {
		y = y - d.p.v;
	}
}
