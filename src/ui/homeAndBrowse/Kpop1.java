package ui.homeAndBrowse;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import serviceAndDao.*;
import ui.library.*;

public class Kpop1 extends JFrame {
	private JButton btnHome, btnLogin, btnExit, btnBrowse;
	private JLabel lblAllTracks, lblEssentialAlbums, lblNewReleaseArtistName1, lblNewReleaseArtistName2,
			lblNewReleaseAlbumName3, lblNewReleaseArtistName3, lblEssentialAlbum1, lblEssentialAlbumName1,
			lblEssentialAlbumArtistName1, lblEssentialAlbum2, lblEssentialAlbumName2, lblEssentialAlbumArtistName2,
			lblEssentialAlbum3, lblEssentialAlbumName3, lblEssentialAlbumArtistName3;
	private JTable tableAllTrack;
	private JButton btnSearch;

	public Kpop1() {
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
		btnBrowse.setIcon(new ImageIcon(HipHop1.class.getResource("/Images/browse.png")));
		btnBrowse.setHorizontalAlignment(SwingConstants.LEFT);
		btnBrowse.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnBrowse.setContentAreaFilled(false);
		btnBrowse.setBorderPainted(false);
		btnBrowse.setBounds(23, 128, 223, 34);
		panel1.add(btnBrowse);

		btnExit = new JButton("  Exit");
		btnExit.setIcon(new ImageIcon(Home2.class.getResource("/Images/exit.png")));
		btnExit.setHorizontalAlignment(SwingConstants.LEFT);
		btnExit.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setBounds(22, 600, 223, 34);
		panel1.add(btnExit);
		
		btnSearch = new JButton("  Search");
		btnSearch.setIcon(new ImageIcon(HipHop1.class.getResource("/Images/search.png")));
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

		btnLogin = new JButton("  LOGIN");
		btnLogin.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnLogin.setBorderPainted(false);
		btnLogin.setOpaque(true);
		btnLogin.setContentAreaFilled(true);
		btnLogin.setBackground(new Color(254, 85, 85));
		btnLogin.setFont(new Font("AppleSDGothicNeoB00", Font.PLAIN, 20));
		btnLogin.setIcon(new ImageIcon(HipHop1.class.getResource("/Images/user1WhiteVer.png")));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBounds(836, 21, 141, 34);
		panel2.add(btnLogin);

		JLabel lblKpop = new JLabel("K-Pop");
		lblKpop.setBounds(30, 10, 225, 53);
		panel2.add(lblKpop);
		lblKpop.setFont(new Font("AppleSDGothicNeoB00", Font.PLAIN, 45));

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
		columnNames.add("Song");
		columnNames.add("Artist");
		columnNames.add("Album");
		
		MusicService musicService = new MusicService();
		Vector<Vector<Object>> data = musicService.getTracksByGenres("kpop");
		
		tableAllTrack = new JTable(data, columnNames);
		scrollPane.setViewportView(tableAllTrack);
		
		// 헤더 이동 고정
		tableAllTrack.getTableHeader().setReorderingAllowed(false);
		
		// 전체셀 가운데 정렬
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = tableAllTrack.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
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
		

//===============================================================================

		//  home 버튼
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home1();
			}
		});
		
		// login 버튼
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login();
			}
		});
		
		// exit 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// browse 버튼
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Browse1();
			}
		});
		
		// search 버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Search1();
			}
		});

//===========================================================================
		
		setVisible(true);
	}
}
