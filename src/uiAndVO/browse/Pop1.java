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

public class Pop1 extends JFrame {
	private JButton btnHome, btnLogin, btnExit, btnBrowse, btnSearch;
	private JLabel lblAllTracks, lblEssentialAlbums, lblNewReleaseArtistName1,
	lblNewReleaseAlbumName2, lblNewReleaseArtistName2, lblEssentialAlbum1, lblEssentialAlbumName1, lblEssentialAlbumArtistName1,
			lblEssentialAlbum2, lblEssentialAlbumName2, lblEssentialAlbumArtistName2;
	private JTable tableAllTrack;

	public Pop1() {
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

		lblAllTracks = new JLabel("Pop All Tracks > ");
		lblAllTracks.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 15));
		lblAllTracks.setBounds(44, 38, 137, 27);
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
		Vector<Vector<Object>> data = musicService.getTracksByGenres("pop");
		
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

		JLabel lblNewReleases1 = new JLabel("");
		lblNewReleases1.setIcon(new ImageIcon(Pop1.class.getResource("/Images/browse/popNew1.gif")));
		lblNewReleases1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewReleases1.setBounds(558, 75, 170, 152);
		panel3.add(lblNewReleases1);

		JLabel lblNewReleases2 = new JLabel("");
		lblNewReleases2.setIcon(new ImageIcon(Pop1.class.getResource("/Images/browse/popNew2.gif")));
		lblNewReleases2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewReleases2.setBounds(777, 75, 170, 152);
		panel3.add(lblNewReleases2);

		lblEssentialAlbums = new JLabel("Essential Albums  >");
		lblEssentialAlbums.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 15));
		lblEssentialAlbums.setBounds(557, 313, 169, 27);
		panel3.add(lblEssentialAlbums);

		JLabel lblNewReleaseAlbumName1 = new JLabel("eternal sunshine");
		lblNewReleaseAlbumName1.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseAlbumName1.setBounds(557, 237, 169, 27);
		panel3.add(lblNewReleaseAlbumName1);

		lblNewReleaseArtistName1 = new JLabel("Ariana Grande");
		lblNewReleaseArtistName1.setForeground(Color.GRAY);
		lblNewReleaseArtistName1.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseArtistName1.setBounds(557, 257, 169, 27);
		panel3.add(lblNewReleaseArtistName1);

		lblNewReleaseAlbumName2 = new JLabel("GUTS (spilled)");
		lblNewReleaseAlbumName2.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseAlbumName2.setBounds(776, 237, 169, 27);
		panel3.add(lblNewReleaseAlbumName2);

		lblNewReleaseArtistName2 = new JLabel("Olivia Rodrigo");
		lblNewReleaseArtistName2.setForeground(Color.GRAY);
		lblNewReleaseArtistName2.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseArtistName2.setBounds(776, 257, 169, 27);
		panel3.add(lblNewReleaseArtistName2);

		lblEssentialAlbum1 = new JLabel("");
		lblEssentialAlbum1.setIcon(new ImageIcon(Pop1.class.getResource("/Images/browse/popEssential1.gif")));
		lblEssentialAlbum1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEssentialAlbum1.setBounds(558, 346, 170, 152);
		panel3.add(lblEssentialAlbum1);

		lblEssentialAlbumName1 = new JLabel("After Hours");
		lblEssentialAlbumName1.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumName1.setBounds(557, 508, 169, 27);
		panel3.add(lblEssentialAlbumName1);

		lblEssentialAlbumArtistName1 = new JLabel("The Weekend");
		lblEssentialAlbumArtistName1.setForeground(Color.GRAY);
		lblEssentialAlbumArtistName1.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumArtistName1.setBounds(557, 528, 169, 27);
		panel3.add(lblEssentialAlbumArtistName1);

		lblEssentialAlbum2 = new JLabel("");
		lblEssentialAlbum2.setIcon(new ImageIcon(Pop1.class.getResource("/Images/browse/popEssential2.gif")));
		lblEssentialAlbum2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEssentialAlbum2.setBounds(777, 346, 170, 152);
		panel3.add(lblEssentialAlbum2);

		lblEssentialAlbumName2 = new JLabel("channel ORANGE");
		lblEssentialAlbumName2.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumName2.setBounds(776, 508, 169, 27);
		panel3.add(lblEssentialAlbumName2);

		lblEssentialAlbumArtistName2 = new JLabel("Frank Ocean");
		lblEssentialAlbumArtistName2.setForeground(Color.GRAY);
		lblEssentialAlbumArtistName2.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumArtistName2.setBounds(776, 528, 169, 27);
		panel3.add(lblEssentialAlbumArtistName2);
		

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
