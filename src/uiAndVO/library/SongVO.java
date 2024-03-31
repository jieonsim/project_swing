package uiAndVO.library;

public class SongVO {
	private int songIDX;
	private String albumCoverPath; // 라이브러리 노래 table에 앨범커버를 넣기 위함
	private String songName;
	private String artistName;

	public int getSongIDX() {
		return songIDX;
	}

	public void setSongIDX(int songIDX) {
		this.songIDX = songIDX;
	}

	public String getAlbumCoverPath() {
		return albumCoverPath;
	}

	public void setAlbumCoverPath(String albumCoverPath) {
		this.albumCoverPath = albumCoverPath;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	@Override
	public String toString() {
		return "SongVO [songIDX=" + songIDX + ", albumCoverPath=" + albumCoverPath + ", songName=" + songName
				+ ", artistName=" + artistName + "]";
	}
}
