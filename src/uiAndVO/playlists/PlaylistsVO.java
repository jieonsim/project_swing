package uiAndVO.playlists;

public class PlaylistsVO {
	private int playlistIDX;
	private int userIDX;
	private String playListName;
	private boolean isFavorite;
	private String playlistCoverImagePath;
	
	public int getPlaylistIDX() {
		return playlistIDX;
	}
	public void setPlaylistIDX(int playlistIDX) {
		this.playlistIDX = playlistIDX;
	}
	public int getUserIDX() {
		return userIDX;
	}
	public void setUserIDX(int userIDX) {
		this.userIDX = userIDX;
	}
	public String getPlayListName() {
		return playListName;
	}
	public void setPlayListName(String playListName) {
		this.playListName = playListName;
	}
	public boolean isFavorite() {
		return isFavorite;
	}
	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}
	public String getPlaylistCoverImagePath() {
		return playlistCoverImagePath;
	}
	public void setPlaylistCoverImagePath(String playlistCoverImagePath) {
		this.playlistCoverImagePath = playlistCoverImagePath;
	}
	
	@Override
	public String toString() {
		return "PlaylistsVO [playlistIDX=" + playlistIDX + ", userIDX=" + userIDX + ", playListName=" + playListName
				+ ", isFavorite=" + isFavorite + ", playlistCoverImagePath=" + playlistCoverImagePath + "]";
	}
}
