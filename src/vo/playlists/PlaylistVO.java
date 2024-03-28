package vo.playlists;

import vo.user.UserVO;

public class PlaylistVO {
	private int playlistIDX;
	private UserVO user;
	private String playlistName;
	private boolean isFavorite;

	public int getPlaylistIDX() {
		return playlistIDX;
	}

	public void setPlaylistIDX(int playlistIDX) {
		this.playlistIDX = playlistIDX;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public boolean isFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

	@Override
	public String toString() {
		return "PlaylistVO [playlistIDX=" + playlistIDX + ", playlistName=" + playlistName + ", isFavorite="
				+ isFavorite + "]";
	}

}
