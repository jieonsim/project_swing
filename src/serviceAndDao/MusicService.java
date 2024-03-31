package serviceAndDao;

import java.util.Vector;

public class MusicService {
	private MusicDAO musicDAO = new MusicDAO();

	// 각 장르별 트랙 호출
	public Vector<Vector<Object>> getTracksByGenres(String genreName) {
		return musicDAO.getTracksByGenres(genreName);
	}

	// 모든 트랙 호출
	public Vector<Vector<Object>> getAllTracks() {
		return musicDAO.getAllTracks();
	}
	
	// 즐겨찾기에 트랙 추가 
	public boolean addToFavoriteSongs(int userIDX, int songIDX) {
		return musicDAO.addSongToFavoritePlaylist(userIDX, songIDX);
	}
	
	// 사용자별 즐겨찾기에 있는 트랙을 favorite songs 화면 table에 뿌리기
	public Vector<Vector<Object>> getFavoriteSongs(int userIDX) {
		return musicDAO.getFavoriteSongs(userIDX);
	}
	
	// 즐겨찾기에 트랙 삭제
	public boolean deleteFromFavoriteSongs(int userIDX, int songIDX) {
		return musicDAO.deleteFromFavoriteSongs(userIDX, songIDX);
	}
	
	// 사용자의 새로운 플레이리스트 생성
	public boolean createNewPlaylist(int userIDX, String playlistName) {
	    // 사용자가 이미 플레이리스트를 가지고 있는지 확인 후
	    if (musicDAO.userHasPlaylist(userIDX)) {
	        // 이미 플레이리스트가 있다면, 새로운 플레이리스트 생성 불가
	        return false;
	    }
	    // 플레이리스트 생성 로직 실행
	    return musicDAO.createNewPlaylistForUser(userIDX, playlistName);
	}
	
	public MusicService() {
		this.musicDAO = new MusicDAO(); // MusicDAO의 인스턴스화
	}

	// 사용자가 만든 플레이리스트에 트랙 추가
	public boolean addTrackToUserPlaylist(int userIDX, int songIDX) {
	    // 먼저 사용자의 새로운 플레이리스트 IDX를 가져오기
	    int playlistIDX = musicDAO.getUserNewPlaylistIDX(userIDX);

	    // 사용자의 플레이리스트 IDX가 유효한 경우에만 트랙을 추가하기
	    if (playlistIDX != -1) {
	        // 트랙을 플레이리스트에 추가하고 결과를 반환
	        return musicDAO.addTrackToPlaylist(playlistIDX, songIDX);
	    } else {
	        // 사용자가 플레이리스트를 가지고 있지 않다면 false를 반환
	        return false;
	    }
	}
	
	// 사용자가 만든 플레이리스트의 트랙을 테이블에 보여주는 메소드
	public Vector<Vector<Object>> getUserCreatedPlaylistTracks(int userIDX) {
		return musicDAO.getUserCreatedPlaylistTracks(userIDX);
	}
	
	// 사용자가 만든 플레이리스트에서 트랙 삭제
	public boolean deleteFromUserCreatedPlaylsit(int userIDX, int songIDX) {
		return musicDAO.deleteFromUserCreatedPlaylist(userIDX, songIDX);
	}
	
	// 사용자가 만든 플레이리스트 네임 호출
	public String getPlaylistNameByUserIDX(int userIDX) {
		return musicDAO.getPlaylistNameByUserIDX(userIDX);
	}
	
	// 사용자가 만든 플레이리스트 네임 수정
	public boolean updatePlaylistName(int userIDX, String newPlaylistName) {
		return musicDAO.updatePlaylistName(userIDX, newPlaylistName);
	}
	
	// 사용자가 만든 플레이리스트 커버 이미지 업데이트
	public boolean updatePlaylistCover(int userIDX, String imagePath) {
		int playlistIDX = musicDAO.getUserNewPlaylistIDX(userIDX);
		if(playlistIDX != -1) {
			return musicDAO.updatePlaylistCoverImage(playlistIDX, imagePath);
		}
		return false;
	}
	
//	// 라이브러리 아티스트 조회
//	public Vector<Vector<Object>> getUserArtists(int userIDX) {
//		return musicDAO.getUserArtists(userIDX);
//	}
	
}
