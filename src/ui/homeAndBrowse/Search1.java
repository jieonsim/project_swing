package ui.homeAndBrowse;

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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class Search1 extends JFrame {
	private JLabel lblMusicLogo, lblSearch;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnHome, btnLogin, btnBrowse, btnSearch, btnExit;
	private JTextField textField;
	private JButton btnCondition;
	private JButton btnFullList;

	public Search1() {
		super("Search");
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
		
		lblMusicLogo = new JLabel(" Music");
		lblMusicLogo.setIcon(new ImageIcon(Home1.class.getResource("/Images/musicLogo3BlackVer.png")));
		lblMusicLogo.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 30));
		lblMusicLogo.setBounds(22, 10, 158, 64);
		panel1.add(lblMusicLogo);

		btnHome = new JButton("  Home");
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnHome.setIcon(new ImageIcon(Home1.class.getResource("/Images/homelogo.png")));
		btnHome.setBounds(22, 84, 223, 34);
		panel1.add(btnHome);
		
		btnBrowse = new JButton("  Browse");
		btnBrowse.setIcon(new ImageIcon(Search1.class.getResource("/Images/browse.png")));
		btnBrowse.setHorizontalAlignment(SwingConstants.LEFT);
		btnBrowse.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnBrowse.setContentAreaFilled(false);
		btnBrowse.setBorderPainted(false);
		btnBrowse.setBounds(22, 128, 223, 34);
		panel1.add(btnBrowse);
		
		btnSearch = new JButton("  Search");
		btnSearch.setIcon(new ImageIcon(Search1.class.getResource("/Images/search.png")));
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setBounds(22, 172, 223, 34);
		panel1.add(btnSearch);
		
		btnExit = new JButton("  Exit");
		btnExit.setIcon(new ImageIcon(Home2.class.getResource("/Images/exit.png")));
		btnExit.setHorizontalAlignment(SwingConstants.LEFT);
		btnExit.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setBounds(22, 600, 223, 34);
		panel1.add(btnExit);

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
		btnLogin.setIcon(new ImageIcon(Browse1.class.getResource("/Images/user1WhiteVer.png")));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBounds(836, 21, 141, 34);
		panel2.add(btnLogin);

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
		scrollPane.setBorder(new LineBorder(new Color(192, 192, 192)));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(43, 69, 907, 483);
		panel3.add(scrollPane);
		
		// --------------- 테이블 설계 ---------------------
		
		Vector<String> columnNames = new Vector<>();
		columnNames.add("Song");
		columnNames.add("Artist");
		columnNames.add("Album");
		columnNames.add("Release date");
		
		MusicService musicService = new MusicService();
		Vector<Vector<Object>> data = musicService.getAllTracksForTable();
		
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"선택하세요", "노래 제목", "아티스트 이름", "앨범명"}));
		comboBox.setBounds(492, 21, 120, 35);
		panel3.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(624, 22, 120, 35);
		panel3.add(textField);
		textField.setColumns(10);
		
		btnCondition = new JButton("검색");
		btnCondition.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		btnCondition.setBackground(new Color(232, 232, 232));
		btnCondition.setBounds(756, 24, 91, 31);
		panel3.add(btnCondition);
		
		btnFullList = new JButton("전체조회");
		btnFullList.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		btnFullList.setBackground(new Color(232, 232, 232));
		btnFullList.setBounds(859, 24, 91, 31);
		panel3.add(btnFullList);
		
		// 셀 크기 고정
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		
		// 헤더 이동 고정
		table.getTableHeader().setReorderingAllowed(false);
		
		// 전체셀 가운데 정렬
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}

		// 홈버튼 클릭
		btnHome.addActionListener(new ActionListener() {
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
		
		// 브라우즈 버튼
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Browse1();
			}
		});
		
		// 서치 버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Search1();
			}
		});
		
		// 검색 버튼
		btnCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		// 로그인 버튼
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login();
			}
		});
		
//===================================================
		
		setVisible(true);
	}
}
