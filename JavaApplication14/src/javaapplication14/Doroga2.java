import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Doroga2 extends JPanel implements ActionListener, Runnable {
	Timer mainTimer = new Timer(30, this);
	Image img = new ImageIcon("res/101443739.jpg").getImage();
	Main main;
	Player2 p = new Player2();

	Thread enFactory = new Thread(this);
	Thread audioThread = new Thread(new Audio());
	Thread audioThread2 = new Thread(new Audio2());

	List<Vrag2> vrag2 = new ArrayList<Vrag2>();
	List<Money2> money2 = new ArrayList<Money2>();
	List<Life2> life2 = new ArrayList<Life2>();

	public Doroga2() {
		mainTimer.start();
		enFactory.start();
		addKeyListener(new MyKeyAdapter());
		setFocusable(true);

	}

	private class MyKeyAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			p.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {
			p.keyReleased(e);
		}

	}

	public void paint(Graphics g) {
		g = (Graphics2D) g;
		g.drawImage(img, 0, p.layer1, null);
		g.drawImage(img, 0, p.layer2, null);
		g.drawImage(p.img_c, p.x, p.y, null);

		g.setColor(Color.WHITE);
		Font font = new Font("Arial", Font.ROMAN_BASELINE, 20);
		g.setFont(font);

		g.drawString("Пройденное расстояние " + p.getScore() / 20, 20, 20);
		g.drawString("Жизнь -  " + p.getLife(), 300, 20);
		Iterator<Vrag2> i = vrag2.iterator();
		while (i.hasNext()) {
			Vrag2 e = i.next();
			if (e.y >= 1200 || e.y <= -1200) {
				i.remove();
			} else {
				e.move();
				g.drawImage(e.img, e.x, e.y, null);
			}
		}
		Iterator<Money2> j = money2.iterator();
		while (j.hasNext()) {
			Money2 e = j.next();
			if (e.y >= 1200 || e.y <= -1200) {
				j.remove();
			} else {
				e.move();
				g.drawImage(e.img, e.x, e.y, null);
			}
		}
		Iterator<Life2> y = life2.iterator();
		while (y.hasNext()) {
			Life2 e = y.next();
			if (e.y >= 1200 || e.y <= -1200) {
				y.remove();
			} else {
				e.move();
				g.drawImage(e.img, e.x, e.y, null);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		p.move();
		repaint();
		testCollisionWithEnemies();
		testCollisionWithEnemies2();
		testCollisionWithEnemies3();

	}

	private void testCollisionWithEnemies() {
		Iterator<Vrag2> i = vrag2.iterator();
		while (i.hasNext()) {
			Vrag2 e = i.next();
			if (p.getRect().intersects(e.getRect())) {
				if (getlife() == true) {
					audioThread.stop();
					audioThread2.start();
					JOptionPane.showMessageDialog(null, "Конец игры !\nТвой счет = " + p.getScore() / 20);
					System.exit(0);
				} else {
					i.remove();
				}
			}
		}

	}

	public boolean getlife() {
		if (p.getLife() > 0) {
			p.setLife(p.life - 1);
			return false;
		} else {
			return true;
		}

	}

	private void testCollisionWithEnemies2() {
		Iterator<Money2> i = money2.iterator();
		while (i.hasNext()) {
			Money2 e = i.next();
			if (p.getRect().intersects(e.getRect())) {
				p.setScore(p.score + 200);
				i.remove();
			}

		}

	}

	private void testCollisionWithEnemies3() {
		Iterator<Life2> i = life2.iterator();
		while (i.hasNext()) {
			Life2 e = i.next();
			if (p.getRect().intersects(e.getRect())) {
				p.life++;
				p.setLife(p.life);
				i.remove();
			}

		}

	}

	@Override
	public void run() {
		Random rand = new Random();
		int i = 0;
		while (true) {
			try {
				i = rand.nextInt(100) + 10;
				if (i < 85) {
					vrag2.add(new Vrag2(rand.nextInt(1000), 600, this));
					Thread.sleep(rand.nextInt(300) + 100);
				} else if ((i > 85) && (i < 105)) {
					money2.add(new Money2(rand.nextInt(1100), 700, this));
					Thread.sleep(rand.nextInt(300) + 300);
				} else if (i > 105) {
					life2.add(new Life2(rand.nextInt(1200), 800, this));
					Thread.sleep(rand.nextInt(300) + 1000);
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
