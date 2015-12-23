import java.awt.Image;
import java.awt.Rectangle;


import javax.swing.ImageIcon;

public class Money {
	int x;
	int y;

	Image img = new ImageIcon("res/зо-отая-монетка-38290328.png").getImage();
	Doroga d;

	public Rectangle getRect() {
		return new Rectangle(x, y, 70, 70);
	}

	public Money(int x, int y, Doroga d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

	public void move() {
		x = x - d.p.v;
	}

}
