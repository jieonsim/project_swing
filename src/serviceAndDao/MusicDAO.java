package serviceAndDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import uiAndVO.library.AlbumVO;
import uiAndVO.library.ArtistVO;
import uiAndVO.library.SongVO;
import uiAndVO.playlists.*;

public class MusicDAO extends DBConn {

	// browse에서 각 장르별 all track 출력
	
	public Vector<Vector<Object>> getTracksByGenres(String genreName) {
		Vector<Vector<Object>> tracks = new Vector<>();
		try {
			sql = "SELECT s.songIDX, s.songName, a.artistName, al.albumName " + "FROM songs s "
					+ "JOIN albums al ON s.albumIDX = al.albumIDX " + "JOIN artists a ON s.artistIDX = a.artistIDX "
					+ "JOIN genres g ON al.genreIDX = g.genreIDX " + "WHERE g.genreName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, genreName);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector<Object> track = new Vector<>();
				track.add(rs.getInt("songIDX"));
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

	// search에서 조건 검색 후 다시 전체 검색 시 모든 노래 리스트 출력을 위한 메소드
	
	
	
	public Vector<Vector<Object>> getAllTracks() {
		Vector<Vector<Object>> tracks = new Vector<>();
		try {
			String sql = "SELECT s.songIDX, s.songName, a.artistName, al.albumName, al.releaseDate " + "FROM songs s "
					+ "JOIN albums al ON s.albumIDX = al.albumIDX " + "JOIN artists a ON s.artistIDX = a.artistIDX";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector<Object> track = new Vector<>();
				track.add(rs.getInt("songIDX"));
				track.add(rs.getString("songName"));
				track.add(rs.getString("artistName"));
				track.add(rs.getString("albumName"));
				track.add(rs.getString("releaseDate"));
				tracks.add(track);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return tracks;
	}

	// search에서 조건 검색을 위한 메소드
	public Vector<Vector<Object>> getTracksByCondition(String column, String value) {
		Vector<Vector<Object>> tracks = new Vector<>();
		try {
			sql = "SELECT s.songIDX, s.songName, a.artistName, al.albumName, al.releaseDate " + "FROM songs s "
					+ "JOIN albums al ON s.albumIDX = al.albumIDX " + "JOIN artists a ON s.artistIDX = a.artistIDX "
					+ "WHERE " + column + " LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + value + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector<Object> track = new Vector<>();
				track.add(rs.getInt("songIDX"));
				track.add(rs.getString("songName"));
				track.add(rs.getString("artistName"));
				track.add(rs.getString("albumName"));
				track.add(rs.getString("releaseDate"));
				tracks.add(track);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return tracks;
	}

	// 특정 사용자의 Favorite Songs playlist의 IDX를 찾기 위한 메소드
	// "Favorite Songs" 플레이리스트가 이미 존재하는지 확인하고, 그 ID를 가져오는 데 사용
	// "Favorite Songs" 플레이리스트의 ID가 필요한 이유:
	// 사용자가 좋아요 버튼을 눌렀을 때 해당 노래를 그 사용자의 favorite songs 플레이리스트에 추가하기 위함
	public int findFavoritePlaylistIDByUserID(int userIDX) {
		int playlistIDX = -1;
		try {
			String sql = "SELECT playlistIDX FROM playlists WHERE userIDX = ? AND isFavorite = TRUE";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userIDX);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				playlistIDX = rs.getInt("playlistIDX");
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return playlistIDX;
	}

	// Favorite songs 플레이리스트에 좋아요한 노래를 추가하는 메소드
	// playlistIDX와 songIDX를 인자로 받아 해당 노래를 플레이리스트에 추가
	public boolean addSongToFavoritePlaylist(int userIDX, int songIDX) {
		try {
			// Favorite Songs 플레이리스트 ID 찾기
			int playlistIDX = findFavoritePlaylistIDByUserID(userIDX);
			if (playlistIDX == -1) {
				// Favorite Songs 플레이리스트가 없으면 생성 실패 처리
				return false;
			}

			// 노래를 Favorite Songs 플레이리스트에 추가
			sql = "INSERT INTO playlistSongs (playlistIDX, songIDX) VALUES (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, playlistIDX);
			pstmt.setInt(2, songIDX);
			int affectedRows = pstmt.executeUpdate();

			return affectedRows > 0;
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
			return false;
		} finally {
			pstmtClose();
		}
	}

	// favoriet songs 메뉴에서 사용자가 추가한 좋아요한 곡 리스트 보기
	public Vector<Vector<Object>> getFavoriteSongs(int userIDX) {
		Vector<Vector<Object>> favoritePlaylist = new Vector<>();
		try {
			sql = "SELECT ps.songIDX, s.songName, a.artistName " + "FROM playlistSongs ps "
					+ "JOIN playlists p ON ps.playlistIDX = p.playlistIDX " + "JOIN songs s ON ps.songIDX = s.songIDX "
					+ "JOIN artists a ON s.artistIDX = a.artistIDX " + "WHERE p.userIDX = ? AND p.isFavorite = TRUE";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userIDX); // 현재 로그인한 사용자의 userIDX를 파라미터로 설정
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector<Object> favoriteSongs = new Vector<>();
				favoriteSongs.add(rs.getInt("songIDX")); // songIDX를 Integer로 추가
				favoriteSongs.add(rs.getString("songName"));
				favoriteSongs.add(rs.getString("artistName"));
				favoritePlaylist.add(favoriteSongs);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return favoritePlaylist;
	}

	// favorite songs 플레이리스트에서 노래 삭제
	public boolean deleteFromFavoriteSongs(int userIDX, int songIDX) {
		try {
			int playlistIDX = findFavoritePlaylistIDByUserID(userIDX);
			if (playlistIDX == -1) {
				return false;
			}
			sql = "DELETE FROM playlistSongs WHERE playlistIDX = ? AND songIDX = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, playlistIDX);
			pstmt.setInt(2, songIDX);
			int affectedRows = pstmt.executeUpdate();

			return affectedRows > 0;
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
			return false;
		} finally {
			pstmtClose();
		}
	}

	// 즐겨찾기 플레이리스트에서 조건 검색
	public Vector<Vector<Object>> getFavoriteTracksByCondition(int userIDX, String column, String value) {
		Vector<Vector<Object>> tracks = new Vector<>();

		try {
			sql = "SELECT s.songIDX, s.songName, a.artistName " + "FROM playlistSongs ps "
					+ "JOIN songs s ON ps.songIDX = s.songIDX " + "JOIN artists a ON s.artistIDX = a.artistIDX "
					+ "JOIN playlists p ON ps.playlistIDX = p.playlistIDX "
					+ "WHERE p.userIDX = ? AND p.isFavorite = TRUE AND " + column + " LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userIDX);
			pstmt.setString(2, "%" + value + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector<Object> track = new Vector<>();
				track.add(rs.getInt("songIDX"));
				track.add(rs.getString("songName"));
				track.add(rs.getString("artistName"));
				tracks.add(track);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return tracks;
	}

	// 나만의 새로운 플레이리스트 만들기
	public boolean createNewPlaylistForUser(int userIDX, String playlistName) {
		// 플레이리스트 이름과 사용자 IDX를 사용하여 새로운 플레이리스트를 추가
		sql = "INSERT INTO playlists (playlistName, userIDX, isFavorite) VALUES (?, ?, false)";
		pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, playlistName); // 첫 번째 물음표(?)에 플레이리스트 이름 설정
			pstmt.setInt(2, userIDX); // 두 번째 물음표(?)에 사용자 IDX 설정

			int affectedRows = pstmt.executeUpdate(); // SQL 쿼리 실행

			if (affectedRows > 0) { // 쿼리 실행으로 인해 영향을 받은 행이 있으면 true 반환
				return true;
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return false; // 쿼리 실행이 실패하거나 영향을 받은 행이 없으면 false 반환
	}

	// 사용자가 즐겨찾기 외 플레이리스트를 가지고 있는지 확인하는 메소드
	public boolean userHasPlaylist(int userIDX) {
		try {
			sql = "SELECT COUNT(*) FROM playlists WHERE userIDX = ? AND isFavorite = FALSE";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userIDX);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0; // 즐겨찾기 외 사용자화 플레이리스트가 하나라도 존재하면 true 반환
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return false; // 사용자화 플레이리스트가 존재하지 않으면 false 반환
	}

	// 사용자가 만든 플레이리스트 IDX를 가져오는 메소드 (플레이리스트 트랙 추가와 플레이리스트 커버 사진 추가에 사용)
	public int getUserPlaylistIDX(int userIDX) {
		try {
			// isFavorite이 false인 플레이리스트 중 가장 최근에 추가된 플레이리스트 IDX 조회
			sql = "SELECT playlistIDX FROM playlists WHERE userIDX = ? AND isFavorite = FALSE";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userIDX);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("playlistIDX"); // 새로운 플레이리스트 IDX 반환
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return -1; // 플레이리스트가 없는 경우 -1 반환
	}

	// 트랙을 사용자의 플레이리스트에 추가하는 메소드
	public boolean addTrackToPlaylist(int playlistIDX, int songIDX) {
		try {
			sql = "INSERT INTO playlistSongs (playlistIDX, songIDX) VALUES (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, playlistIDX);
			pstmt.setInt(2, songIDX);
			int affectedRows = pstmt.executeUpdate();
			return affectedRows > 0; // 삽입 성공 여부 반환
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return false;
	}

	// 사용자가 만든 플레이리스트의 트랙을 테이블에 보여주는 메소드
	public Vector<Vector<Object>> getUserCreatedPlaylistTracks(int userIDX) {
		Vector<Vector<Object>> userPlaylist = new Vector<>();
		try {
			// 주의: isFavorite이 FALSE인 조건 / isFavorite이 TRUE면 즐겨찾기 플레이리스트, FALSE면 사용자가 만든
			// 플레이리스트
			sql = "SELECT ps.songIDX, s.songName, a.artistName " + "FROM playlistSongs ps "
					+ "JOIN playlists p ON ps.playlistIDX = p.playlistIDX " + "JOIN songs s ON ps.songIDX = s.songIDX "
					+ "JOIN artists a ON s.artistIDX = a.artistIDX " + "WHERE p.userIDX = ? AND p.isFavorite = FALSE";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userIDX);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector<Object> playlistTracks = new Vector<>();
				playlistTracks.add(rs.getInt("songIDX"));
				playlistTracks.add(rs.getString("songName"));
				playlistTracks.add(rs.getString("artistName"));
				userPlaylist.add(playlistTracks);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return userPlaylist;
	}

	// 사용자가 만든 플레이리스트에서 트랙 삭제
	public boolean deleteFromUserCreatedPlaylist(int userIDX, int songIDX) {
		try {
			// 사용자의 isFavorite이 FALSE인 플레이리스트 IDX 찾기
			int playlistIDX = getUserPlaylistIDX(userIDX);
			if (playlistIDX == -1) {
				return false;
			}
			sql = "DELETE FROM playlistSongs WHERE playlistIDX = ? AND songIDX = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, playlistIDX);
			pstmt.setInt(2, songIDX);
			int affectedRows = pstmt.executeUpdate();

			return affectedRows > 0;
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
			return false;
		} finally {
			pstmtClose();
		}
	}

	// 사용자가 만든 플레이리스트에서 조건 검색
	public Vector<Vector<Object>> getUserCreatedPlaylistByCondition(int userIDX, String column, String value) {
		Vector<Vector<Object>> tracks = new Vector<>();

		try {
			sql = "SELECT s.songIDX, s.songName, a.artistName " + "FROM playlistSongs ps "
					+ "JOIN songs s ON ps.songIDX = s.songIDX " + "JOIN artists a ON s.artistIDX = a.artistIDX "
					+ "JOIN playlists p ON ps.playlistIDX = p.playlistIDX "
					+ "WHERE p.userIDX = ? AND p.isFavorite = FALSE AND " + column + " LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userIDX);
			pstmt.setString(2, "%" + value + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector<Object> track = new Vector<>();
				track.add(rs.getInt("songIDX"));
				track.add(rs.getString("songName"));
				track.add(rs.getString("artistName"));
				tracks.add(track);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return tracks;
	}

	// 플레이리스트 이름 조회 메소드
	public String getPlaylistNameByUserIDX(int userIDX) {
		String playlistName = "";
		try {
			sql = "SELECT playlistName FROM playlists WHERE userIDX = ? AND isFavorite = FALSE";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userIDX);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				playlistName = rs.getString("playlistName");
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return playlistName;
	}

	// 플레이리스트 이름 수정
	public boolean updatePlaylistName(int userIDX, String newPlaylistName) {
		try {
			sql = "UPDATE playlists SET playlistName = ? WHERE userIDX = ? AND isFavorite = FALSE";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPlaylistName);
			pstmt.setInt(2, userIDX);
			int affectedRows = pstmt.executeUpdate();
			return affectedRows > 0;
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
			return false;
		} finally {
			pstmtClose();
		}
	}

	// 플레이리스트 커버 이미지 경로 업데이트
	public boolean updatePlaylistCoverImage(int playlistIDX, String imagePath) {
		try {
			// isFavorite = FALSE 조건을 추가하여 사용자가 만든 플레이리스트만 커버 이미지를 업데이트할 수 있도록 함
			sql = "UPDATE playlists SET playlistCoverImagePath = ? WHERE playlistIDX = ? AND isFavorite = FALSE";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, imagePath);
			pstmt.setInt(2, playlistIDX);

			int affectedRows = pstmt.executeUpdate();
			return affectedRows > 0; // 업데이트된 행이 있으면 true 반환
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
			return false;
		} finally {
			pstmtClose();
		}
	}

	// 사용자의 플레이리스트에 있는 아티스트 정보 조회
	public List<ArtistVO> getUserArtists(int userIDX) {
		List<ArtistVO> artists = new ArrayList<>();
		try {
			sql = "SELECT DISTINCT a.artistIDX, a.artistName, a.imagePath " + "FROM artists a "
					+ "JOIN songs s ON a.artistIDX = s.artistIDX " + "JOIN playlistSongs ps ON s.songIDX = ps.songIDX "
					+ "JOIN playlists p ON ps.playlistIDX = p.playlistIDX " + "WHERE p.userIDX = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userIDX);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArtistVO artist = new ArtistVO();
				artist.setArtistIDX(rs.getInt("artistIDX"));
				artist.setImagePath(rs.getString("imagePath"));
				artist.setArtistName(rs.getString("artistName"));
				artists.add(artist);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return artists;
	}

	// 사용자 플레이리스트에 있는 앨범 정보 조회
	public List<AlbumVO> getUserAlbums(int userIDX) {
		List<AlbumVO> albums = new ArrayList<>();
		try {
			sql = "SELECT DISTINCT al.albumIDX, al.albumName, a.artistName, al.coverPath " + "FROM albums al "
					+ "JOIN artists a ON al.artistIDX = a.artistIDX " + "JOIN songs s ON al.albumIDX = s.albumIDX "
					+ "JOIN playlistSongs ps ON s.songIDX = ps.songIDX "
					+ "JOIN playlists p ON ps.playlistIDX = p.playlistIDX " + "WHERE p.userIDX = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userIDX);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				AlbumVO album = new AlbumVO();
				album.setAlbumIDX(rs.getInt("albumIDX"));
				album.setCoverPath(rs.getString("coverPath"));
				album.setAlbumName(rs.getString("albumName"));
				album.setArtistName(rs.getString("artistName"));
				albums.add(album);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return albums;
	}

	// 사용자 플레이리스트에 있는 노래 정보 조회
	public List<SongVO> getUserPlaylistSongs(int userIDX) {
		List<SongVO> songs = new ArrayList<>();
		String sql = "SELECT DISTINCT ps.songIDX, al.coverPath, s.songName, a.artistName " + "FROM playlistSongs ps "
				+ "JOIN playlists p ON ps.playlistIDX = p.playlistIDX " + "JOIN songs s ON ps.songIDX = s.songIDX "
				+ "JOIN albums al ON s.albumIDX = al.albumIDX " + "JOIN artists a ON s.artistIDX = a.artistIDX "
				+ "WHERE p.userIDX = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userIDX);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				SongVO song = new SongVO();
				song.setSongIDX(rs.getInt("songIDX"));
				song.setAlbumCoverPath(rs.getString("coverPath"));
				song.setSongName(rs.getString("songName"));
				song.setArtistName(rs.getString("artistName"));
				songs.add(song);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return songs;
	}

	// 사용자 플레이리스트에 업로드한 커버이미지 불러오기
	public PlaylistsVO getUserIdxPlaylist(Integer userIDX) {
		PlaylistsVO vo = new PlaylistsVO();
		try {
			sql = "SELECT * FROM playlists WHERE userIDX = ? ORDER BY playlistIDX DESC";
			// favorite songs는 가입과 동시에 만들어지고
			// 사용자화 플레이리스트는 가입 후 추가로 만들 수 있기 때문에 playlistIDX를 뒤에서부터 찾는다
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userIDX);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setUserIDX(userIDX);
				vo.setPlaylistCoverImagePath(rs.getString("playlistCoverImagePath"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	
}
