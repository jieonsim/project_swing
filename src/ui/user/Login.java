package ui.user;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import service.user.UserService;

public class Login extends JFrame {
	private JTextField txtID;
	private JPasswordField passwordField;
	private JButton btnLeft, btnLogin, btnFindToID, btnFindToPassword, btnSignUp;
	private JLabel lblID, lblPassword, lblSplit1, lblSplit2;

	public Login() {
		super("로그인");
		getContentPane().setBackground(new Color(255, 255, 255));
		setSize(1280, 720);

		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel1.setBackground(new Color(254, 85, 85));
		panel1.setBounds(0, 0, 270, 690);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		
		btnLeft = new JButton("");
		btnLeft.setIcon(new ImageIcon(Login.class.getResource("/Images/leftWhilte.png")));
		btnLeft.setHorizontalAlignment(SwingConstants.LEFT);
		btnLeft.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnLeft.setContentAreaFilled(false);
		btnLeft.setBorderPainted(false);
		btnLeft.setBounds(22, 30, 236, 43);
		panel1.add(btnLeft);

		JPanel panel2 = new JPanel();
		panel2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel2.setBackground(new Color(255, 255, 255));
		panel2.setBounds(269, 0, 1007, 690);
		getContentPane().add(panel2);
		panel2.setLayout(null);

		JLabel lblMusicLogo = new JLabel("");
		lblMusicLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusicLogo.setIcon(new ImageIcon(Login.class.getResource("/Images/musicLogo3BlackVer.png")));
		lblMusicLogo.setBounds(449, 54, 110, 82);
		panel2.add(lblMusicLogo);

		txtID = new JTextField();
		txtID.setHorizontalAlignment(SwingConstants.CENTER);
		txtID.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 15));
		txtID.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		txtID.setBounds(344, 171, 340, 63);
		panel2.add(txtID);
		txtID.setColumns(10);

		btnLogin = new JButton("로그인");
		btnLogin.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		btnLogin.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		btnLogin.setBackground(new Color(232, 232, 232));
		btnLogin.setBounds(398, 419, 211, 51);
		panel2.add(btnLogin);

		btnFindToID = new JButton("아이디 찾기");
		btnFindToID.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		btnFindToID.setContentAreaFilled(false);
		btnFindToID.setBorderPainted(false);
		btnFindToID.setBounds(354, 354, 98, 23);
		panel2.add(btnFindToID);

		btnFindToPassword = new JButton("비밀번호 찾기");
		btnFindToPassword.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		btnFindToPassword.setContentAreaFilled(false);
		btnFindToPassword.setBorderPainted(false);
		btnFindToPassword.setBounds(459, 354, 110, 23);
		panel2.add(btnFindToPassword);

		btnSignUp = new JButton("회원가입");
		btnSignUp.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorderPainted(false);
		btnSignUp.setBounds(581, 354, 88, 23);
		panel2.add(btnSignUp);

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		passwordField.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 15));
		passwordField.setBounds(344, 271, 340, 63);
		panel2.add(passwordField);

		lblPassword = new JLabel("비밀번호");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 17));
		lblPassword.setBounds(252, 276, 80, 51);
		panel2.add(lblPassword);

		lblID = new JLabel("아이디");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 17));
		lblID.setBounds(252, 176, 80, 51);
		panel2.add(lblID);

		lblSplit1 = new JLabel("|");
		lblSplit1.setBounds(450, 359, 17, 15);
		panel2.add(lblSplit1);

		lblSplit2 = new JLabel("|");
		lblSplit2.setBounds(568, 359, 17, 15);
		panel2.add(lblSplit2);

		setVisible(true);
		
		// 홈화면 돌아가기 버튼
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home1();
			}
		});

		// 아이디 찾기 버튼
		btnFindToID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FindToID();
			}
		});

		// 비밀번호 찾기 버튼
		btnFindToPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FindToPassword();
			}
		});

		// 회원가입 버튼
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SignUp();
			}
		});

		// 로그인 버튼 마우스 클릭 처리
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userID = txtID.getText(); // 사용자 이름 입력 필드
				String password = new String(passwordField.getPassword()); // 비밀번호 입력 필드

				UserService userService = new UserService();
				if (userService.login(userID, password)) {
//		            JOptionPane.showMessageDialog(Login.this, "로그인 성공"); < 로그인 성공 시에도 메시지를 띄울지 아니면 그냥 메시지없이 메인 페이지로 넘어갈지 고민중
					dispose(); // 로그인 성공 시 로그인 창 닫기
					new Home2();
				} else {
					JOptionPane.showMessageDialog(Login.this, "아이디 또는 비밀번호를 확인하세요.", "로그인 실패",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}