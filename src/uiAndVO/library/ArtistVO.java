package uiAndVO.library;

public class ArtistVO {
	private int artistIDX;
	private String artistName;
	private String imagePath;

	public int getArtistIDX() {
		return artistIDX;
	}

	public void setArtistIDX(int artistIDX) {
		this.artistIDX = artistIDX;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "ArtistVO [artistIDX=" + artistIDX + ", artistName=" + artistName + ", imagePath=" + imagePath + "]";
	}

}
