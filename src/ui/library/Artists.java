package ui.library;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import serviceAndDao.*;
import ui.homeAndBrowse.*;

public class Artists extends JFrame {
	private JButton btnHome, btnLogout, btnArtists, btnAlbums, btnSongs, btnAllPlaylists, btnFavoriteSongs,
			btnNewPlaylist, btnExit, btnBrowse;
	private JTextField txtSearch;
	private JLabel lblPlaylists;
	private JScrollPane scrollPane1;
	private JTable tableArtistsList;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	public Artists() {
		super("Artists");
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
		
		btnBrowse = new JButton("  Browse");
		btnBrowse.setIcon(new ImageIcon(Home2.class.getResource("/Images/search.png")));
		btnBrowse.setHorizontalAlignment(SwingConstants.LEFT);
		btnBrowse.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnBrowse.setContentAreaFilled(false);
		btnBrowse.setBorderPainted(false);
		btnBrowse.setBounds(23, 180, 223, 34);
		panel1.add(btnBrowse);

		JLabel lblLibrary = new JLabel("Library");
		lblLibrary.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 15));
		lblLibrary.setBounds(22, 224, 93, 26);
		panel1.add(lblLibrary);

		btnArtists = new JButton("  Artists");
		btnArtists.setIcon(new ImageIcon(Home2.class.getResource("/Images/artists.png")));
		btnArtists.setHorizontalAlignment(SwingConstants.LEFT);
		btnArtists.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnArtists.setContentAreaFilled(false);
		btnArtists.setBorderPainted(false);
		btnArtists.setBounds(22, 260, 223, 34);
		panel1.add(btnArtists);

		btnAlbums = new JButton("  Alubms");
		btnAlbums.setIcon(new ImageIcon(Home2.class.getResource("/Images/albums.png")));
		btnAlbums.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlbums.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnAlbums.setContentAreaFilled(false);
		btnAlbums.setBorderPainted(false);
		btnAlbums.setBounds(22, 304, 223, 34);
		panel1.add(btnAlbums);

		btnSongs = new JButton("  Songs");
		btnSongs.setIcon(new ImageIcon(Home2.class.getResource("/Images/songs.png")));
		btnSongs.setHorizontalAlignment(SwingConstants.LEFT);
		btnSongs.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnSongs.setContentAreaFilled(false);
		btnSongs.setBorderPainted(false);
		btnSongs.setBounds(22, 348, 223, 34);
		panel1.add(btnSongs);

		lblPlaylists = new JLabel("Playlists");
		lblPlaylists.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 15));
		lblPlaylists.setBounds(22, 409, 93, 26);
		panel1.add(lblPlaylists);

		btnAllPlaylists = new JButton("  All Playlists");
		btnAllPlaylists.setIcon(new ImageIcon(Home2.class.getResource("/Images/allPlaylists.png")));
		btnAllPlaylists.setHorizontalAlignment(SwingConstants.LEFT);
		btnAllPlaylists.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnAllPlaylists.setContentAreaFilled(false);
		btnAllPlaylists.setBorderPainted(false);
		btnAllPlaylists.setBounds(22, 445, 223, 34);
		panel1.add(btnAllPlaylists);

		btnFavoriteSongs = new JButton("  Favorite Songs");
		btnFavoriteSongs.setIcon(new ImageIcon(Home2.class.getResource("/Images/favoriteSongsHeartVer.png")));
		btnFavoriteSongs.setHorizontalAlignment(SwingConstants.LEFT);
		btnFavoriteSongs.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnFavoriteSongs.setContentAreaFilled(false);
		btnFavoriteSongs.setBorderPainted(false);
		btnFavoriteSongs.setBounds(22, 489, 223, 34);
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
		btnNewPlaylist.setBounds(30, 534, 158, 34);
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

		JLabel lblArtists = new JLabel("Aritsts");
		lblArtists.setBounds(30, 10, 225, 53);
		panel2.add(lblArtists);
		lblArtists.setFont(new Font("AppleSDGothicNeoB00", Font.PLAIN, 45));

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(255, 255, 255));
		panel3.setBounds(270, 76, 1006, 610);
		getContentPane().add(panel3);
		panel3.setLayout(null);
		
		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(36, 38, 262, 514);
		panel3.add(scrollPane1);
		
		tableArtistsList = new JTable();
		scrollPane1.setViewportView(tableArtistsList);
		
		lblNewLabel = new JLabel("아티스트사진");
		lblNewLabel.setBounds(342, 39, 167, 99);
		panel3.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(603, 39, 167, 99);
		panel3.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(356, 205, 167, 99);
		panel3.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(631, 205, 167, 99);
		panel3.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(366, 382, 167, 99);
		panel3.add(lblNewLabel_4);

		setVisible(true);
		
		// 홈 버튼 클릭 시 처리
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home2();
			}
		});
		
		// 텍스트 필드 내용 입력 후 엔터 키 처리
		txtSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Search2();
			}
		});
		
		// 아티스트 버튼 클릭
		btnArtists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Artists();
			}
		});
		
		// exit 버튼 클릭
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
