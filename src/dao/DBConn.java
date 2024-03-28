package dao;

import java.sql.*;

public class DBConn {
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;

	public DBConn() {
		String url = "jdbc:mysql://localhost:3306/javaclass";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패");
		} catch (SQLException e) {
			System.out.println("데이터 베이스 연동 실패");
		}
	}

	// connClose();
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {
		}
	}

	// pstmtClose();
	public void pstmtClose() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
		}
	}

	// rsClose()
	public void rsClose() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
		}
	}
}