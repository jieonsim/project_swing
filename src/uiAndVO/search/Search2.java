package uiAndVO.search;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import serviceAndDao.MusicDAO;
import serviceAndDao.MusicService;
import uiAndVO.browse.Browse2;
import uiAndVO.browse.Pop1;
import uiAndVO.home.Home1;
import uiAndVO.home.Home2;
import uiAndVO.playlists.FavoriteSongs;
import uiAndVO.playlists.MyPlaylists;
import util.SessionManager;

public class Search2 extends JFrame {
	private JButton btnHome, btnLogout, btnArtists, btnAlbums, btnSongs, btnMyPlaylists, btnFavoriteSongs,
			btnNewPlaylist, btnAddToMyPlaylist, btnAddToFavoriteSongs, btnExit, btnBrowse, btnCondition, btnFullList, btnSearch;
	private JLabel lblPlaylists, lblSearch;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField txtCondition;
	private JComboBox cbCondition;
	private DefaultTableModel dtm;
	private Vector<Vector<Object>> data;
	private Vector<String> columnNames;
	private DefaultTableCellRenderer dtcr;
	private TableColumnModel tcm;

	MusicDAO musicDAO = new MusicDAO();
	MusicService musicService = new MusicService();

	public Search2() {
		super("Swing music");
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
		btnBrowse.setIcon(new ImageIcon(Search2.class.getResource("/Images/browse.png")));
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

		btnMyPlaylists = new JButton("  My Playlists");
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

		JButton btnSearch = new JButton("  Search");
		btnSearch.setIcon(new ImageIcon(Search2.class.getResource("/Images/search.png")));
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

		lblSearch = new JLabel("Search");
		lblSearch.setBounds(43, 20, 120, 31);
		lblSearch.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		panel3.add(lblSearch);

		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 12));
		scrollPane.setBorder(new LineBorder(new Color(192, 192, 192)));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(43, 69, 907, 483);
		panel3.add(scrollPane);

		cbCondition = new JComboBox();
		cbCondition.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		cbCondition.setModel(new DefaultComboBoxModel(new String[] { "선택하세요", "노래 제목", "아티스트 이름", "앨범명", "발매일" }));
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

		btnAddToFavoriteSongs = new JButton("");
		btnAddToFavoriteSongs.setBounds(378, 17, 48, 34);
		panel3.add(btnAddToFavoriteSongs);
		btnAddToFavoriteSongs.setIcon(new ImageIcon(Pop1.class.getResource("/Images/favoriteSongsHeartVer.png")));
		btnAddToFavoriteSongs.setOpaque(false);
		btnAddToFavoriteSongs.setForeground(Color.BLACK);
		btnAddToFavoriteSongs.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnAddToFavoriteSongs.setContentAreaFilled(false);
		btnAddToFavoriteSongs.setBorderPainted(false);
		btnAddToFavoriteSongs.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAddToFavoriteSongs.setBackground(Color.WHITE);

		btnAddToMyPlaylist = new JButton("");
		btnAddToMyPlaylist.setBounds(420, 20, 48, 34);
		panel3.add(btnAddToMyPlaylist);
		btnAddToMyPlaylist.setIcon(new ImageIcon(Pop1.class.getResource("/Images/addToPlaylist.png")));
		btnAddToMyPlaylist.setOpaque(false);
		btnAddToMyPlaylist.setForeground(Color.BLACK);
		btnAddToMyPlaylist.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnAddToMyPlaylist.setContentAreaFilled(false);
		btnAddToMyPlaylist.setBorderPainted(false);
		btnAddToMyPlaylist.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAddToMyPlaylist.setBackground(Color.WHITE);

		// --------------- 테이블 설계 ---------------------

		columnNames = new Vector<>();
		columnNames.add("No");
		columnNames.add("Song");
		columnNames.add("Artist");
		columnNames.add("Album");
		columnNames.add("Release date");

		data = musicService.getAllTracks();

		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);

		// 셀 크기 줄이기
		table.getColumnModel().getColumn(0).setMaxWidth(50);

		// 셀 크기 고정
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);

		// 헤더 이동 고정
		table.getTableHeader().setReorderingAllowed(false);

		// 전체셀 가운데 정렬
		dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}

		// ----------------------------------------------------------------------

		// home
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home2();
			}
		});

		// logout
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home1();
			}
		});

		// browse
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

		// exit
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// 검색 마우스
		btnCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conditionSearch();
			}
		});

		// 검색 키보드
		btnCondition.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				conditionSearch();
			}
		});

		// 전체조회 마우스
		btnFullList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalSearch();
			}
		});

		// 전체조회 키보드
		btnFullList.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				totalSearch();
			}
		});

		// favorite songs에 트랙 추가
		btnAddToFavoriteSongs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSelectedTracksToFavoriteSongs();
			}
		});

		// favorite songs
		btnFavoriteSongs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FavoriteSongs();
			}
		});
		
		// new playlists
		btnNewPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createNewPlaylist();
			}
		});
		
		// all playlist
		btnMyPlaylists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MyPlaylists();
			}
		});
		
		// myplaylist에 트랙 추가
		btnAddToMyPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSelectedTracksToUserPlaylist();
			}
		});

//============================================

		setVisible(true);
	}

