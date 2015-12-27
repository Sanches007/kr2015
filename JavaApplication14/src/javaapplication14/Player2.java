import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Player2 {
	public static final int MAX_UP = 20;
	public static final int MAX_DOWN = 1050;
	int h = 90, w = 100;
	
	Image img_c = new ImageIcon("res/Camel.gif").getImage();
	
	public Player2() {
		
	}

	public Rectangle getRect() {
		return new Rectangle(x+20, y+5, w-20,h-20);
	}

	
	int s;
	int j=0;
	int v;
	int life = 0;
	int score = 0;
	int layer1 = 0;
	int layer2 = 600;

	int x = 500;
	int y = 10;
	int dx = 0;

	public int getLife() {
		return life;
	}

	public int setLife(int life) {
		return this.life = life;
	}

	public int getV() {
		return this.v;
	}
	public int setV(int j) {
		return this.v= j;
	}
	
	public int getScore() {
		return score;
	}

	public int setScore(int score) {
		return this.score = score;
	}

	public void move() {
		v=v+j;
		s += v;
		if(v!=0)
		score++;
		
		x+=dx;
		if (y <= MAX_UP){
			y = MAX_UP;}
		
		if (y >= MAX_DOWN){
			y = MAX_DOWN;}
		
		if (layer2 - v <= 0) {
			layer1 = 0 ;
			layer2 = 600;
		} else {
			layer1 -= v;
			layer2 -= v;
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			dx = -15;

		}
		if (key == KeyEvent.VK_RIGHT) {
			dx = 15;

		}
		
		if ((key == KeyEvent.VK_SPACE)&&(v==18)) {
			v=0;
			JOptionPane.showMessageDialog(null, " Pause" );
			v=18;
		}
		
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if ((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_RIGHT)) {
			dx=0;
		}
	}
}
