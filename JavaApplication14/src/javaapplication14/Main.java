
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
public class Main{
	
	static Thread audioThread = new Thread(new Audio());
	static JFrame f;
	static Player p;
	static String login;
	DefaultListModel dlm;
	
	public static void main(String[] args) {
		Main m = new Main();
	}
		public Main(){
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

	public  void login() {
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
				menu();
				f.setVisible(true);
			} 
		});
		
	}

	public void menu() {
		f = new JFrame("Games");
		f.setSize(468, 468);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		Toolkit k = Toolkit.getDefaultToolkit();
        Image img = k.getImage("res/vintazh_33.jpg");
		f.setIconImage(img);

		JButton b1 = new JButton("New game");
		JButton b2 = new JButton("High score");
		JButton b3 = new JButton("Settings");
		JButton b4 = new JButton("About");
		JButton b5 = new JButton("Exit");

		JPanel menu = new JPanel(new GridLayout(5, 1));

		menu.add(b1);
		menu.add(b2);
		menu.add(b3);
		menu.add(b4);
		menu.add(b5);

		JLabel lab = new JLabel("Hello  " );
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
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				f.repaint();
				about();
				f.setVisible(true);
			}
		});
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
	



	public  void game() {
		Doroga d = new Doroga();
		f = new JFrame("Games");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1100, 600);
		f.add(d);
		f.setLocationRelativeTo(null);
		Toolkit k = Toolkit.getDefaultToolkit();
        Image img = k.getImage("res/vintazh_33.jpg");
		f.setIconImage(img);
	}


	public void about(){
		f = new JFrame("Games");
		f.setSize(468, 468);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		Toolkit k = Toolkit.getDefaultToolkit();
        Image img = k.getImage("res/vintazh_33.jpg");
		f.setIconImage(img);
		
		JLabel pen = new JLabel("About");
		pen.setHorizontalAlignment(SwingConstants.CENTER);
		pen.setBorder(new LineBorder(Color.BLACK, 2));
		pen.setPreferredSize(new Dimension(100, 50)); 
		pen.setFont(new Font("TimesRoman", Font.BOLD, 15));
		
		JPanel p = new JPanel(new GridLayout(4,2));
		String s1 =	"Эта игра предназначена для веселого время препровождения.\nКоротко об игре:\nУправление: кнопки вверх и вниз.\nПредметы:\n";
		String s2 = "Кактусы - препятствия которые нужно оббегать;";
		String s3 = "Ведро с водой - добавляет жизнь;";
		String s4 = "Монетка - добавляет 10 очков к общему счету.";
		
		JLabel pp1 = new JLabel();
		JLabel pp2 = new JLabel();
		JLabel pp3 = new JLabel();
		JLabel mul = new JLabel();
		
		pp1.setBorder(new LineBorder(Color.BLACK, 2));
		pp2.setBorder(new LineBorder(Color.BLACK, 2));
		pp3.setBorder(new LineBorder(Color.BLACK, 2));
		mul.setBorder(new LineBorder(Color.BLACK, 2));
		
		pp1.setHorizontalAlignment(SwingConstants.CENTER);
		pp2.setHorizontalAlignment(SwingConstants.CENTER);
		pp3.setHorizontalAlignment(SwingConstants.CENTER);
		
		ImageIcon img2 = new ImageIcon("res/post-28598-1175203499.png");
		ImageIcon img3 =new ImageIcon("res/бо-ьшое-ве-ро-во-ы-43387461.png");
		ImageIcon img4 =new ImageIcon("res/зо-отая-монетка-38290328.png");
		
		pp1.setIcon(img2);
		pp2.setIcon(img3);
		pp3.setIcon(img4);
		
		JTextPane t1 = new JTextPane();
		JTextPane t2 = new JTextPane();
		JTextPane t3 = new JTextPane();
		JTextPane t4 = new JTextPane();
		
		t1.setBorder(new LineBorder(Color.BLACK, 2));
		t2.setBorder(new LineBorder(Color.BLACK, 2));
		t3.setBorder(new LineBorder(Color.BLACK, 2));
		t4.setBorder(new LineBorder(Color.BLACK, 2));
		
		t1.setText(s1);
		t2.setText(s2);
		t3.setText(s3);
		t4.setText(s4);
		
		t1.setEditable(false);
		t2.setEditable(false);
		t3.setEditable(false);
		t4.setEditable(false);
		
		p.add(t1);
		p.add(mul);
		p.add(t2);
		p.add(pp1);
		p.add(t3);
		p.add(pp2);
		p.add(t4);
		p.add(pp3);
		
		JButton but = new JButton("Close");
		pen.setDoubleBuffered(false);
		
		f.add(pen,BorderLayout.NORTH);
		f.add(p,BorderLayout.CENTER);
		f.add(but,BorderLayout.SOUTH);
		
		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {	
				f.dispose();
				f.repaint();
				menu();
				f.setVisible(true);
			}
		});
	}
}

