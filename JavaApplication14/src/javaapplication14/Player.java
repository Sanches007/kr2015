import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Player {

	public static final int MAX_UP = 20;
	public static final int MAX_DOWN = 450;
	int h = 90, w = 100;
	Image img_c = new ImageIcon("res/Camel.gif").getImage();

	public Player() {

	}

	public Rectangle getRect() {
		return new Rectangle(x + 20, y + 5, w - 20, h - 20);
	}

	int s;
	int life = 0;
	int score = 0;
	int layer1 = 0;
	int layer2 = 1100;
	int v = 18;
	int j = 0;
	int x = 20;
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
		v += j;
		s += v;
		if (v != 0)
			score++;

		y += dy;
		if (y <= MAX_UP) {
			y = MAX_UP;
		}

		if (y >= MAX_DOWN) {
			y = MAX_DOWN;
		}

		if (layer2 - v <= 0) {
			layer1 = 0;
			layer2 = 1100;
		} else {
			layer1 -= v;
			layer2 -= v;
		}
	}

	public int getV() {
		return this.v;
	}

	public int setV(int j) {
		return this.j = j;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			dy = -13;

		}
		if (key == KeyEvent.VK_DOWN) {
			dy = 13;

		}

		if ((key == KeyEvent.VK_SPACE) && (v == 18)) {
			v = 0;
			JOptionPane.showMessageDialog(null, " Pause");
			v = 18;
		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if ((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_DOWN)) {
			dy = 0;
		}
	}

}
