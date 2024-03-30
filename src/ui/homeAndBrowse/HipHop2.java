package ui.homeAndBrowse;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import serviceAndDao.*;
import ui.library.*;

public class HipHop2 extends JFrame {
	private JButton btnHome, btnLogout, btnArtists, btnAlbums, btnSongs, btnAllPlaylists, btnFavoriteSongs,
			btnNewPlaylist, btnAddToFavoriteSongs, btnAddToMyPlaylist, btnExit, btnBrowse;
	private JLabel lblPlaylists, lblAllTracks, lblEssentialAlbums, lblNewReleaseArtistName1, lblNewReleaseArtistName2,
			lblNewReleaseAlbumName3, lblNewReleaseArtistName3, lblEssentialAlbum1, lblEssentialAlbumName1,
			lblEssentialAlbumArtistName1, lblEssentialAlbum2, lblEssentialAlbumName2, lblEssentialAlbumArtistName2,
			lblEssentialAlbum3, lblEssentialAlbumName3, lblEssentialAlbumArtistName3;
	private JTable tableAllTrack;
	private JButton btnSearch;

	public HipHop2() {
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

		btnHome = new JButton("  Home");
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnHome.setIcon(new ImageIcon(Home2.class.getResource("/Images/homelogo.png")));
		btnHome.setBounds(22, 84, 223, 34);
		panel1.add(btnHome);

		btnBrowse = new JButton("  Browse");
		btnBrowse.setIcon(new ImageIcon(HipHop2.class.getResource("/Images/browse.png")));
		btnBrowse.setHorizontalAlignment(SwingConstants.LEFT);
		btnBrowse.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnBrowse.setContentAreaFilled(false);
		btnBrowse.setBorderPainted(false);
		btnBrowse.setBounds(22, 128, 223, 34);
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
		
		btnSearch = new JButton("  Search");
		btnSearch.setIcon(new ImageIcon(HipHop2.class.getResource("/Images/search.png")));
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setBounds(22, 172, 223, 34);
		panel1.add(btnSearch);

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

		JLabel lblPop = new JLabel("Hip-Hop");
		lblPop.setBounds(30, 10, 225, 53);
		panel2.add(lblPop);
		lblPop.setFont(new Font("AppleSDGothicNeoB00", Font.PLAIN, 45));

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(255, 255, 255));
		panel3.setBounds(270, 76, 1006, 610);
		getContentPane().add(panel3);
		panel3.setLayout(null);

