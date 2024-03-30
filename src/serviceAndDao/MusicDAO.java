package serviceAndDao;

import java.sql.SQLException;
import java.util.Vector;

public class MusicDAO extends DBConn {

	// 각 장르 화면에서 장르별 all track 출력
	public Vector<Vector<Object>> getTracksByGenres(String genreName) {
		Vector<Vector<Object>> tracks = new Vector<>();
		try {
			sql = "SELECT s.songName, a.artistName, al.albumName " + "FROM songs s "
					+ "JOIN albums al ON s.albumIDX = al.albumIDX " + "JOIN artists a ON s.artistIDX = a.artistIDX "
					+ "JOIN genres g ON al.genreIDX = g.genreIDX " + "WHERE g.genreName = ? ORDER BY RAND()";
			// 발매일자나 DB 저장순이 아닌 랜덤으로 보여지게 하고싶어 RAND() 함수 사용
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, genreName);
			rs = pstmt.executeQuery();

			while (rs.next()) { // 모든 결과 행 처리를 위해 while 루프 사용
				Vector<Object> track = new Vector<>();
				track.add(rs.getString("songName"));
				track.add(rs.getString("artistName"));
				track.add(rs.getString("albumName"));
				tracks.add(track);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return tracks;
	}

	// search 화면 내 모든 노래 리스트 출력
	public Vector<Vector<Object>> getAllTracks() {
		Vector<Vector<Object>> tracks = new Vector<>();
		try {
			String sql = "SELECT s.songName, a.artistName, al.albumName, al.releaseDate " + 
		             "FROM songs s " +
		             "JOIN albums al ON s.albumIDX = al.albumIDX " +
		             "JOIN artists a ON s.artistIDX = a.artistIDX";
			if (conn != null && !conn.isClosed()) {
		        System.out.println("Database connection is open.");
		    }
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("Processing a new row...");
				Vector<Object> track = new Vector<>();
				track.add(rs.getString("songName"));
				track.add(rs.getString("artistName"));
				track.add(rs.getString("albumName"));
				track.add(rs.getString("releaseDate"));
				
				tracks.add(track);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return tracks;
	}
}