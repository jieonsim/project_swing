package uiAndVO.playlists;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import serviceAndDao.MusicDAO;
import serviceAndDao.MusicService;
import uiAndVO.browse.Browse2;
import uiAndVO.home.Home1;
import uiAndVO.home.Home2;
import uiAndVO.library.Albums;
import uiAndVO.library.Artists;
import uiAndVO.library.Songs;
import uiAndVO.search.Search2;
import util.SessionManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPlaylists2 extends JFrame {
	private JButton btnHome, btnLogout, btnArtists, btnAlbums, btnSongs, btnAllPlaylists, btnFavoriteSongs,
			btnNewPlaylist, btnExit, btnBrowse, btnCondition, btnSearch, btnFullList, btnDeleteFromFavorite,
			btnAddToCover;
	private JLabel lblPlaylists, lblFavorite, lblMyCover, lblMyPlaylistsAllTrack, lblMyPlaylist;
	private DefaultTableModel dtm;
	private Vector<Vector<Object>> data;
	private Vector<String> columnNames;
	private DefaultTableCellRenderer dtcr;
	private TableColumnModel tcm;
	private JComboBox cbCondition;
	private JTextField txtCondition;
	private JTable table;
	private JFileChooser chooser;

	MusicService musicService = new MusicService();
	MusicDAO musicDAO = new MusicDAO();
	private JButton btnUpdatePlaylistName;

	public MyPlaylists2() {
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

		btnAllPlaylists = new JButton("  My Playlists");
		btnAllPlaylists.setIcon(new ImageIcon(Home2.class.getResource("/Images/allPlaylists.png")));
		btnAllPlaylists.setHorizontalAlignment(SwingConstants.LEFT);
		btnAllPlaylists.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnAllPlaylists.setContentAreaFilled(false);
		btnAllPlaylists.setBorderPainted(false);
		btnAllPlaylists.setBounds(22, 260, 223, 34);
		panel1.add(btnAllPlaylists);

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

		btnBrowse = new JButton("  Browse");
		btnBrowse.setIcon(new ImageIcon(Browse2.class.getResource("/Images/browse.png")));
		btnBrowse.setHorizontalAlignment(SwingConstants.LEFT);
		btnBrowse.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnBrowse.setContentAreaFilled(false);
		btnBrowse.setBorderPainted(false);
		btnBrowse.setBounds(22, 128, 223, 34);
		panel1.add(btnBrowse);

		btnSearch = new JButton("  Search");
		btnSearch.setIcon(new ImageIcon(Browse2.class.getResource("/Images/search.png")));
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

		lblFavorite = new JLabel("My Playlists");
		lblFavorite.setBounds(43, 20, 181, 31);
		lblFavorite.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		panel3.add(lblFavorite);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 12));
		scrollPane.setBorder(new LineBorder(new Color(192, 192, 192)));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(332, 110, 618, 458);
		panel3.add(scrollPane);

		cbCondition = new JComboBox();
		cbCondition.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		cbCondition.setModel(new DefaultComboBoxModel(new String[] { "선택하세요", "노래 제목", "아티스트 이름" }));
		cbCondition.setBounds(492, 21, 120, 35);
		panel3.add(cbCondition);

		txtCondition = new JTextField();
		txtCondition.setHorizontalAlignment(SwingConstants.LEFT);
		txtCondition.setSelectionColor(new Color(192, 192, 192));
		txtCondition.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		txtCondition.setBounds(624, 22, 120, 35);
		panel3.add(txtCondition);
		txtCondition.setColumns(10);

		btnCondition = new JButton("검색");
		btnCondition.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		btnCondition.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		btnCondition.setBackground(new Color(232, 232, 232));
		btnCondition.setBounds(756, 24, 91, 31);
		panel3.add(btnCondition);

		btnFullList = new JButton("전체조회");
		btnFullList.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		btnFullList.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		btnFullList.setBackground(new Color(232, 232, 232));
		btnFullList.setBounds(859, 24, 91, 31);
		panel3.add(btnFullList);

		btnDeleteFromFavorite = new JButton("");
		btnDeleteFromFavorite.setBounds(435, 20, 48, 34);
		panel3.add(btnDeleteFromFavorite);
		btnDeleteFromFavorite.setIcon(new ImageIcon(FavoriteSongs.class.getResource("/Images/trash.png")));
		btnDeleteFromFavorite.setOpaque(false);
		btnDeleteFromFavorite.setForeground(Color.BLACK);
		btnDeleteFromFavorite.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnDeleteFromFavorite.setContentAreaFilled(false);
		btnDeleteFromFavorite.setBorderPainted(false);
		btnDeleteFromFavorite.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnDeleteFromFavorite.setBackground(Color.WHITE);

		JPanel panel3_1 = new JPanel();
		panel3_1.setBounds(43, 70, 245, 176);
		panel3.add(panel3_1);
		panel3_1.setLayout(null);

		JLabel lblHeartCover = new JLabel("");
		lblHeartCover.setFont(new Font("굴림", Font.PLAIN, 12));
		lblHeartCover.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartCover.setIcon(new ImageIcon(MyPlaylists2.class.getResource("/Images/heart128.png")));
		lblHeartCover.setBounds(0, 0, 245, 176);
		panel3_1.add(lblHeartCover);

		JLabel lblFavortieSongs = new JLabel("Favorite Songs");
		lblFavortieSongs.setBounds(43, 256, 159, 31);
		panel3.add(lblFavortieSongs);
		lblFavortieSongs.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 17));

		JPanel panel3_2 = new JPanel();
		panel3_2.setLayout(null);
		panel3_2.setBounds(43, 297, 245, 176);
		panel3.add(panel3_2);

		lblMyCover = new JLabel("");
		lblMyCover.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyCover.setFont(new Font("굴림", Font.PLAIN, 12));
		lblMyCover.setBounds(0, 0, 245, 176);
		panel3_2.add(lblMyCover);

		btnAddToCover = new JButton("");
		btnAddToCover.setIcon(new ImageIcon(MyPlaylists2.class.getResource("/Images/picture.png")));
		btnAddToCover.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 14));
		btnAddToCover.setContentAreaFilled(false);
		btnAddToCover.setBorderPainted(false);
		btnAddToCover.setBounds(43, 524, 38, 34);
		panel3.add(btnAddToCover);

		btnUpdatePlaylistName = new JButton("");
		btnUpdatePlaylistName.setIcon(new ImageIcon(MyPlaylists2.class.getResource("/Images/edit.png")));
		btnUpdatePlaylistName.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 14));
		btnUpdatePlaylistName.setContentAreaFilled(false);
		btnUpdatePlaylistName.setBorderPainted(false);
		btnUpdatePlaylistName.setBounds(93, 524, 38, 34);
		panel3.add(btnUpdatePlaylistName);

		// ---------------사용자별 playlistName 출력 부분------------------

		lblMyPlaylist = new JLabel();
		updatePlaylistNameLabel();
		lblMyPlaylist.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 17));
		lblMyPlaylist.setBounds(43, 483, 245, 31);
		panel3.add(lblMyPlaylist);

		lblMyPlaylistsAllTrack = new JLabel();
		lblMyPlaylistsAllTrackLabel();
		lblMyPlaylistsAllTrack.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 15));
		lblMyPlaylistsAllTrack.setBounds(332, 69, 370, 31);
		panel3.add(lblMyPlaylistsAllTrack);

		// --------------- 테이블 설계 ------------------------------------------

		// 테이블 데이터와 컬럼 이름 준비
		columnNames = new Vector<>();
		columnNames.add("No");
		columnNames.add("Song");
		columnNames.add("Artist");

		// 현재 로그인한 사용자의 ID를 SessionManager에서 가져오기
		Integer currentUserIDX = SessionManager.getCurrentUserIDX();

		// 로그인한 사용자의 IDX가 null이 아니라면,
		// 해당 사용자가 만든 플레이리스트의 노래 목록 가져오기
		if (currentUserIDX != null) {
			data = musicService.getUserCreatedPlaylistTracks(currentUserIDX);
			table = new JTable(data, columnNames);

			// 테이블 설정 (셀 크기, 헤더 이동 고정, 셀 가운데 정렬)
			table.getColumnModel().getColumn(0).setMaxWidth(50);
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(2).setResizable(false);
			table.getTableHeader().setReorderingAllowed(false);

			dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);
			tcm = table.getColumnModel();
			for (int i = 0; i < tcm.getColumnCount(); i++) {
				tcm.getColumn(i).setCellRenderer(dtcr);
			}
			scrollPane.setViewportView(table);
		} else {
			// 로그인한 사용자의 IDX가 null인 경우
			JOptionPane.showMessageDialog(null, "로그인 상태를 확인해주세요.");
		}

		// ----------------------------------------------------------------------


		// 홈 버튼 클릭 시 처리
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home2();
			}
		});

		// 브라우저 클릭
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Browse2();
			}
		});

		// 아티스트 버튼 클릭
		btnArtists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Artists();
			}
		});

		// 로그아웃 버튼 클릭
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home1();
			}
		});

		// 종료 버튼 클릭
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// search 버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Search2();
			}
		});

		// 휴지통 버튼
		btnDeleteFromFavorite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteUserCreatedPlaylistTracks();
			}
		});

		// favorite songs 버튼
		btnFavoriteSongs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FavoriteSongs();
			}
		});

		// 검색 버튼
		btnCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserCreatedPlaylistConditionSearch();
			}
		});

		// 전체조회 버튼
		btnFullList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserCreatedPlaylisttotalSearch();
			}
		});

		// my playlists 버튼
		btnAllPlaylists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MyPlaylists2();
			}
		});

		// new playlists 버튼
		btnNewPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createNewPlaylist();
			}
		});

		// playlist name edit
		btnUpdatePlaylistName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePlaylistsName();
			}
		});

		// playlist cover add
		btnAddToCover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uploadAndSetCoverImage();
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

		// ------------------------------------------------------

		setVisible(true);
	}

	// 사용자가 만든 플레이리스트에서 노래 삭제
	protected void deleteUserCreatedPlaylistTracks() {
		int[] selectedRows = table.getSelectedRows();
		if (selectedRows.length > 0) {
			Integer userIDX = SessionManager.getCurrentUserIDX();

			int response = JOptionPane.showConfirmDialog(null, "선택한 노래를 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
			if (response == JOptionPane.YES_OPTION && userIDX != null) {
				boolean success = true;
				for (int selectedRow : selectedRows) {
					int songIDX = Integer.parseInt(table.getModel().getValueAt(selectedRow, 0).toString());
					success &= musicService.deleteFromUserCreatedPlaylsit(userIDX, songIDX);
				}

				if (success) {
					JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
					refreshUserCreatedPlaylistTable(); // 삭제 후 테이블을 새로고침하는 메소드
				} else {
					JOptionPane.showMessageDialog(null, "노래 삭제에 실패했습니다.");
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "검색하신 내용은 존재하지 않습니다.");
		}
	}

	// 사용자가 만든 플레이리스트의 테이블 새로고침
	private void refreshUserCreatedPlaylistTable() {
		Integer currentUserIDX = SessionManager.getCurrentUserIDX();
		if (currentUserIDX != null) {
			Vector<Vector<Object>> newData = musicService.getUserCreatedPlaylistTracks(currentUserIDX);
			columnNames = new Vector<>();
			columnNames.add("No");
			columnNames.add("Song");
			columnNames.add("Artist");

			// 테이블 모델 가져오기
			dtm = (DefaultTableModel) table.getModel();
			// 테이블의 데이터와 컬럼 이름을 새롭게 설정
			dtm.setDataVector(newData, columnNames);
			// 셀 크기, 이동 고정
			table.getColumnModel().getColumn(0).setMaxWidth(50);
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(2).setResizable(false);
			table.getTableHeader().setReorderingAllowed(false);
			// 셀 가운데 정렬
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumnModel tcm = table.getColumnModel();
			for (int i = 0; i < tcm.getColumnCount(); i++) {
				tcm.getColumn(i).setCellRenderer(dtcr);
			}
		} else {
			JOptionPane.showMessageDialog(null, "로그인 상태를 확인해주세요.");
		}
	}

	// 조건 검색
	protected void UserCreatedPlaylistConditionSearch() {
		// 현재 로그인한 사용자의 IDX 가져오기
		Integer userIDX = SessionManager.getCurrentUserIDX();
		if (userIDX == null) {
			JOptionPane.showConfirmDialog(null, "로그인 상태를 확인해주세요.");
			return;
		}

		String selectedCondition = cbCondition.getSelectedItem().toString();
		String searchText = txtCondition.getText().trim();

		if (searchText.isEmpty()) {
			JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요.");
			txtCondition.requestFocus();
			return;
		}

		String searchColumn = "";
		if (selectedCondition.equals("노래 제목")) {
			searchColumn = "s.songName";
		} else if (selectedCondition.equals("아티스트 이름")) {
			searchColumn = "a.artistName";
		} else {
			JOptionPane.showMessageDialog(null, "올바른 검색 조건을 선택하세요.");
			return;
		}
		Vector<Vector<Object>> newData = musicDAO.getUserCreatedPlaylistByCondition(userIDX, searchColumn,
				"%" + searchText + "%");

		if (newData.size() == 0) {
			// 검색 결과가 없는 경우
			JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.");
		} else {
			// 테이블 모델 업데이트
			dtm = (DefaultTableModel) table.getModel();
			dtm.setDataVector(newData, columnNames);
			table.setModel(dtm);
			// 셀 크기 줄이기, 셀 크기 고정, 헤더 이동 고정
			table.getColumnModel().getColumn(0).setMaxWidth(50);
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(2).setResizable(false);
			table.getTableHeader().setReorderingAllowed(false);
			// 전체셀 가운데 정렬
			dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);
			tcm = table.getColumnModel();
			for (int i = 0; i < tcm.getColumnCount(); i++) {
				tcm.getColumn(i).setCellRenderer(dtcr);
			}
		}
	}

	// 전체 검색 버튼 클릭 시 모든 트랙 재출력 메소드
	protected void UserCreatedPlaylisttotalSearch() {
		// 현재 로그인한 사용자의 IDX를 SessioinManager에서 가져오기
		Integer currnetUserIDX = SessionManager.getCurrentUserIDX();

		if (currnetUserIDX != null) {
			// 사용자의 IDX를 사용하여 해당 사용자의 플레이리스트 목록 조회
			data = musicService.getUserCreatedPlaylistTracks(currnetUserIDX);

			dtm = (DefaultTableModel) table.getModel();
			dtm.setDataVector(data, columnNames);

			// 셀 크기 줄이기, 셀 크기 고정, 헤더 이동 고정
			table.getColumnModel().getColumn(0).setMaxWidth(50);
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(2).setResizable(false);
			table.getTableHeader().setReorderingAllowed(false);
			// 전체 셀 가운데 정렬
			dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);
			tcm = table.getColumnModel();
			for (int i = 0; i < tcm.getColumnCount(); i++) {
				tcm.getColumn(i).setCellRenderer(dtcr);
			}
		} else {
			// 사용자가 로그인하지 않은 경우 처리
			JOptionPane.showMessageDialog(null, "로그인 상태를 확인해주세요.");
		}
	}

	// 사용자 만든 플레이리스트의 플레이리스트 이름 생성해주기
	private void updatePlaylistNameLabel() {
		Integer userIDX = SessionManager.getCurrentUserIDX();
		String playlistName = musicService.getPlaylistNameByUserIDX(userIDX);
		if (playlistName != null && !playlistName.isEmpty()) {
			lblMyPlaylist.setText(playlistName);
		} else {
			lblMyPlaylist.setText("No playlist"); // 플레이리스트가 없을 경우 출력
		}
	}

	private void lblMyPlaylistsAllTrackLabel() {
		Integer userIDX = SessionManager.getCurrentUserIDX();
		String playlistName = musicService.getPlaylistNameByUserIDX(userIDX);
		if (playlistName != null && !playlistName.isEmpty()) {
			lblMyPlaylistsAllTrack.setText("All Tracks from " + playlistName);
		} else {
			lblMyPlaylistsAllTrack.setText("추가된 트랙이 없습니다. 플레이리스트를 만들어 보세요."); // 플레이리스트가 없을 경우 출력
		}
	}

	// 새로운 플레이리스트 만들기 메소드
	private void createNewPlaylist() {
		// 사용자 입력을 통해 플레이리스트 이름을 받아옴
		String playlistName = JOptionPane.showInputDialog("플레이리스트 이름을 입력하세요.");
		if (playlistName != null && !playlistName.trim().isEmpty()) {
			// Service를 통해 플레이리스트 생성 요청
			if (musicService.createNewPlaylist(SessionManager.getCurrentUserIDX(), playlistName)) {
				JOptionPane.showMessageDialog(null, "새 플레이리스트가 생성되었습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "플레이리스트 생성에 실패했습니다. 이미 플레이리스트가 존재합니다.");
			}
		}
	}

	// 사용자 플레이리스트 이름 수정
	private void updatePlaylistsName() {
		// 현재 로그인한 사용자의 IDX 가져오기
		Integer userIDX = SessionManager.getCurrentUserIDX();
		if (userIDX == null) {
			JOptionPane.showMessageDialog(null, "로그인 상태를 확인해주세요.");
			return;
		}

		// 사용자가 플레이리스트를 가지고 있는지 확인
		if (!musicDAO.userHasPlaylist(userIDX)) {
			JOptionPane.showMessageDialog(null, "플레이리스트가 없습니다. 플레이리스트를 먼저 생성해주세요.");
			return;
		}

		// 새로운 플레이리스트 이름 입력 받기
		String newPlaylistName = JOptionPane.showInputDialog("수정할 플레이리스트 이름을 입력하세요");
		if (newPlaylistName != null && !newPlaylistName.trim().isEmpty()) {
			// service를 통해 플레이리스트 이름 수정 요청
			if (musicService.updatePlaylistName(userIDX, newPlaylistName.trim())) {
				JOptionPane.showMessageDialog(null, "플레이리스트 이름이 수정되었습니다.");
				updatePlaylistNameLabel();
				lblMyPlaylistsAllTrackLabel();
			} else {
				JOptionPane.showMessageDialog(null, "플레이리스트 이름 수정에 실패했습니다.");
			}
		}
	}

	// 사용자 플레이리스트 커버 사진 추가
	/*
	 * 1. 이미지 업로드 처리 : 사용자가 이미지 업로드하면 선택한 이미지 파일 경로 가져오기
	 * 2. 데이터베이스 업데이트 : 선택한 이미지의 경로를 데이터베이스에 업데이트 (updatePlaylistCoverImage 메소드 사용)
	 * 3. 라벨에 이미지 표시 : 업로드된 이미지를 lblMyCover 라벨에 아이콘으로 설정
	 */
	private void uploadAndSetCoverImage() {
		chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
		chooser.setFileFilter(filter);

		int result = chooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();
			//String filePath = selectedFile.getAbsolutePath();
			String filePath = selectedFile.getPath();

			Integer userIDX = SessionManager.getCurrentUserIDX();
			if (userIDX == null) {
				JOptionPane.showMessageDialog(null, "로그인 상태를 확인해주세요.");
				return;
			}

			int playlistIDX = musicDAO.getUserNewPlaylistIDX(userIDX);
			if (playlistIDX == -1) {
				JOptionPane.showMessageDialog(null, "플레이리스트가 없습니다. 플레이리스트를 먼저 생성해주세요.");
				return;
			}

			if (musicDAO.updatePlaylistCoverImage(playlistIDX, filePath)) {
				ImageIcon icon = new ImageIcon(new ImageIcon(filePath).getImage()
						.getScaledInstance(lblMyCover.getWidth(), lblMyCover.getHeight(), Image.SCALE_DEFAULT));
				lblMyCover.setIcon(icon);

				JOptionPane.showMessageDialog(null, "커버 이미지가 업데이트되었습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "이미지 업로드에 실패했습니다.");
			}
		}
	}

}
