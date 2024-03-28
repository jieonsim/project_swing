package ui.user;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import ui.library.Artists;
import ui.user.genres.Pop;

public class Home2 extends JFrame {
	private JTextField txtSearch;
	private JButton btnHome, btnLogout, btnPop, btnRnbSoul, btnHipHop, btnRock, btnJazz, btnKpop, btnArtists, btnAlbums,
			btnSongs, btnAllPlaylists, btnFavoriteSongs, btnNewPlaylist, btnExit;
	private JLabel lblPlaylists;

	public Home2() {
		super("Swing Music");
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

		txtSearch = new JTextField();
		txtSearch.setBorder(new LineBorder(new Color(232, 232, 232), 2, true));
		txtSearch.setBounds(23, 84, 223, 34);
		panel1.add(txtSearch);
		txtSearch.setColumns(10);

		btnHome = new JButton("  Home");
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnHome.setIcon(new ImageIcon(Home2.class.getResource("/Images/homelogo.png")));
		btnHome.setBounds(22, 136, 223, 34);
		panel1.add(btnHome);

		JLabel lblLibrary = new JLabel("Library");
		lblLibrary.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 15));
		lblLibrary.setBounds(22, 188, 93, 26);
		panel1.add(lblLibrary);

		btnArtists = new JButton("  Artists");
		btnArtists.setIcon(new ImageIcon(Home2.class.getResource("/Images/artists.png")));
		btnArtists.setHorizontalAlignment(SwingConstants.LEFT);
		btnArtists.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnArtists.setContentAreaFilled(false);
		btnArtists.setBorderPainted(false);
		btnArtists.setBounds(22, 224, 223, 34);
		panel1.add(btnArtists);

		btnAlbums = new JButton("  Alubms");
		btnAlbums.setIcon(new ImageIcon(Home2.class.getResource("/Images/albums.png")));
		btnAlbums.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlbums.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnAlbums.setContentAreaFilled(false);
		btnAlbums.setBorderPainted(false);
		btnAlbums.setBounds(22, 268, 223, 34);
		panel1.add(btnAlbums);

		btnSongs = new JButton("  Songs");
		btnSongs.setIcon(new ImageIcon(Home2.class.getResource("/Images/songs.png")));
		btnSongs.setHorizontalAlignment(SwingConstants.LEFT);
		btnSongs.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnSongs.setContentAreaFilled(false);
		btnSongs.setBorderPainted(false);
		btnSongs.setBounds(22, 312, 223, 34);
		panel1.add(btnSongs);

		lblPlaylists = new JLabel("Playlists");
		lblPlaylists.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 15));
		lblPlaylists.setBounds(22, 373, 93, 26);
		panel1.add(lblPlaylists);

		btnAllPlaylists = new JButton("  All Playlists");
		btnAllPlaylists.setIcon(new ImageIcon(Home2.class.getResource("/Images/allPlaylists.png")));
		btnAllPlaylists.setHorizontalAlignment(SwingConstants.LEFT);
		btnAllPlaylists.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnAllPlaylists.setContentAreaFilled(false);
		btnAllPlaylists.setBorderPainted(false);
		btnAllPlaylists.setBounds(22, 409, 223, 34);
		panel1.add(btnAllPlaylists);

		btnFavoriteSongs = new JButton("  Favorite Songs");
		btnFavoriteSongs.setIcon(new ImageIcon(Home2.class.getResource("/Images/favoriteSongsHeartVer.png")));
		btnFavoriteSongs.setHorizontalAlignment(SwingConstants.LEFT);
		btnFavoriteSongs.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnFavoriteSongs.setContentAreaFilled(false);
		btnFavoriteSongs.setBorderPainted(false);
		btnFavoriteSongs.setBounds(22, 453, 223, 34);
		panel1.add(btnFavoriteSongs);

		btnNewPlaylist = new JButton("  New playlist");
		btnNewPlaylist.setBorderPainted(false);
		btnNewPlaylist.setIcon(new ImageIcon(Home2.class.getResource("/Images/newPlaylist.png")));
		btnNewPlaylist.setOpaque(false);
		btnNewPlaylist.setForeground(Color.BLACK);
		btnNewPlaylist.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnNewPlaylist.setContentAreaFilled(false);
		btnNewPlaylist.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewPlaylist.setBackground(Color.WHITE);
		btnNewPlaylist.setBounds(30, 498, 158, 34);
		panel1.add(btnNewPlaylist);

		btnExit = new JButton("  Exit");
		btnExit.setIcon(new ImageIcon(Home2.class.getResource("/Images/exit.png")));
		btnExit.setHorizontalAlignment(SwingConstants.LEFT);
		btnExit.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setBounds(22, 600, 223, 34);
		panel1.add(btnExit);

		JPanel panel2 = new JPanel();
		panel2.setBorder(new LineBorder(new Color(232, 232, 232), 2));
		panel2.setBackground(new Color(255, 255, 255));
		panel2.setBounds(259, 0, 1017, 77);
		getContentPane().add(panel2);
		panel2.setLayout(null);

		btnLogout = new JButton("  LOGOUT");
		btnLogout.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnLogout.setBorderPainted(false);
		btnLogout.setOpaque(true);
		btnLogout.setContentAreaFilled(true);
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("AppleSDGothicNeoB00", Font.PLAIN, 20));
		btnLogout.setIcon(new ImageIcon(Home2.class.getResource("/Images/user2.png")));
		btnLogout.setForeground(new Color(0, 0, 0));
		btnLogout.setBounds(836, 21, 141, 34);
		panel2.add(btnLogout);

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
		btnPop.setFont(new Font("AppleSDGothicNeoEB00", Font.PLAIN, 40));
		btnPop.setForeground(new Color(255, 255, 255));
		btnPop.setBackground(new Color(60, 179, 113));
		btnPop.setBorderPainted(false);
		btnPop.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnPop.setBounds(22, 77, 462, 145);
		panel3.add(btnPop);

		btnRnbSoul = new JButton("R&B/Soul");
		btnRnbSoul.setFont(new Font("AppleSDGothicNeoEB00", Font.PLAIN, 40));
		btnRnbSoul.setForeground(new Color(255, 255, 255));
		btnRnbSoul.setBackground(new Color(135, 206, 235));
		btnRnbSoul.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnRnbSoul.setBorderPainted(false);
		btnRnbSoul.setBounds(509, 77, 462, 145);
		panel3.add(btnRnbSoul);

		btnHipHop = new JButton("Hip-Hop");
		btnHipHop.setForeground(new Color(255, 255, 255));
		btnHipHop.setFont(new Font("AppleSDGothicNeoEB00", Font.PLAIN, 40));
		btnHipHop.setBackground(new Color(100, 149, 237));
		btnHipHop.setBorderPainted(false);
		btnHipHop.setBounds(22, 243, 462, 145);
		panel3.add(btnHipHop);

		btnRock = new JButton("Rock");
		btnRock.setForeground(new Color(255, 255, 255));
		btnRock.setFont(new Font("AppleSDGothicNeoEB00", Font.PLAIN, 40));
		btnRock.setBackground(new Color(204, 204, 255));
		btnRock.setBorderPainted(false);
		btnRock.setBounds(509, 243, 462, 145);
		panel3.add(btnRock);

		btnJazz = new JButton("Jazz");
		btnJazz.setForeground(new Color(255, 255, 255));
		btnJazz.setFont(new Font("AppleSDGothicNeoEB00", Font.PLAIN, 40));
		btnJazz.setBackground(new Color(221, 160, 221));
		btnJazz.setBorderPainted(false);
		btnJazz.setBounds(22, 414, 462, 145);
		panel3.add(btnJazz);

		btnKpop = new JButton("K-Pop");
		btnKpop.setFont(new Font("AppleSDGothicNeoEB00", Font.BOLD, 40));
		btnKpop.setForeground(new Color(255, 255, 255));
		btnKpop.setBackground(new Color(102, 204, 153));
		btnKpop.setBorderPainted(false);
		btnKpop.setBounds(509, 414, 462, 145);
		panel3.add(btnKpop);

		setVisible(true);

		// 로그인 상태에서 홈 버튼 클릭 시 처리
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home2();
			}
		});

		// 로그인 상태에서 서치 텍스트필드에 내용 입력 후 엔터 시 처리
		txtSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Search2();
			}
		});
		
		// 로그인 상태에서 장르 pop 버튼
		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Pop();
			}
		});


		// 로그인 상태에서 아티스트 버튼 클릭
		btnArtists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Artists();
			}
		});

		// 로그인 상태에서 로그아웃 버튼 클릭
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home1();
			}
		});
		
		// 로그인 상태에서 종료 버튼 클릭
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	public static void main(String[] args) {
		new Home2();
	}
}
