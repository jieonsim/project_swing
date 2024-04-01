package uiAndVO.home;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import serviceAndDao.MusicService;
import serviceAndDao.UserDAO;
import uiAndVO.browse.Browse2;
import uiAndVO.library.Albums;
import uiAndVO.library.Artists;
import uiAndVO.playlists.FavoriteSongs;
import uiAndVO.playlists.MyPlaylists;
import uiAndVO.search.Search2;
import util.SessionManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Home2 extends JFrame {
	private JButton btnHome, btnLogout, btnArtists, btnAlbums, btnSongs, btnMyPlaylists, btnFavoriteSongs,
			btnNewPlaylist, btnExit, btnBrowse, btnSearch;
	private JLabel lblPlaylists, lblWelcome1, lblWelcome2;

	MusicService musicService = new MusicService();
	private JLabel lblquote;
	
	public Home2() {
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

		btnBrowse = new JButton("  Browse");
		btnBrowse.setIcon(new ImageIcon(Home2.class.getResource("/Images/browse.png")));
		btnBrowse.setHorizontalAlignment(SwingConstants.LEFT);
		btnBrowse.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnBrowse.setContentAreaFilled(false);
		btnBrowse.setBorderPainted(false);
		btnBrowse.setBounds(22, 128, 223, 34);
		panel1.add(btnBrowse);

		btnSearch = new JButton("  Search");
		btnSearch.setIcon(new ImageIcon(Home2.class.getResource("/Images/search.png")));
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

		lblWelcome1 = new JLabel("");
		lblWelcome1.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome1.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 50));
		lblWelcome1.setBounds(181, 128, 601, 94);
		// 환영 문구 사용자 이름 업데이트
		updateWelcomeMessage();
		panel3.add(lblWelcome1);

		lblWelcome2 = new JLabel("스윙뮤직이 당신의 하루에 멜로디를 더해드릴게요.");
		lblWelcome2.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome2.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		lblWelcome2.setBounds(265, 232, 434, 49);
		panel3.add(lblWelcome2);
		
		lblquote = new JLabel("New label");
		lblquote.setForeground(new Color(128, 128, 128));
		lblquote.setHorizontalAlignment(SwingConstants.CENTER);
		lblquote.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 15));
		lblquote.setBounds(173, 353, 617, 49);
		String quote = getRandomMusicQuote();
		lblquote.setText(quote);
		panel3.add(lblquote);
		
		// ----------------------------------------------------------

		// home 마우스
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home2();
			}
		});

		// home 키보드
		btnHome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new Home2();
			}
		});

		// browse 마우스
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Browse2();
			}
		});

		// browse 키보드
		btnBrowse.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new Browse2();
			}
		});

		// search 마우스
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Search2();
			}
		});

		// search 키보드
		btnSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new Search2();
			}
		});

		// all playlists 마우스
		btnMyPlaylists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MyPlaylists();
			}
		});

		// all playlists 키보드
		btnMyPlaylists.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new MyPlaylists();
			}
		});

		// favorite songs 마우스
		btnFavoriteSongs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FavoriteSongs();
			}
		});

		// favorite songs 키보드
		btnFavoriteSongs.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new FavoriteSongs();
			}
		});

		// new playlist 마우스
		btnNewPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createNewPlaylist();
			}
		});

		// new playlist 키보드
		btnNewPlaylist.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				createNewPlaylist();
			}
		});

		// exit 마우스
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// exit 키보드
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.exit(0);
			}
		});

		// logout 마우스
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home1();
			}
		});

		// logout 키보드
		btnLogout.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new Home1();
			}
		});

		// artists 마우스
		btnArtists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Artists();
			}
		});

		// album
		btnAlbums.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Albums();
			}
		});

		setVisible(true);
	}

	// -----------------------------------------

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

	// 홈화면 환영 문구 메소드
	private void updateWelcomeMessage() {
		// session manager 에서 현재 로그인한 사용자 idx 가져오기
		int currentUserIDX = SessionManager.getCurrentUserIDX();
		// userDAO통해 사용자 이름 조회
		UserDAO userDAO = new UserDAO();
		String userName = userDAO.getUserNameByIDX(currentUserIDX);
		// textlabel에 환영 메시지 설정
		if (userName != null) {
			lblWelcome1.setText("환영합니다, " + userName + "님!");
		}
	}
	
	// 랜덤 명언 출력
	private static String getRandomMusicQuote() {
        ArrayList<String> quotes = new ArrayList<>();
        quotes.add("음악은 침묵의 잔을 채우는 와인이다. - 로버트 프립 -");
        quotes.add("음악은 인류가 만든 가장 완벽한 예술이다. - 자크 바락 -");
        quotes.add("음악은 영혼을 우주로, 날개를 상상력으로, 마음을 자유로 이끈다. - 플라톤 -");
        quotes.add("음악은 가장 강력한 예술이자 치유의 힘을 지닌다. - 마리아 바이드 -");
        quotes.add("음악은 세계를 바꿀 수 있는 힘을 가지고 있다. - 루더 반 베토벤 -");
        quotes.add("음악은 우리가 말로 표현할 수 없는 감정을 전달하는 방법이다. - 리오나르도 다 빈치 -");
        quotes.add("음악은 우리의 생각을 확장시키고 우리를 더 깊이 생각하게 한다. - 피터 새거드 -");
        quotes.add("음악은 우리의 마음을 깊이 탐구하는 수단이다. - 헨리 데이비드 소로 -");

        Random random = new Random();
        int index = random.nextInt(quotes.size());

        return quotes.get(index);
    }
}
