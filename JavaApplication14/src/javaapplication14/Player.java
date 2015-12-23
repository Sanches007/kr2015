import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {

	public static final int MAX_V = 70;
	public static final int MAX_TOP = 10;
	public static final int MAX_BOTTOM = 400;
	int h = 70, w = 70;
	Image img_c = new ImageIcon("res/Camel.gif").getImage();


	public Player() {

	}

	public Rectangle getRect() {
		return new Rectangle(x, y, h, w);
	}

	int v = 15;
	int dv = 0;
	int s;
	int score = 0;
	int life = 0;

	int layer1 = 0;
	int layer2 = 1100;

	int x = 50;
	int y = 200;
	int dy = 0;

	public int getLife() {
		return life;
	}

	public int setLife(int life) {
		return this.life = life;
	}

	public int getScore() {
		return score;
	}

	public int setScore(int score) {
		return this.score = score;
	}

	public void move() {

		s += v;
		v += dv;
		if (v <= 0)
			v = 0;
		if (v >= MAX_V)
			v = MAX_V;
		y -= dy;
		score++;

		if (y <= MAX_TOP)
			y = MAX_TOP;
		if (y >= MAX_BOTTOM)
			y = MAX_BOTTOM;
		if (layer2 - v <= 0) {
			layer1 = 0;
			layer2 = 1100;
		} else {
			layer1 -= v;
			layer2 -= v;
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			dy = 13;
			h = 101;
			w = 109;
		}
		if (key == KeyEvent.VK_DOWN) {
			dy = -13;
			h = 101;
			w = 109;
		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if ((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_DOWN)) {
			dy = 0;

		}
	}

}
