package uiAndVO.browse;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import serviceAndDao.MusicService;
import uiAndVO.home.Home1;
import uiAndVO.home.Home2;
import uiAndVO.home.Login;
import uiAndVO.search.Search1;

public class RnbSoul1 extends JFrame {
	private JButton btnHome, btnLogin, btnExit, btnBrowse, btnSearch;
	private JLabel lblAllTracks, lblEssentialAlbums, lblNewReleaseArtistName2,
			lblNewReleaseAlbumName3, lblNewReleaseArtistName3, lblEssentialAlbum2, lblEssentialAlbumName2, lblEssentialAlbumArtistName2,
			lblEssentialAlbum3, lblEssentialAlbumName3, lblEssentialAlbumArtistName3;
	private JTable tableAllTrack;

	public RnbSoul1() {
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

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(255, 255, 255));
		panel3.setBounds(270, 76, 1006, 610);
		getContentPane().add(panel3);
		panel3.setLayout(null);

		lblAllTracks = new JLabel("R&B / Soul All Tracks > ");
		lblAllTracks.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 15));
		lblAllTracks.setBounds(44, 38, 181, 27);
		panel3.add(lblAllTracks);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 75, 480, 473);
		panel3.add(scrollPane);
		
		// ------------ 테이블 설계 ---------------
		
		Vector<String> columnNames = new Vector<>();
		columnNames.add("No");
		columnNames.add("Song");
		columnNames.add("Artist");
		columnNames.add("Album");
		
		MusicService musicService = new MusicService();
		Vector<Vector<Object>> data = musicService.getTracksByGenres("rnbSoul");
		
		tableAllTrack = new JTable(data, columnNames);
		tableAllTrack.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 12));
		scrollPane.setViewportView(tableAllTrack);
		
		tableAllTrack.getColumnModel().getColumn(0).setMaxWidth(50);
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
		lblNewReleases.setBounds(557, 42, 156, 27);
		panel3.add(lblNewReleases);

		JLabel lblNewReleases2 = new JLabel("");
		lblNewReleases2.setIcon(new ImageIcon(RnbSoul1.class.getResource("/Images/browse/rnbSoulNew1.gif")));
		lblNewReleases2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewReleases2.setBounds(558, 75, 170, 152);
		panel3.add(lblNewReleases2);

		JLabel lblNewReleases3 = new JLabel("");
		lblNewReleases3.setIcon(new ImageIcon(RnbSoul1.class.getResource("/Images/browse/rnbSoulNew2.gif")));
		lblNewReleases3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewReleases3.setBounds(777, 75, 170, 152);
		panel3.add(lblNewReleases3);

		lblEssentialAlbums = new JLabel("Essential Albums  >");
		lblEssentialAlbums.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 15));
		lblEssentialAlbums.setBounds(557, 313, 169, 27);
		panel3.add(lblEssentialAlbums);

		JLabel lblNewReleaseAlbumName2 = new JLabel("Cinema Pt. 2 - EP");
		lblNewReleaseAlbumName2.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseAlbumName2.setBounds(557, 237, 169, 27);
		panel3.add(lblNewReleaseAlbumName2);

		lblNewReleaseArtistName2 = new JLabel("Dori");
		lblNewReleaseArtistName2.setForeground(Color.GRAY);
		lblNewReleaseArtistName2.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseArtistName2.setBounds(557, 257, 169, 27);
		panel3.add(lblNewReleaseArtistName2);

		lblNewReleaseAlbumName3 = new JLabel("HEAVY");
		lblNewReleaseAlbumName3.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseAlbumName3.setBounds(776, 237, 169, 27);
		panel3.add(lblNewReleaseAlbumName3);

		lblNewReleaseArtistName3 = new JLabel("SiR");
		lblNewReleaseArtistName3.setForeground(Color.GRAY);
		lblNewReleaseArtistName3.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseArtistName3.setBounds(776, 257, 169, 27);
		panel3.add(lblNewReleaseArtistName3);

		lblEssentialAlbum2 = new JLabel("");
		lblEssentialAlbum2.setIcon(new ImageIcon(RnbSoul1.class.getResource("/Images/browse/rnbSoulEssential1.gif")));
		lblEssentialAlbum2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEssentialAlbum2.setBounds(558, 346, 170, 152);
		panel3.add(lblEssentialAlbum2);

		lblEssentialAlbumName2 = new JLabel("Ctrl");
		lblEssentialAlbumName2.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumName2.setBounds(557, 508, 169, 27);
		panel3.add(lblEssentialAlbumName2);

		lblEssentialAlbumArtistName2 = new JLabel("SZA");
		lblEssentialAlbumArtistName2.setForeground(Color.GRAY);
		lblEssentialAlbumArtistName2.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumArtistName2.setBounds(557, 528, 169, 27);
		panel3.add(lblEssentialAlbumArtistName2);

		lblEssentialAlbum3 = new JLabel("");
		lblEssentialAlbum3.setIcon(new ImageIcon(RnbSoul1.class.getResource("/Images/browse/rnbSoulEssential2.gif")));
		lblEssentialAlbum3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEssentialAlbum3.setBounds(777, 346, 170, 152);
		panel3.add(lblEssentialAlbum3);

		lblEssentialAlbumName3 = new JLabel("From Midnight To Sunrise");
		lblEssentialAlbumName3.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumName3.setBounds(776, 508, 169, 27);
		panel3.add(lblEssentialAlbumName3);

		lblEssentialAlbumArtistName3 = new JLabel("크러쉬");
		lblEssentialAlbumArtistName3.setForeground(Color.GRAY);
		lblEssentialAlbumArtistName3.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumArtistName3.setBounds(776, 528, 169, 27);
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
