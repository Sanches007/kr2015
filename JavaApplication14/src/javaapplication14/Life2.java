import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Life2 {
	int x;
	int y;

	Image img = new ImageIcon("res/бо-ьшое-ве-ро-во-ы-43387461.png").getImage();
	Doroga2 d;

	public Rectangle getRect() {
		return new Rectangle(x, y, 61, 80);
	}

	public Life2(int x, int y, Doroga2 d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

	public void move() {
		y = y - d.p.v;
	}
}
