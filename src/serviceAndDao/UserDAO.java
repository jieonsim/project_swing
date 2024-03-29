package serviceAndDao;

import java.sql.SQLException;

import vo.*;

public class UserDAO extends DBConn {

	// 로그인 시 계정 존재 여부 확인
	public UserVO existsByUser(String userID) {
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
				userVO.setPassword(rs.getString("password"));
				userVO.setUserName(rs.getString("userName"));
				userVO.setPhoneNumber(rs.getString("phoneNumber"));
				userVO.setJoinDate(rs.getString("joinDate"));
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

	// 이름 + 전화번호 조합으로 아이디 찾기
	public String findUserID(String userName, String phoneNumber) {
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
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return foundUserId;
	}

	// 아이디 + 이름 + 전화번호 조합으로 비밀번호 찾기
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
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return foundPassword;
	}
	
	// 회원가입 시 입력한 아이디가 이미 존재하는 아이디인지 확인
	public String IDduplicateCheck(String userID) {
	    String isDuplicated = null;

	    try {
	        sql = "SELECT 1 FROM users WHERE userID = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, userID);
	        rs = pstmt.executeQuery();
	        if(rs.next()) {
	            isDuplicated = userID; // 이미 존재한다는 것을 의미합니다.
	        }
	    } catch (SQLException e) {
	        System.out.println("SQL 오류 : " + e.getMessage());
	    } finally {
	    	rsClose();
	    }
	    return isDuplicated;
	}

	
	
}
