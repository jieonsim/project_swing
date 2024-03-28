package dao.library;

import java.sql.SQLException;
import java.util.Vector;

import dao.DBConn;

public class ArtistDAO extends DBConn {
	public Vector<Vector<Object>> getAllArtists() {
	    Vector<Vector<Object>> artistData = new Vector<>();
	    
	    try {
	        String sql = "SELECT artistName, imagePath FROM artists";
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            Vector<Object> row = new Vector<>();
	            row.add(rs.getString("artistName")); // 아티스트 이름
	            row.add(rs.getString("imagePath")); // 이미지 경로
	            artistData.add(row);
	        }
	    } catch (SQLException e) {
	        System.out.println("SQL 오류 : " + e.getMessage());
	    } finally {
	        rsClose();
	    }
	    return artistData;
	}
}
