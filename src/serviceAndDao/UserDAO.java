package serviceAndDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uiAndVO.home.UserVO;

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
		int userIDX = -1; // 사용자 정보 추가 실패 시 반환될 값
		try {
			// userIDX를 반환하기 위해 Statement.RETURN_GENERATED_KEYS 옵션 사용
			sql = "INSERT INTO users (userID, password, userName, phoneNumber) VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, userID);
			pstmt.setString(2, password);
			pstmt.setString(3, userName);
			pstmt.setString(4, phoneNumber);

			int affectedRows = pstmt.executeUpdate();
			
			// INSERT 연산이 성공했다면 생성된 키(userIDX)를 가져온다.
	        if (affectedRows > 0) {
	            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    userIDX = generatedKeys.getInt(1); // 생성된 userIDX를 가져옴
	                }
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("SQL 오류 : " + e.getMessage());
	        userIDX = -1; // 오류 발생 시 userIDX 값을 -1로 설정하여 실패를 나타냄
	    } finally {
	        pstmtClose();
	    }
	    return userIDX; // 성공 시 생성된 userIDX 반환, 실패 시 -1 반환
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
			if (rs.next()) {
				isDuplicated = userID; // 이미 존재한다는 것을 의미
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return isDuplicated;
	}

	// 회원가입 시 userIDX를 사용하여 favorite songs playlist를 자동 생성
	public boolean createFavoritePlaylist(int userIDX) {
		try {
			String sql = "INSERT INTO playlists (userIDX, playlistName, isFavorite) VALUES (?, 'Favorite Songs', true)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userIDX);
			int result = pstmt.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
			return false;
		} finally {
			pstmtClose();
		}
	}
}
