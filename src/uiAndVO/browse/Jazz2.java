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
import javax.swing.JOptionPane;
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
import uiAndVO.library.Albums;
import uiAndVO.library.Artists;
import uiAndVO.library.Songs;
import uiAndVO.playlists.FavoriteSongs;
import uiAndVO.playlists.MyPlaylists;
import uiAndVO.search.Search2;
import util.SessionManager;

public class Jazz2 extends JFrame {
	private JButton btnHome, btnLogout, btnArtists, btnAlbums, btnSongs, btnMyPlaylists, btnFavoriteSongs,
			btnNewPlaylist, btnExit, btnBrowse, btnSearch, btnAddToMyPlaylist, btnAddToFavoriteSongs;
	private JLabel lblPlaylists, lblAllTracks, lblEssentialAlbums, lblNewReleaseArtistName2, lblNewReleaseAlbumName3,
			lblNewReleaseArtistName3, lblEssentialAlbum2, lblEssentialAlbumName2, lblEssentialAlbumArtistName2,
			lblEssentialAlbum3, lblEssentialAlbumName3, lblEssentialAlbumArtistName3;
	private JTable table;
	private DefaultTableCellRenderer dtcr;
	private TableColumnModel tcm;

	MusicService musicService = new MusicService();
	
	public Jazz2() {
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

		btnMyPlaylists = new JButton("  My Playlits");
		btnMyPlaylists.setIcon(new ImageIcon(Home2.class.getResource("/Images/allPlaylists.png")));
		btnMyPlaylists.setHorizontalAlignment(SwingConstants.LEFT);
		btnMyPlaylists.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnMyPlaylists.setContentAreaFilled(false);
		btnMyPlaylists.setBorderPainted(false);
		btnMyPlaylists.setBounds(22, 445, 223, 34);
		panel1.add(btnMyPlaylists);

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

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(255, 255, 255));
		panel3.setBounds(270, 76, 1006, 610);
		getContentPane().add(panel3);
		panel3.setLayout(null);

