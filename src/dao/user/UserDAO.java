package dao.user;

import java.sql.SQLException;

import dao.DBConn;
import vo.user.UserVO;

public class UserDAO extends DBConn {
	String sql;

	// 로그인 시도 시 계정 유무 확인
	public UserVO findUserByUserID(String userID) {
		UserVO userVO = null;
		try {
			sql = "SELECT * FROM users WHERE userID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				userVO = new UserVO();
				userVO.setUserIDX(rs.getInt("userIDX"));
				userVO.setUserID(rs.getString("userID"));
				userVO.setPassword(rs.getString("password")); // Corrected
				userVO.setUserName(rs.getString("userName")); // Corrected
				userVO.setPhoneNumber(rs.getString("phoneNumber")); // Corrected
				userVO.setJoinDate(rs.getString("joinDate")); // Assuming joinDate is a Timestamp
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return userVO;
	}

	// 회원가입
	public int setSignUp(String userID, String password, String userName, String phoneNumber) {
		int result = 0;
		try {
			sql = "INSERT INTO users (userID, password, userName, phoneNumber) VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, password);
			pstmt.setString(3, userName);
			pstmt.setString(4, phoneNumber);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return result;
	}

	// 이름 + 휴대폰번호가 같은 계정이 있는지 확인
	public UserVO getNameAndNumberSearch(String userName, String phoneNumber) {
		UserVO userVO = new UserVO();
		try {
			sql = "SELECT COUNT(*) FROM users WHERE userName = ? AND phoneNumber = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, phoneNumber);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				userVO.setUserName(rs.getString("userName"));
				userVO.setPhoneNumber(rs.getString("phoneNumber"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return userVO;
	}

	// 이름과 전화번호 찾기
	public String findUserIdByUserNameAndPhone(String userName, String phoneNumber) {
		String foundUserId = null;

		try {
			String sql = "SELECT userID FROM users WHERE userName = ? AND phoneNumber = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, phoneNumber);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				foundUserId = rs.getString("userID");
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		}
		return foundUserId;
	}

	public String findPassword(String userID, String userName, String phoneNumber) {
		String foundPassword = null;
		
		try {
			String sql = "SELECT password FROM users WHERE userID = ? AND userName = ? AND phoneNumber = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, userName);
			pstmt.setString(3, phoneNumber);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				foundPassword = rs.getString("password");
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		}
		return foundPassword;
	}

}