//===============================================================

	// 새로운 플레이리스트 만들기 메소드
	private void createNewPlaylist() {
		// 사용자 입력을 통해 플레이리스트 이름을 받아옴
        String playlistName = JOptionPane.showInputDialog("플레이리스트 제목을 입력하세요.");
        if (playlistName != null && !playlistName.trim().isEmpty()) {
            // Service를 통해 플레이리스트 생성 요청
            if (musicService.createNewPlaylist(SessionManager.getCurrentUserIDX(), playlistName)) {
                JOptionPane.showMessageDialog(null, "새 플레이리스트가 생성되었습니다.");
            } else {
                JOptionPane.showMessageDialog(null, "플레이리스트 생성에 실패했습니다. 이미 플레이리스트가 존재하거나, 다른 오류가 발생했습니다.");
            }
        }
	}
	
	
	// favorite songs에 트랙 추가
	private void addSelectedTracksToFavoriteSongs() {
		// 선택된 모든 행을 추가하기 위해 배열 사용
		int[] selectedRows = table.getSelectedRows(); // 선택된 모든 행의 인덱스
		Integer userIDX = SessionManager.getCurrentUserIDX(); // 현재 로그인한 사용자 IDX

		if (selectedRows.length > 0) {
			if (userIDX != null) {
				MusicService musicService = new MusicService();
				boolean success = true;
				// 선택된 모든 노래들이 성공적으로 추가되었는지를 확인하기 위해 success 변수를 사용
				for (int row : selectedRows) {
					int songIDX = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
					success = success && musicService.addToFavoriteSongs(userIDX, songIDX);
				}

				if (success) {
					JOptionPane.showMessageDialog(null, "선택한 노래가 즐겨찾기에 추가되었습니다.");
				} else {
					JOptionPane.showMessageDialog(null, "즐겨찾기 노래 추가에 실패했습니다.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "로그인 상태를 확인해주세요.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "즐겨찾기에 추가할 노래를 선택해주세요.");
		}
	}
	
	// myplaylist에 트랙 추가
	private void addSelectedTracksToUserPlaylist() {
	    // 선택된 모든 행을 추가하기 위해 배열 사용
	    int[] selectedRows = table.getSelectedRows();
	    // 현재 로그인한 사용자 IDX 가져오기
	    Integer userIDX = SessionManager.getCurrentUserIDX();

	    if (selectedRows.length == 0) {
	        JOptionPane.showMessageDialog(null, "플레이리스트에 추가할 노래를 선택해주세요.");
	        return;
	    }

	    if (userIDX == null) {
	        JOptionPane.showMessageDialog(null, "로그인 상태를 확인해주세요.");
	        return;
	    }

	    boolean success = true;
	    // 선택된 모든 노래들이 성공적으로 추가되었는지를 확인하기 위해 success 변수를 사용
	    for (int row : selectedRows) {
	        int songIDX = Integer.parseInt(table.getValueAt(row, 0).toString()); // 첫 번째 열에 songIDX 저장
	        success &= musicService.addTrackToUserPlaylist(userIDX, songIDX);
	    }

	    if (success) {
	        JOptionPane.showMessageDialog(null, "선택한 노래가 플레이리스트에 추가되었습니다.");
	    } else {
	        JOptionPane.showMessageDialog(null, "노래 추가에 실패했습니다. 플레이리스트를 먼저 생성해주세요.");
	    }
	}


	// 조건 검색 메소드
	private void conditionSearch() {
		String selectedCondition = cbCondition.getSelectedItem().toString();
		String searchText = txtCondition.getText();

		if (searchText.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요.");
			txtCondition.requestFocus();
			return;
		}

		String searchColumn = "";
		if (selectedCondition.equals("노래 제목")) {
			searchColumn = "s.songName";
		} else if (selectedCondition.equals("아티스트 이름")) {
			searchColumn = "a.artistName";
		} else if (selectedCondition.equals("앨범명")) {
			searchColumn = "al.albumName";
		} else if (selectedCondition.equals("발매일")) {
			searchColumn = "al.releaseDate";
		} else {
			JOptionPane.showMessageDialog(null, "올바른 검색 조건을 선택하세요.");
			return;
		}

		Vector<Vector<Object>> newData = musicDAO.getTracksByCondition(searchColumn, "%" + searchText + "%");

		if (newData.size() == 0) {
			// 검색 결과가 없는 경우
			JOptionPane.showMessageDialog(null, "검색하신 내용은 존재하지 않습니다.");
		} else {
			// 테이블 모델 업데이트
			dtm = (DefaultTableModel) table.getModel();
			dtm.setDataVector(newData, columnNames);
			table.setModel(dtm);
			// 테이블 셀 크기 조절, 크기 고정, 헤더 이동 고정
			table.getColumnModel().getColumn(0).setMaxWidth(50);
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(2).setResizable(false);
			table.getTableHeader().setReorderingAllowed(false);
			// 전체 셀 중앙 정렬
			dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);
			tcm = table.getColumnModel();
			for (int i = 0; i < tcm.getColumnCount(); i++) {
				tcm.getColumn(i).setCellRenderer(dtcr);
			}
		}
	}

	// 전체 검색
	protected void totalSearch() {
		data = musicService.getAllTracks();

		dtm = (DefaultTableModel) table.getModel();
		dtm.setDataVector(data, columnNames);

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
	}
}
