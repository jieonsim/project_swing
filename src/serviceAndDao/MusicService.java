package serviceAndDao;

import java.util.Vector;

public class MusicService {
	private MusicDAO musicDAO = new MusicDAO();

	// 각 장르 화면에서 장르별 all track 출력
	public Vector<Vector<Object>> getTracksByGenres(String genreName) {
		return musicDAO.getTracksByGenres(genreName);
	}

	// search 화면 내 모든 노래 리스트 출력
	public Vector<Vector<Object>> getAllTracksForTable() {
		return musicDAO.getAllTracks();
	}
}
