package ui.homeAndBrowse;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import serviceAndDao.*;

public class SignUp extends JFrame {
	private JTextField txtName;
	private JLabel lblID, lblName, lblPhoneNumber, lblIPassword, lblSplit1, lblSplit2;
	private JTextField txtID, txtPhoneNumber;
	private JButton btnSignUp, btnFindToID, btnFindToPassword, btnTryToLogin, btnLeft;
	private JPasswordField passwordField;

	public SignUp() {
		super("회원가입");
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
		btnLeft.setIcon(new ImageIcon(SignUp.class.getResource("/Images/leftWhilte.png")));
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

		lblSplit1 = new JLabel("|");
		lblSplit1.setBounds(534, 444, 17, 15);
		panel2.add(lblSplit1);

		lblSplit2 = new JLabel("|");
		lblSplit2.setBounds(439, 444, 17, 15);
		panel2.add(lblSplit2);

		btnTryToLogin = new JButton("로그인");
		btnTryToLogin.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		btnTryToLogin.setContentAreaFilled(false);
		btnTryToLogin.setBorderPainted(false);
		btnTryToLogin.setBounds(444, 439, 97, 23);
		panel2.add(btnTryToLogin);


		btnFindToPassword = new JButton("비밀번호 찾기");
		btnFindToPassword.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		btnFindToPassword.setContentAreaFilled(false);
		btnFindToPassword.setBorderPainted(false);
		btnFindToPassword.setBounds(553, 439, 97, 23);
		panel2.add(btnFindToPassword);

		btnFindToID = new JButton("아이디 찾기");
		btnFindToID.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		btnFindToID.setContentAreaFilled(false);
		btnFindToID.setBorderPainted(false);
		btnFindToID.setBounds(337, 439, 90, 23);
		panel2.add(btnFindToID);

		JLabel lblMusicLogo = new JLabel("");
		lblMusicLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusicLogo.setIcon(new ImageIcon(Login.class.getResource("/Images/musicLogo3BlackVer.png")));
		lblMusicLogo.setBounds(447, 50, 110, 82);
		panel2.add(lblMusicLogo);

		txtName = new JTextField();
		txtName.setToolTipText("한글,영문만 가능");
		txtName.setSelectionColor(new Color(226, 226, 226));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 17));
		txtName.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		txtName.setBounds(333, 288, 340, 63);
		panel2.add(txtName);
		txtName.setColumns(10);

		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 17));
		lblName.setBounds(242, 293, 80, 51);
		panel2.add(lblName);

		lblPhoneNumber = new JLabel("전화번호");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNumber.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 17));
		lblPhoneNumber.setBounds(242, 366, 80, 51);
		panel2.add(lblPhoneNumber);

		lblID = new JLabel("아이디");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 17));
		lblID.setBounds(242, 147, 80, 51);
		panel2.add(lblID);

		txtID = new JTextField();
		txtID.setSelectionColor(new Color(226, 226, 226));
		txtID.setToolTipText("영문, 숫자만 가능");
		txtID.setHorizontalAlignment(SwingConstants.CENTER);
		txtID.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 17));
		txtID.setColumns(10);
		txtID.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		txtID.setBounds(333, 142, 340, 63);
		panel2.add(txtID);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setToolTipText("숫자만 가능");
		txtPhoneNumber.setSelectionColor(new Color(226, 226, 226));
		txtPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhoneNumber.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 17));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		txtPhoneNumber.setBounds(333, 361, 340, 63);
		panel2.add(txtPhoneNumber);

		btnSignUp = new JButton("가입하기");
		btnSignUp.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 17));
		btnSignUp.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		btnSignUp.setBackground(new Color(232, 232, 232));
		btnSignUp.setBounds(398, 511, 211, 51);
		panel2.add(btnSignUp);

		lblIPassword = new JLabel("비밀번호");
		lblIPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIPassword.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 17));
		lblIPassword.setBounds(242, 218, 80, 51);
		panel2.add(lblIPassword);

		passwordField = new JPasswordField();
		passwordField.setSelectionColor(new Color(226, 226, 226));
		passwordField.setToolTipText("영문 대소문자, 숫자, 특수문자($@$!%*#?&)");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("AppleSDGothicNeoL00", Font.PLAIN, 17));
		passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		passwordField.setBounds(333, 215, 340, 63);
		panel2.add(passwordField);

		setVisible(true);

		// 홈화면 돌아가기 버튼
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home1();
			}
		});

		// 로그인 시도하기 버튼
		btnTryToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login().setVisible(true);
			}
		});
		
		// 아이디 찾기 버튼
		btnFindToID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FindToID();
			}
		});
		
		// 가입하기 버튼
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userID = txtID.getText();
				String password = new String(passwordField.getPassword());
				String userName = txtName.getText();
				String phoneNumber = txtPhoneNumber.getText();

				UserService userService = new UserService();
				boolean success = userService.SignUp(userID, password, userName, phoneNumber);

				if (success) {
					JOptionPane.showMessageDialog(SignUp.this, "회원가입이 완료되었습니다.");
					dispose();
					new Login();
				} else {
					JOptionPane.showMessageDialog(SignUp.this, "회원가입에 실패하였습니다. 입력 정보를 확인해 주세요.");
					txtID.requestFocus();
				}
			}
		});

	}
}
