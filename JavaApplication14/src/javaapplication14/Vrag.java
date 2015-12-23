import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Vrag {

	int x;
	int y;

	Image img = new ImageIcon("res/post-28598-1175203499.png").getImage();
	Doroga d;

	public Rectangle getRect() {
		return new Rectangle(x, y, 20, 110);
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
