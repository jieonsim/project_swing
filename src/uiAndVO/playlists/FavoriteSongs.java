package uiAndVO.playlists;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import serviceAndDao.MusicDAO;
import serviceAndDao.MusicService;
import uiAndVO.browse.Browse2;
import uiAndVO.browse.HipHop2;
import uiAndVO.browse.Pop1;
import uiAndVO.browse.Pop2;
import uiAndVO.browse.RnbSoul2;
import uiAndVO.browse.Rock2;
import uiAndVO.home.Home1;
import uiAndVO.home.Home2;
import uiAndVO.library.Albums;
import uiAndVO.library.Artists;
import uiAndVO.library.Songs;
import uiAndVO.search.Search2;
import util.SessionManager;

public class FavoriteSongs extends JFrame {
	private JButton btnHome, btnLogout, btnArtists, btnAlbums, btnSongs, btnMyPlaylists, btnFavoriteSongs,
			btnNewPlaylist, btnExit, btnBrowse, btnCondition, btnSearch, btnFullList, btnDeleteFromFavorite;
	private JLabel lblPlaylists, lblFavorite;
	private DefaultTableModel dtm;
	private Vector<Vector<Object>> data;
	private Vector<String> columnNames;
	private DefaultTableCellRenderer dtcr;
	private TableColumnModel tcm;
	private JComboBox cbCondition;
	private JTextField txtCondition;
	private JTable table;

	MusicService musicService = new MusicService();
	MusicDAO musicDAO = new MusicDAO();

	public FavoriteSongs() {
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

		btnMyPlaylists = new JButton("  My playlists");
		btnMyPlaylists.setIcon(new ImageIcon(Home2.class.getResource("/Images/allPlaylists.png")));
		btnMyPlaylists.setHorizontalAlignment(SwingConstants.LEFT);
		btnMyPlaylists.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnMyPlaylists.setContentAreaFilled(false);
		btnMyPlaylists.setBorderPainted(false);
		btnMyPlaylists.setBounds(22, 260, 223, 34);
		panel1.add(btnMyPlaylists);

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

		lblFavorite = new JLabel("Favorite Songs");
		lblFavorite.setBounds(43, 20, 181, 31);
		lblFavorite.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		panel3.add(lblFavorite);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 12));
		scrollPane.setBorder(new LineBorder(new Color(192, 192, 192)));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(43, 69, 907, 483);
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
		btnDeleteFromFavorite.setBounds(432, 20, 48, 34);
		panel3.add(btnDeleteFromFavorite);
		btnDeleteFromFavorite.setIcon(new ImageIcon(FavoriteSongs.class.getResource("/Images/trash.png")));
		btnDeleteFromFavorite.setOpaque(false);
		btnDeleteFromFavorite.setForeground(Color.BLACK);
		btnDeleteFromFavorite.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnDeleteFromFavorite.setContentAreaFilled(false);
		btnDeleteFromFavorite.setBorderPainted(false);
		btnDeleteFromFavorite.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnDeleteFromFavorite.setBackground(Color.WHITE);

		// --------------- 테이블 설계 ---------------------

		// 테이블 데이터와 컬럼 이름 준비
		columnNames = new Vector<>();
		columnNames.add("No");
		columnNames.add("Song");
		columnNames.add("Artist");

		// 현재 로그인한 사용자의 ID를 SessionManager에서 가져오기
		Integer currentUserIDX = SessionManager.getCurrentUserIDX();

		// 로그인한 사용자의 ID가 null이 아니라면, 해당 사용자의 좋아요 노래 목록 가져오기
		if (currentUserIDX != null) {
			data = musicService.getFavoriteSongs(currentUserIDX);
			table = new JTable(data, columnNames);

			// 셀 크기 줄이기
			table.getColumnModel().getColumn(0).setMaxWidth(50);

			// 셀 크기 고정
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(2).setResizable(false);

			// 헤더 이동 고정
			table.getTableHeader().setReorderingAllowed(false);

			// 전체셀 가운데 정렬
			dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);
			tcm = table.getColumnModel();
			for (int i = 0; i < tcm.getColumnCount(); i++) {
				tcm.getColumn(i).setCellRenderer(dtcr);
			}

			scrollPane.setViewportView(table);

		} else {
			// 로그인한 사용자의 ID가 null인 경우
			JOptionPane.showMessageDialog(null, "로그인 상태를 확인해주세요.");
		}

		// ----------------------------------------------------------------------

		// ===============================================

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
				deleteFromFavorieSongs();
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
				FavoriteSongsconditionSearch();
			}
		});

		// 전체조회 버튼
		btnFullList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FavoriteSongstotalSearch();
			}
		});
		
		// my playlists 버튼
		btnMyPlaylists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MyPlaylists();
			}
		});
		
		// new playlist 버튼
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

		// =========================================

		setVisible(true);
	}

	// favorite songs playlist에서 노래 삭제
	protected void deleteFromFavorieSongs() {
		int[] selectedRows = table.getSelectedRows(); // 선택된 모든 행의 인덱스 배열
		if (selectedRows.length > 0) { // 하나 이상의 행이 선택되었는지 확인
			Integer userIDX = SessionManager.getCurrentUserIDX();

			// 사용자에게 삭제 여부 한번 더 확인
			int response = JOptionPane.showConfirmDialog(null, "선택한 노래를 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);

			// 예를 선택한 경우
			if (response == JOptionPane.YES_OPTION && userIDX != null) {
				boolean success = true;
				for (int selectedRow : selectedRows) {
					int songIDX = Integer.parseInt(table.getModel().getValueAt(selectedRow, 0).toString());
					success = success && musicService.deleteFromFavoriteSongs(userIDX, songIDX);
				}

				if (success) {
					JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
					refreshFavoriteSongsTable(); // 삭제 후 테이블을 새로고침 하는 메소드
				} else {
					JOptionPane.showMessageDialog(null, "노래 삭제에 실패했습니다.");
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "삭제할 노래를 선택해주세요.");
		}
	}

	// 즐겨찾기 플레이리스트의 테이블 새로고침
	private void refreshFavoriteSongsTable() {
		Integer currentUserIDX = SessionManager.getCurrentUserIDX();
		if (currentUserIDX != null) {
			// favorite songs 플레이리스트의 노래 목록 가져오기
			Vector<Vector<Object>> newData = musicService.getFavoriteSongs(currentUserIDX);

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

	// 조건 검색 메소드
	protected void FavoriteSongsconditionSearch() {
		Integer userIDX = SessionManager.getCurrentUserIDX(); // 현재 로그인한 사용자의 idx 가져오기
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

		Vector<Vector<Object>> newData = musicDAO.getFavoriteTracksByCondition(userIDX, searchColumn,
				"%" + searchText + "%");

		if (newData.size() == 0) {
			// 검색 결과가 없는 경우
			JOptionPane.showMessageDialog(null, "검색하신 내용은 존재하지 않습니다.");
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
	protected void FavoriteSongstotalSearch() {
		// 현재 로그인한 사용자의 IDX를 SessionManager에서 가져오기
		Integer currentUserIDX = SessionManager.getCurrentUserIDX();

		if (currentUserIDX != null) {
			// 사용자 ID를 사용하여 해당 사용자의 Favorite Songs 목록 조회
			data = musicService.getFavoriteSongs(currentUserIDX);

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
	
	// 새로운 플레이리스트 만들기 메소드
	private void createNewPlaylist() {
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