		lblAllTracks = new JLabel("Pop All Tracks > ");
		lblAllTracks.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 15));
		lblAllTracks.setBounds(44, 51, 131, 27);
		panel3.add(lblAllTracks);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 88, 480, 473);
		panel3.add(scrollPane);

		JLabel lblNewReleases = new JLabel("New Releases > ");
		lblNewReleases.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 15));
		lblNewReleases.setBounds(557, 55, 156, 27);
		panel3.add(lblNewReleases);

		JLabel lblNewReleases2 = new JLabel("");
		lblNewReleases2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewReleases2.setBounds(558, 88, 170, 152);
		panel3.add(lblNewReleases2);

		JLabel lblNewReleases3 = new JLabel("");
		lblNewReleases3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewReleases3.setBounds(777, 88, 170, 152);
		panel3.add(lblNewReleases3);
		
		btnAddToMyPlaylist = new JButton("");
		btnAddToMyPlaylist.setIcon(new ImageIcon(Pop1.class.getResource("/Images/addToPlaylist.png")));
		btnAddToMyPlaylist.setOpaque(false);
		btnAddToMyPlaylist.setForeground(Color.BLACK);
		btnAddToMyPlaylist.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnAddToMyPlaylist.setContentAreaFilled(false);
		btnAddToMyPlaylist.setBorderPainted(false);
		btnAddToMyPlaylist.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAddToMyPlaylist.setBackground(Color.WHITE);
		btnAddToMyPlaylist.setBounds(475, 44, 48, 34);
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
		btnAddToFavoriteSongs.setBounds(435, 40, 48, 34);
		panel3.add(btnAddToFavoriteSongs);

		lblEssentialAlbums = new JLabel("Essential Albums  >");
		lblEssentialAlbums.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 15));
		lblEssentialAlbums.setBounds(557, 326, 169, 27);
		panel3.add(lblEssentialAlbums);

		JLabel lblNewReleaseAlbumName2 = new JLabel("Album name");
		lblNewReleaseAlbumName2.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseAlbumName2.setBounds(559, 250, 169, 27);
		panel3.add(lblNewReleaseAlbumName2);

		lblNewReleaseArtistName2 = new JLabel("Artist name");
		lblNewReleaseArtistName2.setForeground(Color.GRAY);
		lblNewReleaseArtistName2.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseArtistName2.setBounds(559, 270, 169, 27);
		panel3.add(lblNewReleaseArtistName2);

		lblNewReleaseAlbumName3 = new JLabel("Album name");
		lblNewReleaseAlbumName3.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseAlbumName3.setBounds(778, 250, 169, 27);
		panel3.add(lblNewReleaseAlbumName3);

		lblNewReleaseArtistName3 = new JLabel("Artist name");
		lblNewReleaseArtistName3.setForeground(Color.GRAY);
		lblNewReleaseArtistName3.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblNewReleaseArtistName3.setBounds(778, 270, 169, 27);
		panel3.add(lblNewReleaseArtistName3);

		lblEssentialAlbum2 = new JLabel("");
		lblEssentialAlbum2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEssentialAlbum2.setBounds(558, 359, 170, 152);
		panel3.add(lblEssentialAlbum2);

		lblEssentialAlbumName2 = new JLabel("Album name");
		lblEssentialAlbumName2.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumName2.setBounds(559, 521, 169, 27);
		panel3.add(lblEssentialAlbumName2);

		lblEssentialAlbumArtistName2 = new JLabel("Artist name");
		lblEssentialAlbumArtistName2.setForeground(Color.GRAY);
		lblEssentialAlbumArtistName2.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumArtistName2.setBounds(559, 541, 169, 27);
		panel3.add(lblEssentialAlbumArtistName2);

		lblEssentialAlbum3 = new JLabel("");
		lblEssentialAlbum3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEssentialAlbum3.setBounds(777, 359, 170, 152);
		panel3.add(lblEssentialAlbum3);

		lblEssentialAlbumName3 = new JLabel("Album name");
		lblEssentialAlbumName3.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumName3.setBounds(778, 521, 169, 27);
		panel3.add(lblEssentialAlbumName3);

		lblEssentialAlbumArtistName3 = new JLabel("Artist name");
		lblEssentialAlbumArtistName3.setForeground(Color.GRAY);
		lblEssentialAlbumArtistName3.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 14));
		lblEssentialAlbumArtistName3.setBounds(778, 541, 169, 27);
		panel3.add(lblEssentialAlbumArtistName3);
		
		// ------------ 테이블 설계 ---------------

		Vector<String> columnNames = new Vector<>();
		columnNames.add("No");
		columnNames.add("song");
		columnNames.add("artist");
		columnNames.add("album");

		Vector<Vector<Object>> data = musicService.getTracksByGenres("jazz");

		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);

		// 0번째 열(songIDX) 크기 줄이기
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		// 테이블 헤더 고정
		table.getTableHeader().setReorderingAllowed(false);
		// 전체 셀 가운데 정렬
		dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}

		// -----------------------------------------------------

//===============================================================================

		// home 버튼
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home2();
			}
		});

		// artist 버튼
		btnArtists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Artists();
			}
		});

		// logout 버튼
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

		// favorite songs 버튼
		btnFavoriteSongs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FavoriteSongs();
			}
		});
		
		// favorite songs에 트랙 추가 버튼
		btnAddToFavoriteSongs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSelectedTracksToFavoriteSongs();
			}
		});
		
		// my playlist에 추가 버튼
		btnAddToMyPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSelectedTracksToUserPlaylist();
			}
		});
		
		// myplaylists 버튼
		btnMyPlaylists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MyPlaylists();
			}
		});
		
		// new playlists 버튼
		btnNewPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createNewPlaylist();
			}
		});
		
		// songs
		btnSongs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Songs();
			}
		});
		
		// albums
		btnAlbums.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Albums();
			}
		});

//===========================================================================

		setVisible(true);
	}
	
//===========================================================================
	
	// 내 플레이리스트에 트랙 추가
	// myplaylist에 트랙 추가
	private void addSelectedTracksToUserPlaylist() {
	    // 선택된 모든 행을 추가하기 위해 배열 사용
	    int[] selectedRows = table.getSelectedRows();
	    // 현재 로그인한 사용자 ID 가져오기
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
	        JOptionPane.showMessageDialog(null, "플레이리스트 노래 추가에 실패했습니다. 플레이리스트를 먼저 생성해주세요.");
	    }
	}

	
	// 즐겨찾기에 트랙 추가
	private void addSelectedTracksToFavoriteSongs() {
		// 선택된 모든 행을 추가하기 위해 배열 사용
		int[] selectedRows = table.getSelectedRows();
		// 현재 로그인한 사용자 ID 가져오기
		Integer userIDX = SessionManager.getCurrentUserIDX();

		if (selectedRows.length > 0) {
			if (userIDX != null) {
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
	
	// 새로운 플레이리스트 만들기
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
