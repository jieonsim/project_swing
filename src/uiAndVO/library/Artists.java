package uiAndVO.library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import serviceAndDao.MusicDAO;
import serviceAndDao.MusicService;
import uiAndVO.browse.Browse2;
import uiAndVO.home.Home1;
import uiAndVO.home.Home2;
import uiAndVO.playlists.FavoriteSongs;
import uiAndVO.playlists.MyPlaylists;
import uiAndVO.search.Search2;
import util.SessionManager;

public class Artists extends JFrame {
	private JButton btnHome, btnLogout, btnArtists, btnAlbums, btnSongs, btnMyplaylists, btnFavoriteSongs,
			btnNewPlaylist, btnExit, btnBrowse, btnSearch;
	private JLabel lblPlaylists;
	private JScrollPane scrollPane;
	private DefaultTableModel dtm;
	private DefaultTableCellRenderer dtcr;
	private JTable table;

	MusicService musicService = new MusicService();
	MusicDAO musicDAO = new MusicDAO();

	public Artists() {
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
		btnBrowse.setIcon(new ImageIcon(Artists.class.getResource("/Images/browse.png")));
		btnBrowse.setHorizontalAlignment(SwingConstants.LEFT);
		btnBrowse.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnBrowse.setContentAreaFilled(false);
		btnBrowse.setBorderPainted(false);
		btnBrowse.setBounds(22, 128, 223, 34);
		panel1.add(btnBrowse);

		JLabel lblLibrary = new JLabel("Library");
		lblLibrary.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 15));
		lblLibrary.setBounds(22, 409, 93, 26);
		panel1.add(lblLibrary);

		btnArtists = new JButton("  Artists");
		btnArtists.setIcon(new ImageIcon(Home2.class.getResource("/Images/artists.png")));
		btnArtists.setHorizontalAlignment(SwingConstants.LEFT);
		btnArtists.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnArtists.setContentAreaFilled(false);
		btnArtists.setBorderPainted(false);
		btnArtists.setBounds(22, 445, 223, 34);
		panel1.add(btnArtists);

		btnAlbums = new JButton("  Alubms");
		btnAlbums.setIcon(new ImageIcon(Home2.class.getResource("/Images/albums.png")));
		btnAlbums.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlbums.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnAlbums.setContentAreaFilled(false);
		btnAlbums.setBorderPainted(false);
		btnAlbums.setBounds(22, 489, 223, 34);
		panel1.add(btnAlbums);

		btnSongs = new JButton("  Songs");
		btnSongs.setIcon(new ImageIcon(Home2.class.getResource("/Images/songs.png")));
		btnSongs.setHorizontalAlignment(SwingConstants.LEFT);
		btnSongs.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnSongs.setContentAreaFilled(false);
		btnSongs.setBorderPainted(false);
		btnSongs.setBounds(22, 533, 223, 34);
		panel1.add(btnSongs);

		lblPlaylists = new JLabel("Playlists");
		lblPlaylists.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 15));
		lblPlaylists.setBounds(22, 224, 93, 26);
		panel1.add(lblPlaylists);

		btnMyplaylists = new JButton("  My Playlists");
		btnMyplaylists.setIcon(new ImageIcon(Home2.class.getResource("/Images/allPlaylists.png")));
		btnMyplaylists.setHorizontalAlignment(SwingConstants.LEFT);
		btnMyplaylists.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnMyplaylists.setContentAreaFilled(false);
		btnMyplaylists.setBorderPainted(false);
		btnMyplaylists.setBounds(22, 260, 223, 34);
		panel1.add(btnMyplaylists);

		btnFavoriteSongs = new JButton("  Favorite Songs");
		btnFavoriteSongs.setIcon(new ImageIcon(Home2.class.getResource("/Images/favoriteSongsHeartVer.png")));
		btnFavoriteSongs.setHorizontalAlignment(SwingConstants.LEFT);
		btnFavoriteSongs.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnFavoriteSongs.setContentAreaFilled(false);
		btnFavoriteSongs.setBorderPainted(false);
		btnFavoriteSongs.setBounds(22, 304, 223, 34);
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
		btnNewPlaylist.setBounds(30, 348, 158, 34);
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
		btnSearch.setIcon(new ImageIcon(Artists.class.getResource("/Images/search.png")));
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

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(255, 255, 255));
		panel3.setBounds(270, 76, 1006, 610);
		getContentPane().add(panel3);
		panel3.setLayout(null);

		JLabel lblBrowseCategories = new JLabel("Artist");
		lblBrowseCategories.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		lblBrowseCategories.setBounds(43, 20, 120, 31);
		panel3.add(lblBrowseCategories);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 69, 907, 483);
		panel3.add(scrollPane, BorderLayout.CENTER);

		// ---------------테이블 설계----------------------------------
		Vector<String> columnNames = new Vector<>();
		columnNames.add("No");
		columnNames.add("Image");
		columnNames.add("Artist Name");

		// 아티스트 데이터를 담을 벡터
		Vector<Vector<Object>> data = new Vector<>();

		// 현재 로그인한 사용자 IDX를 SessionManager에서 가져오기
		Integer currentUserIDX = SessionManager.getCurrentUserIDX();
		if (currentUserIDX != null) {
			// musicDAO를 통해 현재 사용자의 아티스트 정보를 가져오기
			List<ArtistVO> artists = musicDAO.getUserArtists(currentUserIDX);

			for (ArtistVO artist : artists) {
				Vector<Object> row = new Vector<>();
				row.add(artist.getArtistIDX());
				ImageIcon icon = null;
				String imagePath = artist.getImagePath();
				if (imagePath != null && !imagePath.isEmpty()) {
					URL imageUrl = getClass().getResource("/Images/Artists/" + imagePath);
					if (imageUrl != null) {
						icon = new ImageIcon(
								new ImageIcon(imageUrl).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
					}
				}
				row.add(icon); // Icon 객체를 데이터 벡터에 추가
				row.add(artist.getArtistName());
				data.add(row);
			}

			dtm = new DefaultTableModel(data, columnNames) {
				@Override
				public Class<?> getColumnClass(int column) {
					return column == 1 ? ImageIcon.class : Object.class; // 두번째 컬럼에는 이미지 아이콘 표시
				}
			};
			table = new JTable(dtm);

			// 0번째 열(albumIDX) 크기 줄이기
			table.getColumnModel().getColumn(0).setMaxWidth(30);
			// 이미지를 포함하는 컬럼을 제외하고 나머지 컬럼 중앙 정렬
			dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);
			table.getColumnModel().getColumn(0).setCellRenderer(dtcr);
			table.getColumnModel().getColumn(2).setCellRenderer(dtcr);
			// 이미지 컬럼 높이 조정
			table.setRowHeight(100);

			scrollPane.setViewportView(table);
		} else {
			JOptionPane.showMessageDialog(null, "로그인 상태를 확인해주세요.");
		}

		// -----------------------------------------------------------------
		setVisible(true);
		// -----------------------------------------------------------------

		// 홈 버튼 클릭 시 처리
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home2();
			}
		});

		// 아티스트 버튼 클릭
		btnArtists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Artists();
			}
		});

		// myplaylist
		btnMyplaylists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MyPlaylists();
			}
		});

		// exit 버튼 클릭
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// browse 버튼 클릭
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Browse2();
			}
		});

		// search
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Search2();
			}
		});

		// favorite
		btnFavoriteSongs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FavoriteSongs();
			}
		});

		// logout
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home1();
			}
		});

		// new playlist
		btnNewPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createNewPlaylist();
			}
		});

		// albums
		btnAlbums.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Albums();
			}
		});

		// songs
		btnSongs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Songs();
			}
		});

		// ============================================

		setVisible(true);
	}

	// 새로운 플레이리스트 만들기
	protected void createNewPlaylist() {
		// 사용자 입력을 통해 플레이리스트 이름을 받아옴
		String playlistName = JOptionPane.showInputDialog("플레이리스트 제목을 입력하세요.");
		if (playlistName != null && !playlistName.trim().isEmpty()) {
			// Service를 통해 플레이리스트 생성 요청
			if (musicService.createNewPlaylist(SessionManager.getCurrentUserIDX(), playlistName)) {
				JOptionPane.showMessageDialog(null, "새 플레이리스트가 생성되었습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "플레이리스트 생성에 실패했습니다. 이미 플레이리스트가 존재합니다.");
			}
		}
	}

}
