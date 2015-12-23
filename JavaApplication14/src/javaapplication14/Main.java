
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
public class Main{
	static Doroga d = new Doroga();
	static Thread audioThread = new Thread(new Audio());
	static JFrame f;
	static Player p;
	static String login;

	public static void main(String[] args) {
		f = new JFrame("Games");
		f.setSize(200, 200);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		login();
		f.setVisible(true);
		Toolkit k = Toolkit.getDefaultToolkit();
        Image img = k.getImage("res/vintazh_33.jpg");
		f.setIconImage(img);
	}

	public static void login() {
		JPanel g = new JPanel(new GridLayout(3, 1));
		JLabel l = new JLabel("Enter your nickname =)");
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setFont(new Font("TimesRoman", Font.BOLD, 15));
		JTextArea l2 = new JTextArea();
		l2.setOpaque(true);
		l2.setEditable(true);
		l2.setBorder(new LineBorder(Color.BLACK, 2));
		JButton b = new JButton("Apply");
		b.setOpaque(true);
		g.add(l);
		g.add(l2);
		g.add(b);
		g.setForeground(Color.BLACK);
		g.setOpaque(false);
		g.setVisible(true);
		f.add(g);
		
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				f.repaint();
				menu(l2.getText());
				f.setVisible(true);
			} 
		});
		
	}

	public static void menu(String s) {
		f = new JFrame("Games");
		f.setSize(468, 468);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		Toolkit k = Toolkit.getDefaultToolkit();
        Image img = k.getImage("res/vintazh_33.jpg");
		f.setIconImage(img);
	//	d.readScore();

		JButton b1 = new JButton("Играть");
		JButton b2 = new JButton("Таблица рекордов");
		JButton b3 = new JButton("Выход");

		JPanel menu = new JPanel(new GridLayout(3, 1));

		menu.add(b1);
		menu.add(b2);
		menu.add(b3);

		JLabel lab = new JLabel("Hello  " +s );
		lab.setHorizontalAlignment(SwingConstants.CENTER);
		lab.setFont(new Font("TimesRoman", Font.BOLD, 15));
		JLabel im = new JLabel();
		im.setIcon(new ImageIcon("res/2.jpg"));
		im.setVisible(true);

		f.add(lab, BorderLayout.NORTH);
		f.add(im, BorderLayout.CENTER);
		f.add(menu, BorderLayout.SOUTH);

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				f.repaint();
				game();
				audioThread.start();
				f.setVisible(true);
			}

		});
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
	



	public static void game() {
		f = new JFrame("Games");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1100, 600);
		f.add(d);
		f.setLocationRelativeTo(null);
		Toolkit k = Toolkit.getDefaultToolkit();
        Image img = k.getImage("res/vintazh_33.jpg");
		f.setIconImage(img);
	}


}

