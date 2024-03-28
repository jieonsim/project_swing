package ui.user;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import service.user.UserService;

public class FindToPassword extends JFrame {
	private JTextField txtName;
	private JButton btnFindToPwd, btnFindToID, btnTryToLogin, btnLeft, btnSignUp;
	private JLabel lblID, lblName, lblPhoneNumber;
	private JTextField txtID, txtPhoneNumber;
	private JLabel lblSplit1, lblSplit2;

	public FindToPassword() {
		super("비밀번호 찾기");
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
		btnLeft.setIcon(new ImageIcon(FindToPassword.class.getResource("/Images/leftWhilte.png")));
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
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 15));
		txtName.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		txtName.setBounds(334, 234, 340, 63);
		panel2.add(txtName);
		txtName.setColumns(10);

		btnFindToPwd = new JButton("비밀번호 찾기");
		btnFindToPwd.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		btnFindToPwd.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		btnFindToPwd.setBackground(new Color(232, 232, 232));
		btnFindToPwd.setBounds(396, 453, 211, 51);
		panel2.add(btnFindToPwd);

		btnFindToID = new JButton("아이디 찾기");
		btnFindToID.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		btnFindToID.setContentAreaFilled(false);
		btnFindToID.setBorderPainted(false);
		btnFindToID.setBounds(334, 392, 110, 23);
		panel2.add(btnFindToID);

		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 17));
		lblName.setBounds(242, 239, 80, 51);
		panel2.add(lblName);

		lblPhoneNumber = new JLabel("전화번호");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNumber.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 17));
		lblPhoneNumber.setBounds(242, 324, 80, 51);
		panel2.add(lblPhoneNumber);

		btnTryToLogin = new JButton("로그인");

		btnTryToLogin.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		btnTryToLogin.setContentAreaFilled(false);
		btnTryToLogin.setBorderPainted(false);
		btnTryToLogin.setBounds(446, 392, 110, 23);
		panel2.add(btnTryToLogin);

		lblID = new JLabel("아이디");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 17));
		lblID.setBounds(242, 147, 80, 51);
		panel2.add(lblID);

		txtID = new JTextField();
		txtID.setHorizontalAlignment(SwingConstants.CENTER);
		txtID.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 15));
		txtID.setColumns(10);
		txtID.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		txtID.setBounds(334, 142, 340, 63);
		panel2.add(txtID);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhoneNumber.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 15));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		txtPhoneNumber.setBounds(334, 319, 340, 63);
		panel2.add(txtPhoneNumber);

		lblSplit1 = new JLabel("|");
		lblSplit1.setBounds(445, 397, 17, 15);
		panel2.add(lblSplit1);

		btnSignUp = new JButton("회원가입");
		btnSignUp.setFont(new Font("AppleSDGothicNeoM00", Font.PLAIN, 12));
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorderPainted(false);
		btnSignUp.setBounds(568, 392, 88, 23);
		panel2.add(btnSignUp);

		lblSplit2 = new JLabel("|");
		lblSplit2.setBounds(555, 397, 17, 15);
		panel2.add(lblSplit2);

		setVisible(true);

		// 홈화면 돌아가기 버튼
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home1();
			}
		});

		// 아이디 찾기
		btnFindToID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FindToID();
			}
		});

		// 로그인 시도하기 버튼
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
		
		// 비밀번호 찾기 버튼
		btnFindToPwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userID = txtID.getText();
				String userName = txtName.getText();
				String phoneNumber = txtPhoneNumber.getText();
				
				UserService userService = new UserService();
				String foundPassword = userService.findPassword(userID, userName, phoneNumber);
				
				if(foundPassword != null) {
					JOptionPane.showMessageDialog(null, "해당 아이디의 비밀번호는 " + foundPassword + " 입니다.");
					dispose();
					new Login();
				} else {
					JOptionPane.showMessageDialog(null, "입력하신 정보와 일치하는 계정이 없습니다.", "비밀번호 찾기 실패",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