		lblAllTracks = new JLabel("All Tracks > ");
		lblAllTracks.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 15));
		lblAllTracks.setBounds(23, 43, 204, 37);
		panel3.add(lblAllTracks);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 88, 274, 473);
		panel3.add(scrollPane);
		
		// ------------ 테이블 설계 ---------------
		
		Vector<String> columnNames = new Vector<>();
		columnNames.add("song");
		columnNames.add("artist");
		columnNames.add("album");
		
		MusicService musicService = new MusicService();
		Vector<Vector<Object>> data = musicService.getTracksByGenres("hiphop");
		
		tableAllTrack = new JTable(data, columnNames);
		scrollPane.setViewportView(tableAllTrack);
		
		// 헤더 이동 고정
		tableAllTrack.getTableHeader().setReorderingAllowed(false);
		
		//-----------------------------------------------------
		
		JLabel lblNewReleases = new JLabel("New Releases > ");
		lblNewReleases.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 15));
		lblNewReleases.setBounds(340, 43, 156, 37);
		panel3.add(lblNewReleases);

		JLabel lblNewReleases1 = new JLabel("");
		lblNewReleases1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewReleases1.setBounds(340, 88, 170, 152);
		panel3.add(lblNewReleases1);

		JLabel lblNewReleases2 = new JLabel("");
		lblNewReleases2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewReleases2.setBounds(558, 88, 170, 152);
		panel3.add(lblNewReleases2);

		JLabel lblNewReleases3 = new JLabel("");
		lblNewReleases3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewReleases3.setBounds(777, 88, 170, 152);
		panel3.add(lblNewReleases3);

		lblEssentialAlbums = new JLabel("Essential Albums  >");
		lblEssentialAlbums.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 15));
		lblEssentialAlbums.setBounds(340, 312, 169, 37);
		panel3.add(lblEssentialAlbums);

		JLabel lblNewReleaseAlbumName1 = new JLabel("Album name");
		lblNewReleaseAlbumName1.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseAlbumName1.setBounds(340, 243, 169, 27);
		panel3.add(lblNewReleaseAlbumName1);

		lblNewReleaseArtistName1 = new JLabel("Artist name");
		lblNewReleaseArtistName1.setForeground(new Color(128, 128, 128));
		lblNewReleaseArtistName1.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseArtistName1.setBounds(340, 263, 169, 27);
		panel3.add(lblNewReleaseArtistName1);

		JLabel lblNewReleaseAlbumName2 = new JLabel("Album name");
		lblNewReleaseAlbumName2.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseAlbumName2.setBounds(558, 243, 169, 27);
		panel3.add(lblNewReleaseAlbumName2);

		lblNewReleaseArtistName2 = new JLabel("Artist name");
		lblNewReleaseArtistName2.setForeground(Color.GRAY);
		lblNewReleaseArtistName2.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseArtistName2.setBounds(558, 263, 169, 27);
		panel3.add(lblNewReleaseArtistName2);

		lblNewReleaseAlbumName3 = new JLabel("Album name");
		lblNewReleaseAlbumName3.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseAlbumName3.setBounds(777, 243, 169, 27);
		panel3.add(lblNewReleaseAlbumName3);

		lblNewReleaseArtistName3 = new JLabel("Artist name");
		lblNewReleaseArtistName3.setForeground(Color.GRAY);
		lblNewReleaseArtistName3.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseArtistName3.setBounds(777, 263, 169, 27);
		panel3.add(lblNewReleaseArtistName3);

		lblEssentialAlbum1 = new JLabel("");
		lblEssentialAlbum1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEssentialAlbum1.setBounds(340, 359, 170, 152);
		panel3.add(lblEssentialAlbum1);

		lblEssentialAlbumName1 = new JLabel("Album name");
		lblEssentialAlbumName1.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumName1.setBounds(340, 514, 169, 27);
		panel3.add(lblEssentialAlbumName1);

		lblEssentialAlbumArtistName1 = new JLabel("Artist name");
		lblEssentialAlbumArtistName1.setForeground(Color.GRAY);
		lblEssentialAlbumArtistName1.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumArtistName1.setBounds(340, 534, 169, 27);
		panel3.add(lblEssentialAlbumArtistName1);

		lblEssentialAlbum2 = new JLabel("");
		lblEssentialAlbum2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEssentialAlbum2.setBounds(558, 359, 170, 152);
		panel3.add(lblEssentialAlbum2);

		lblEssentialAlbumName2 = new JLabel("Album name");
		lblEssentialAlbumName2.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumName2.setBounds(558, 514, 169, 27);
		panel3.add(lblEssentialAlbumName2);

		lblEssentialAlbumArtistName2 = new JLabel("Artist name");
		lblEssentialAlbumArtistName2.setForeground(Color.GRAY);
		lblEssentialAlbumArtistName2.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumArtistName2.setBounds(558, 534, 169, 27);
		panel3.add(lblEssentialAlbumArtistName2);

		lblEssentialAlbum3 = new JLabel("");
		lblEssentialAlbum3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEssentialAlbum3.setBounds(777, 359, 170, 152);
		panel3.add(lblEssentialAlbum3);

		lblEssentialAlbumName3 = new JLabel("Album name");
		lblEssentialAlbumName3.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumName3.setBounds(777, 514, 169, 27);
		panel3.add(lblEssentialAlbumName3);

		lblEssentialAlbumArtistName3 = new JLabel("Artist name");
		lblEssentialAlbumArtistName3.setForeground(Color.GRAY);
		lblEssentialAlbumArtistName3.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumArtistName3.setBounds(777, 534, 169, 27);
		panel3.add(lblEssentialAlbumArtistName3);

		btnAddToMyPlaylist = new JButton("");
		btnAddToMyPlaylist.setIcon(new ImageIcon(Pop1.class.getResource("/Images/addToPlaylist.png")));
		btnAddToMyPlaylist.setOpaque(false);
		btnAddToMyPlaylist.setForeground(Color.BLACK);
		btnAddToMyPlaylist.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnAddToMyPlaylist.setContentAreaFilled(false);
		btnAddToMyPlaylist.setBorderPainted(false);
		btnAddToMyPlaylist.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAddToMyPlaylist.setBackground(Color.WHITE);
		btnAddToMyPlaylist.setBounds(248, 43, 48, 34);
		panel3.add(btnAddToMyPlaylist);

		btnAddToFavoriteSongs = new JButton("");
		btnAddToFavoriteSongs.setIcon(new ImageIcon(Pop1.class.getResource("/Images/favoriteSongsHeartVer.png")));
		btnAddToFavoriteSongs.setOpaque(false);
		btnAddToFavoriteSongs.setForeground(Color.BLACK);
		btnAddToFavoriteSongs.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnAddToFavoriteSongs.setContentAreaFilled(false);
		btnAddToFavoriteSongs.setBorderPainted(false);
		btnAddToFavoriteSongs.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAddToFavoriteSongs.setBackground(Color.WHITE);
		btnAddToFavoriteSongs.setBounds(205, 43, 48, 34);
		panel3.add(btnAddToFavoriteSongs);
		

//===============================================================================

		// 홈 버튼 클릭 시 처리
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home2();
			}
		});

		// 아티스트 버튼
		btnArtists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Artists();
			}
		});
		
		// 로그아웃 버튼
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home1();
			}
		});
		
		// exit 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// 하트 버튼 (favorite songs 플레이리스트에 자동 저장)
		btnAddToFavoriteSongs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		// 플레이리스트 추가 버튼
		btnAddToMyPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		// browse 버튼
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Browse2();
			}
		});
		
		// search 버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Search2();
			}
		});

//===========================================================================
		
		setVisible(true);
	}
}
