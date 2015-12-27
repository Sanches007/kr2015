import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Doroga extends JPanel implements ActionListener, Runnable {
	Timer mainTimer = new Timer(30, this);
	File file = new File("Score.txt");
	Vector<Integer> vec = new Vector<Integer>();
	Image img = new ImageIcon("res/101443739.jpg").getImage();
	Main main;
	Player p = new Player();

	Thread enFactory = new Thread(this);
	Thread audioThread = new Thread(new Audio());
	Thread audioThread2 = new Thread(new Audio2());

	List<Vrag> vrag = new ArrayList<Vrag>();
	List<Money> money = new ArrayList<Money>();
	List<Life> life = new ArrayList<Life>();

	public Doroga() {
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
		g.drawImage(img, p.layer1, 0, null);
		g.drawImage(img, p.layer2, 0, null);
		g.drawImage(p.img_c, p.x, p.y, null);

		g.setColor(Color.WHITE);
		Font font = new Font("Arial", Font.ROMAN_BASELINE, 20);
		g.setFont(font);

		g.drawString("Пройденное расстояние " + p.getScore() / 20, 20, 20);
		g.drawString("Жизнь -  " + p.getLife(), 300, 20);
		Iterator<Vrag> i = vrag.iterator();
		while (i.hasNext()) {
			Vrag e = i.next();
			if (e.x >= 2400 || e.x <= -2400) {
				i.remove();
			} else {
				e.move();
				g.drawImage(e.img, e.x, e.y, null);
			}
		}
		Iterator<Money> j = money.iterator();
		while (j.hasNext()) {
			Money e = j.next();
			if (e.x >= 2400 || e.x <= -2400) {
				j.remove();
			} else {
				e.move();
				g.drawImage(e.img, e.x, e.y, null);
			}
		}
		Iterator<Life> y = life.iterator();
		while (y.hasNext()) {
			Life e = y.next();
			if (e.x >= 2400 || e.x <= -2400) {
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
		Iterator<Vrag> i = vrag.iterator();
		while (i.hasNext()) {
			Vrag e = i.next();
			if (p.getRect().intersects(e.getRect())) {
				if (getlife() == true) {
					audioThread2.start();
					JOptionPane.showMessageDialog(null, "Конец игры !\nТвой счет = " + p.getScore() / 20);
					vec.add(p.getScore() / 10);
					main.f.dispose();	
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
		Iterator<Money> i = money.iterator();
		while (i.hasNext()) {
			Money e = i.next();
			if (p.getRect().intersects(e.getRect())) {
				p.setScore(p.score + 200);
				i.remove();
			}

		}

	}

	private void testCollisionWithEnemies3() {
		Iterator<Life> i = life.iterator();
		while (i.hasNext()) {
			Life e = i.next();
			if (p.getRect().intersects(e.getRect())) {
				p.life++;
				p.life = p.life % 10;
				p.setLife(p.life);
				i.remove();
			}

		}

	}

	@Override
	public void run() {
			Random rand = new Random();
			int i = 0;
			while(true){
			try {
				i = rand.nextInt(100)+10;
				if (i < 85) {
					vrag.add(new Vrag(1100, rand.nextInt(400), this));
					Thread.sleep(rand.nextInt(500) + 100);
				} else if ((i >85) && (i < 105)) {
					money.add(new Money(1200, rand.nextInt(400), this));
					Thread.sleep(rand.nextInt(500) + 300);
				} else if (i > 105) {
					life.add(new Life(1300, rand.nextInt(400), this));
					Thread.sleep(rand.nextInt(500) + 1000);
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
	}

	
	public void readScore() throws FileNotFoundException {
		File file = new File("Score.txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNext()) {
			vec.add(reader.nextInt());
		}

	}

	public void writeScore() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i <= vec.size(); i++) {
			writer.print(vec.get(i) + " ");
			writer.flush();
		}
		writer.close();
	}
}
