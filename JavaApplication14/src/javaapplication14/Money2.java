import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Money2 {
	int x;
	int y;

	Image img = new ImageIcon("res/зо-отая-монетка-38290328.png").getImage();
	Doroga2 d;

	public Rectangle getRect() {
		return new Rectangle(x, y, 75, 77);
	}

	public Money2(int x, int y, Doroga2 d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

	public void move() {
		y = y - d.p.v;
	}
}
