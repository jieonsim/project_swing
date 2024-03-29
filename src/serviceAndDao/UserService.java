package serviceAndDao;

import javax.swing.JOptionPane;

import vo.*;

public class UserService {
	private UserDAO userDAO = new UserDAO();

	// 회원가입
	public boolean SignUp(String userID, String password, String userName, String phoneNumber) {
		// 필드 빈칸 여부 확인
		if (userID.isEmpty() || password.isEmpty() || userName.isEmpty() || phoneNumber.isEmpty())
			return false;
		// 아이디 : 영어 소문자, 숫자만 가능
		if (!userID.matches("^[a-z][a-z0-9]*$"))
			return false;
		// 비밀번호 : // 대소문자 구분 숫자 특수문자 조합
		if (!password.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,}$"))
			return false;
		// 이름 : 한글, 영문만 가능
		if (!userName.matches("^[가-힣a-zA-Z]*$"))
			return false;
		// 번호 : 숫자만 가능
		if (!phoneNumber.matches("\\d+"))
			return false;

		// 입력한 이름과 번호의 조합으로 가입된 아이디가 있는지 확인
		if (userDAO.findUserID(userName, phoneNumber) != null) {
			JOptionPane.showMessageDialog(null, "입력한 이름과 번호로 이미 가입된 계정이 있습니다.");
			return false;
		}

		// 이미 있는 아이디로 가입 시도하는지 확인
		if (userDAO.IDduplicateCheck(userID) != null) {
			JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다.");
			return false;
		}

		// 모든 검증을 통과한 경우, 데이터베이스에 사용자 정보 저장
		int result = userDAO.setSignUp(userID, password, userName, phoneNumber);

		return result > 0;
	}

	// 로그인
	public boolean login(String userID, String password) { // 로그인 시 회원이 입력한 아이디, 비밀번호 전달받기
		UserVO userVO = userDAO.existsByUser(userID); // 계정이 존재하는지 먼저 확인 후
		if (userVO != null && userVO.getPassword().equals(password)) {
			// 계정이 존재하고 비밀번호가 일치하는 경우
			return true; // 로그인 성공
		} else {
			return false; // 로그인 실패
		}
	}

	// 아이디 찾기
	public String findUserId(String userName, String phoneNumber) {
		return userDAO.findUserID(userName, phoneNumber);
	}

	// 비밀번호 찾기
	public String findPassword(String userID, String userName, String phoneNumber) {
		return userDAO.findPassword(userID, userName, phoneNumber);
	}

}
