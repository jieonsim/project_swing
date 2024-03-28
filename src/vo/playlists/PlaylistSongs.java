package vo.playlists;

import vo.library.SongVO;

public class PlaylistSongs {
	private PlaylistVO playlist;
	private SongVO song;
	private String addDate;

	public PlaylistVO getPlaylist() {
		return playlist;
	}

	public void setPlaylist(PlaylistVO playlist) {
		this.playlist = playlist;
	}

	public SongVO getSong() {
		return song;
	}

	public void setSong(SongVO song) {
		this.song = song;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	@Override
	public String toString() {
		return "PlaylistSongs [playlist=" + playlist + ", song=" + song + ", addDate=" + addDate + "]";
	}

}
