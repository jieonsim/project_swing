package service.user;

import javax.swing.JOptionPane;

import dao.user.UserDAO;
import vo.user.UserVO;

public class UserService {
	private UserDAO userDAO = new UserDAO();

	// 회원가입
	public boolean SignUp(String userID, String password, String userName, String phoneNumber) {
		// 필드 빈칸 여부 확인
		if (userID.isEmpty() || password.isEmpty() || userName.isEmpty() || phoneNumber.isEmpty())
			return false;

		if (!userID.matches("^[a-zA-Z][a-zA-Z0-9]*$"))
			return false;
		if (!password.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,}$"))
			return false;
		// 비밀번호 검증 : // 대소문자 구분 숫자 특수문자 조합 9 ~ 12 자리
		if (!userName.matches("^[가-힣a-zA-Z]*$"))
			return false; // 이름 검증
		if (!phoneNumber.matches("\\d+"))
			return false; // 휴대폰 번호 검증

		// 동일한 이름과 휴대폰 번호를 가진 사용자가 이미 존재하는지 확인
		UserVO userVO = userDAO.getNameAndNumberSearch(userName, phoneNumber);
		if (userVO.getUserName() != null && userVO.getPhoneNumber() != null) {
			JOptionPane.showMessageDialog(null, "이미 가입된 회원입니다. 입력 정보를 다시 확인해 주세요.");
		} else {
			userVO.setUserID(userID);
			userVO.setPassword(password);
			userVO.setUserName(userName);
			userVO.setPhoneNumber(phoneNumber);
		}
		// 모든 검증을 통과한 경우, 데이터베이스에 사용자 정보 저장
		int result = userDAO.setSignUp(userID, password, userName, phoneNumber);

		return result > 0;
	}

	// 로그인
	public boolean login(String userID, String password) {
		UserVO userVO = userDAO.findUserByUserID(userID);
		if (userVO != null && userVO.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	// 아이디 찾기
	public String findUserId(String userName, String phoneNumber) {
		return userDAO.findUserIdByUserNameAndPhone(userName, phoneNumber);
	}

	// 비밀번호 찾기
	public String findPassword(String userID, String userName, String phoneNumber) {
		return userDAO.findPassword(userID, userName, phoneNumber);
	}

}
