package uiAndVO.home;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import serviceAndDao.*;

public class FindToID extends JFrame {
	private JTextField txtName;
	private JButton btnFindToID, btnFindToPassword, btnTryToLogin, btnLeft;
	private JLabel lblName, lblPhoneNumber, lblSplit1, lblSplit2;
	private JTextField txtPhoneNumber;
	private JButton btnSignUp;

	public FindToID() {
		super("Swing Music");
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
		btnLeft.setIcon(new ImageIcon(FindToID.class.getResource("/Images/leftWhilte.png")));
		btnLeft.setHorizontalAlignment(SwingConstants.LEFT);
		btnLeft.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 20));
		btnLeft.setContentAreaFilled(false);
		btnLeft.setBorderPainted(false);
		btnLeft.setBounds(22, 30, 236, 43);
		panel1.add(btnLeft);

		JPanel panel2 = new JPanel();
		panel2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel2.setBackground(new Color(255, 255, 255));
		panel2.setBounds(259, 0, 1007, 690);
		getContentPane().add(panel2);
		panel2.setLayout(null);

		JLabel lblMusicLogo = new JLabel("");
		lblMusicLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusicLogo.setIcon(new ImageIcon(Login.class.getResource("/Images/musicLogo3BlackVer.png")));
		lblMusicLogo.setBounds(447, 50, 110, 82);
		panel2.add(lblMusicLogo);

		txtName = new JTextField();
		txtName.setSelectionColor(new Color(226, 226, 226));
		txtName.setForeground(new Color(0, 0, 0));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 17));
		txtName.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		txtName.setBounds(333, 186, 340, 63);
		panel2.add(txtName);
		txtName.setColumns(10);

		btnFindToID = new JButton("아이디 찾기");
		btnFindToID.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		btnFindToID.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 17));
		btnFindToID.setBackground(new Color(232, 232, 232));
		btnFindToID.setBounds(391, 441, 211, 51);
		panel2.add(btnFindToID);

		btnFindToPassword = new JButton("비밀번호 찾기");
		btnFindToPassword.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		btnFindToPassword.setContentAreaFilled(false);
		btnFindToPassword.setBorderPainted(false);
		btnFindToPassword.setBounds(327, 361, 110, 23);
		panel2.add(btnFindToPassword);

		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 17));
		lblName.setBounds(244, 191, 80, 51);
		panel2.add(lblName);

		lblPhoneNumber = new JLabel("전화번호");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNumber.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 17));
		lblPhoneNumber.setBounds(244, 276, 80, 51);
		panel2.add(lblPhoneNumber);

		btnTryToLogin = new JButton("로그인");
		btnTryToLogin.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		btnTryToLogin.setContentAreaFilled(false);
		btnTryToLogin.setBorderPainted(false);
		btnTryToLogin.setBounds(449, 361, 97, 23);
		panel2.add(btnTryToLogin);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setToolTipText("숫자만 입력하세요.");
		txtPhoneNumber.setSelectionColor(new Color(226, 226, 226));
		txtPhoneNumber.setForeground(new Color(0, 0, 0));
		txtPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhoneNumber.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 17));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		txtPhoneNumber.setBounds(333, 276, 340, 63);
		panel2.add(txtPhoneNumber);

		lblSplit1 = new JLabel("|");
		lblSplit1.setBounds(441, 366, 17, 15);
		panel2.add(lblSplit1);

		btnSignUp = new JButton("회원가입");
		btnSignUp.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorderPainted(false);
		btnSignUp.setBounds(562, 361, 88, 23);
		panel2.add(btnSignUp);

		lblSplit2 = new JLabel("|");
		lblSplit2.setBounds(541, 365, 17, 15);
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
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = txtName.getText(); // 사용자 이름 입력 필드
				String phoneNumber = txtPhoneNumber.getText(); // 휴대폰 번호 입력 필드

				UserService userService = new UserService();
				String foundUserId = userService.findUserId(userName, phoneNumber);

				if (foundUserId != null) {
					JOptionPane.showMessageDialog(null, "고객님의 정보와 일치하는 아이디는 " + foundUserId + " 입니다.");
					dispose();
					new Login();
				} else {
					JOptionPane.showMessageDialog(null, "입력하신 정보와 일치하는 아이디가 없습니다.", "아이디 찾기 실패",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// 비밀번호 찾기
		btnFindToPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FindToPassword();
			}
		});

		// 로그인 버튼
		btnTryToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login().setVisible(true);
			}
		});
		
		// 회원가입 버튼
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SignUp();
			}
		});

	}
}
