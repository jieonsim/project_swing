package uiAndVO.library;

public class AlbumVO {
	private int albumIDX;
	private String albumName;
	private String artistName; // 조인을 통해 얻은 아티스트 이름을 저장하기 위함
	private String coverPath;

	public int getAlbumIDX() {
		return albumIDX;
	}

	public void setAlbumIDX(int albumIDX) {
		this.albumIDX = albumIDX;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getCoverPath() {
		return coverPath;
	}

	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}

	@Override
	public String toString() {
		return "AlbumVO [albumIDX=" + albumIDX + ", albumName=" + albumName + ", artistName=" + artistName
				+ ", coverPath=" + coverPath + "]";
	}

}
