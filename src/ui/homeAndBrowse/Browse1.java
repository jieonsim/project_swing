package ui.homeAndBrowse;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import ui.library.Artists;

public class Browse1 extends JFrame {
	private JButton btnHome, btnLogin, btnPop, btnRnbSoul, btnHipHop, btnRock, btnJazz, btnKpop, btnExit, btnBrowse;
	private JButton btnSearch;

	public Browse1() {
		super("Browse");
		getContentPane().setBackground(new Color(255, 255, 255));
		setSize(1280, 720);

		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(new Color(232, 232, 232), 2));
		panel1.setBackground(new Color(248, 248, 248));
		panel1.setBounds(0, 0, 270, 690);
		getContentPane().add(panel1);
		panel1.setLayout(null);

		JLabel lblMusicLogo = new JLabel(" Music");
		lblMusicLogo.setIcon(new ImageIcon(Home2.class.getResource("/Images/musicLogo3BlackVer.png")));
		lblMusicLogo.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 30));
		lblMusicLogo.setBounds(22, 10, 158, 64);
		panel1.add(lblMusicLogo);

		btnHome = new JButton("  Home");
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnHome.setIcon(new ImageIcon(Home2.class.getResource("/Images/homelogo.png")));
		btnHome.setBounds(22, 84, 223, 34);
		panel1.add(btnHome);

		btnExit = new JButton("  Exit");
		btnExit.setIcon(new ImageIcon(Home2.class.getResource("/Images/exit.png")));
		btnExit.setHorizontalAlignment(SwingConstants.LEFT);
		btnExit.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setBounds(22, 600, 223, 34);
		panel1.add(btnExit);
		
		btnBrowse = new JButton("  Browse");
		btnBrowse.setIcon(new ImageIcon(Browse1.class.getResource("/Images/browse.png")));
		btnBrowse.setHorizontalAlignment(SwingConstants.LEFT);
		btnBrowse.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnBrowse.setContentAreaFilled(false);
		btnBrowse.setBorderPainted(false);
		btnBrowse.setBounds(23, 128, 223, 34);
		panel1.add(btnBrowse);
		
		btnSearch = new JButton("  Search");
		btnSearch.setIcon(new ImageIcon(Browse1.class.getResource("/Images/search.png")));
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setBounds(23, 169, 223, 34);
		panel1.add(btnSearch);

		JPanel panel2 = new JPanel();
		panel2.setBorder(new LineBorder(new Color(232, 232, 232), 2));
		panel2.setBackground(new Color(255, 255, 255));
		panel2.setBounds(259, 0, 1017, 77);
		getContentPane().add(panel2);
		panel2.setLayout(null);

		btnLogin = new JButton("  LOGIN");
		btnLogin.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnLogin.setBorderPainted(false);
		btnLogin.setOpaque(true);
		btnLogin.setContentAreaFilled(true);
		btnLogin.setBackground(new Color(254, 85, 85));
		btnLogin.setFont(new Font("AppleSDGothicNeoB00", Font.PLAIN, 20));
		btnLogin.setIcon(new ImageIcon(Browse1.class.getResource("/Images/user1WhiteVer.png")));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBounds(836, 21, 141, 34);
		panel2.add(btnLogin);

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(255, 255, 255));
		panel3.setBounds(270, 76, 1006, 610);
		getContentPane().add(panel3);
		panel3.setLayout(null);

		JLabel lblBrowseCategories = new JLabel("Browse Categories");
		lblBrowseCategories.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		lblBrowseCategories.setBounds(22, 21, 189, 31);
		panel3.add(lblBrowseCategories);

		btnPop = new JButton(" Pop");
		btnPop.setFont(new Font("AppleSDGothicNeoH00", Font.PLAIN, 40));
		btnPop.setForeground(new Color(255, 255, 255));
		btnPop.setBackground(new Color(60, 179, 113));
		btnPop.setBorderPainted(false);
		btnPop.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnPop.setBounds(22, 77, 462, 145);
		panel3.add(btnPop);

		btnRnbSoul = new JButton("R&B/Soul");
		btnRnbSoul.setFont(new Font("AppleSDGothicNeoH00", Font.PLAIN, 40));
		btnRnbSoul.setForeground(new Color(255, 255, 255));
		btnRnbSoul.setBackground(new Color(135, 206, 235));
		btnRnbSoul.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnRnbSoul.setBorderPainted(false);
		btnRnbSoul.setBounds(509, 77, 462, 145);
		panel3.add(btnRnbSoul);

		btnHipHop = new JButton("Hip-Hop");
		btnHipHop.setForeground(new Color(255, 255, 255));
		btnHipHop.setFont(new Font("AppleSDGothicNeoH00", Font.PLAIN, 40));
		btnHipHop.setBackground(new Color(100, 149, 237));
		btnHipHop.setBorderPainted(false);
		btnHipHop.setBounds(22, 243, 462, 145);
		panel3.add(btnHipHop);

		btnRock = new JButton("Rock");
		btnRock.setForeground(new Color(255, 255, 255));
		btnRock.setFont(new Font("AppleSDGothicNeoH00", Font.PLAIN, 40));
		btnRock.setBackground(new Color(204, 204, 255));
		btnRock.setBorderPainted(false);
		btnRock.setBounds(509, 243, 462, 145);
		panel3.add(btnRock);

		btnJazz = new JButton("Jazz");
		btnJazz.setForeground(new Color(255, 255, 255));
		btnJazz.setFont(new Font("AppleSDGothicNeoH00", Font.PLAIN, 40));
		btnJazz.setBackground(new Color(221, 160, 221));
		btnJazz.setBorderPainted(false);
		btnJazz.setBounds(22, 414, 462, 145);
		panel3.add(btnJazz);

		btnKpop = new JButton("K-Pop");
		btnKpop.setFont(new Font("AppleSDGothicNeoH00", Font.PLAIN, 40));
		btnKpop.setForeground(new Color(255, 255, 255));
		btnKpop.setBackground(new Color(102, 204, 153));
		btnKpop.setBorderPainted(false);
		btnKpop.setBounds(509, 414, 462, 145);
		panel3.add(btnKpop);

		setVisible(true);

		// 홈 버튼 클릭 시 처리
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home1();
			}
		});
		
		// 브라우저 클릭
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Browse1();
			}
		});
		
		// pop 버튼
		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Pop1();
			}
		});
		
		// rnbsoul 버튼
		btnRnbSoul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RnbSoul1();
			}
		});
		
		// hiphop 버튼
		btnHipHop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new HipHop1();
			}
		});
		
		// rock 버튼
		btnRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Rock1();
			}
		});
		
		// jazz 버튼
		btnJazz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Jazz1();
			}
		});

		// 로그아웃 버튼 클릭
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login();
			}
		});
		
		// 종료 버튼 클릭
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// 서치 버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Search1();
			}
		});

	}

	public static void main(String[] args) {
		new Home1();
	}
}
