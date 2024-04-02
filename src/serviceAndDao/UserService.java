package serviceAndDao;

import javax.swing.JOptionPane;

import uiAndVO.home.UserVO;

public class UserService {
	private UserDAO userDAO = new UserDAO();

	// 회원가입
	public boolean signUp(String userID, String password, String userName, String phoneNumber) {
		// 필드 빈칸 여부 확인
		if (userID.isEmpty() || password.isEmpty() || userName.isEmpty() || phoneNumber.isEmpty())
			return false;
		
		// 아이디 : 영어 소문자, 숫자만 가능
		if (!userID.matches("^[a-z][a-z0-9]*$"))
			return false;
		
		// 비밀번호 : 대소문자 구분 숫자 특수문자 조합, 8자리 이상
		if (!password.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,}$"))
			return false;
		
		// 이름 : 한글, 영문만 가능
		if (!userName.matches("^[가-힣a-zA-Z]*$"))
			return false;
		
		// 번호 : 숫자만 가능
		if (!phoneNumber.matches("\\d+"))
			return false;
		
		
		// 입력한 이름과 번호의 조합으로 가입된 정보가 있는지 확인
		if (userDAO.findUserID(userName, phoneNumber) != null) {
			JOptionPane.showMessageDialog(null, "입력한 이름과 번호로 이미 가입된 계정이 있습니다.");
			return false;
		}

		// 이미 존재하는 아이디로 가입을 시도하는지 확인
		if (userDAO.isIdDuplicated(userID) != null) {
			JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다.");
			return false;
		}

		// 모든 검증을 통과한 경우, 데이터베이스에 사용자 정보 저장
		int userIDX = userDAO.setSignUp(userID, password, userName, phoneNumber);
		
		
		// 사용자 정보 저장 성공 시, 'Favorite Songs' 플레이리스트 자동 생성
		if (userIDX > 0) {
			boolean playlistCreated = userDAO.createFavoritePlaylist(userIDX);
			if(!playlistCreated) {
				JOptionPane.showMessageDialog(null, "Favorite Songs Playlists 생성 실패");
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

	// 로그인 시 사용자가 입력한 아이디, 비밀번호룰 전달받아 확인 및 처리
	public UserVO login(String userID, String password) {
		UserVO userVO = userDAO.existsByUser(userID); // 계정이 존재하는지 먼저 확인
		if (userVO != null && userVO.getPassword().equals(password)) {
			// 계정이 존재하고 비밀번호가 일치하는 경우
			return userVO; // 로그인 성공
		} else {
			return null; // 아닐 경우 로그인 실패
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
