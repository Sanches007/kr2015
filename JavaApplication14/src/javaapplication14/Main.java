
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class Main {

	Thread audioThread = new Thread(new Audio());
	JFrame f;
	Player p;
	int flag = 1;
	int i=0;
	Doroga d;
	Doroga2 d2;
	Player p1 = new Player();
	Player2 p2= new Player2();
	String login;
	File file = new File("res/Score.txt");
	String[][] mass = new String[1000][2];
	String[] headers = { "Name", "Score" };

	public static void main(String[] args) {
		Main m = new Main();
	}

	public Main() {
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

	public void login() {
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
		
		
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				f.repaint();
				login=l2.getText();
				menu(login);
				f.setVisible(true);
			}
		});

	}
	

	public void menu(String s) {
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

		JLabel lab = new JLabel("Hello  "+ s);
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
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				f.repaint();
				highScore();
				f.setVisible(true);
			}

		});
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				f.repaint();
				settings();
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

	public void game() {
		f = new JFrame("Games");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1100, 600);
		if(flag==1){
			d =new Doroga();
			f.add(d);
		}else{
			d2=new Doroga2();
			f.add(d2);
		}
			
		f.setLocationRelativeTo(null);
		Toolkit k = Toolkit.getDefaultToolkit();
		Image img = k.getImage("res/vintazh_33.jpg");
		f.setIconImage(img);
	}

	public void about() {
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

		JPanel penel = new JPanel(new GridLayout(4, 2));
		String s1 = "Эта игра предназначена для веселого время препровождения.\n                       Коротко об игре:\nУправление: кнопки вверх и вниз. Пробел - пауза.";
		String s2 = "Кактусы - препятствия которые нужно оббегать;";
		String s3 = "Ведро с водой - добавляет жизнь;";
		String s4 = "Монетка - добавляет 10 очков к общему счету.";

		JLabel pp1 = new JLabel();
		JLabel pp2 = new JLabel();
		JLabel pp3 = new JLabel();
		JLabel pp4 = new JLabel();

		pp1.setBorder(new LineBorder(Color.BLACK, 2));
		pp2.setBorder(new LineBorder(Color.BLACK, 2));
		pp3.setBorder(new LineBorder(Color.BLACK, 2));
		pp4.setBorder(new LineBorder(Color.BLACK, 2));

		pp1.setHorizontalAlignment(SwingConstants.CENTER);
		pp2.setHorizontalAlignment(SwingConstants.CENTER);
		pp3.setHorizontalAlignment(SwingConstants.CENTER);
		pp4.setHorizontalAlignment(SwingConstants.CENTER);

		ImageIcon img2 = new ImageIcon("res/post-28598-1175203499.png");
		ImageIcon img3 = new ImageIcon("res/бо-ьшое-ве-ро-во-ы-43387461.png");
		ImageIcon img4 = new ImageIcon("res/зо-отая-монетка-38290328.png");

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

		penel.add(t1);
		penel.add(pp4);
		penel.add(t2);
		penel.add(pp1);
		penel.add(t3);
		penel.add(pp2);
		penel.add(t4);
		penel.add(pp3);

		JButton but = new JButton("Close");
		pen.setDoubleBuffered(false);

		f.add(pen, BorderLayout.NORTH);
		f.add(penel, BorderLayout.CENTER);
		f.add(but, BorderLayout.SOUTH);

		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				f.repaint();
				menu(login);
				f.setVisible(true);
			}
		});
	}

	public void settings() {
		f = new JFrame("Games");
		f.setSize(468, 468);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		Toolkit k = Toolkit.getDefaultToolkit();
		Image img = k.getImage("res/vintazh_33.jpg");
		f.setIconImage(img);

		JLabel pen = new JLabel("Settings");
		pen.setHorizontalAlignment(SwingConstants.CENTER);
		pen.setBorder(new LineBorder(Color.BLACK, 2));
		pen.setPreferredSize(new Dimension(100, 50));
		pen.setFont(new Font("TimesRoman", Font.BOLD, 15));

		JLabel pen2 = new JLabel("  Скорость движения");
		pen.setHorizontalAlignment(SwingConstants.CENTER);
		pen.setBorder(new LineBorder(Color.BLACK, 2));
		pen.setFont(new Font("TimesRoman", Font.BOLD, 15));

		JPanel pan2 = new JPanel(new GridLayout(2, 3));
		JTextArea pe1 = null;
		JTextArea pe2 = null;
		String i;
		if(flag==1){
			i=Integer.toString(p1.getV());
			pe1 = new JTextArea(i);
		}else{
			i=Integer.toString(p2.getV());
			pe2 = new JTextArea(i);
		}
		pen.setHorizontalAlignment(SwingConstants.CENTER);
		pen.setFont(new Font("TimesRoman", Font.BOLD, 15));
		JButton but = new JButton("Close");

		
		
		JLabel m1 = new JLabel();
		JLabel m2 = new JLabel();
		

		JButton b1 = new JButton("Больше");
		JButton b2 = new JButton("Меньше");
		
		pan2.add(m1);
		pan2.add(pen2);
		pan2.add(m2);
		pan2.add(b2);
		if(flag==1){
			pan2.add(pe1);
		}else{
			pan2.add(pe2);
		}
		pan2.add(b1);

		JPanel p3 = new JPanel(new GridLayout(2, 1));
		JPanel p4 = new JPanel(new GridLayout(1, 2));

		JRadioButton r1 = new JRadioButton("Горизонтальный бег");
		JRadioButton r2 = new JRadioButton("Вертикальный бег");

		if(flag==1){
			r1.setSelected(true);
		}else{
			r2.setSelected(true);
		}
		
		p4.add(r1);
		p4.add(r2);

		p3.add(pan2);
		p3.add(p4);
		f.add(pen, BorderLayout.NORTH);
		f.add(p3, BorderLayout.CENTER);
		f.add(but, BorderLayout.SOUTH);

		r1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (r2.isSelected())
					r2.setSelected(false);
					flag=1;
			}
		});

		r2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (r1.isSelected())
					r1.setSelected(false);
					flag=2;
			}
		});

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.repaint();
				p1.v=p1.v+1;
				p2.setV(p2.getV()+1);
			}
		});

		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.repaint();
				p1.setV(p1.getV()-1);
				p2.setV(p2.getV()-1);
				
				
			}
		});

		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				f.repaint();
				menu(login);
				f.setVisible(true);
			}
		});
	}

	public void highScore() {
		f = new JFrame("Games");
		f.setSize(468, 468);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		Toolkit k = Toolkit.getDefaultToolkit();
		Image img = k.getImage("res/vintazh_33.jpg");
		f.setIconImage(img);

		JLabel pen = new JLabel("High Score");
		pen.setHorizontalAlignment(SwingConstants.CENTER);
		pen.setBorder(new LineBorder(Color.BLACK, 2));
		pen.setPreferredSize(new Dimension(100, 50));
		pen.setFont(new Font("TimesRoman", Font.BOLD, 15));

		JButton but = new JButton("Close");

		JTable score = new JTable();
		score = new JTable(mass, headers);
		score.setColumnSelectionAllowed(false);
		score.setRowSelectionAllowed(false);
		score.setCellSelectionEnabled(true);
		JScrollPane scrollBar6 = new JScrollPane(score);
		scrollBar6.setViewportView(score);
		

		f.add(pen, BorderLayout.NORTH);
		f.add(score, BorderLayout.CENTER);
		f.add(but, BorderLayout.SOUTH);

		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				f.repaint();
				menu(login);
				f.setVisible(true);
			}
		});
	}

}
