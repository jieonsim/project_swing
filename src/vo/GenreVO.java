package vo;

public class GenreVO {
	private int genreIDX;
	private String genreName;
	private String imagePath;

	public int getGenreIDX() {
		return genreIDX;
	}

	public void setGenreIDX(int genreIDX) {
		this.genreIDX = genreIDX;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "GenreVO [genreIDX=" + genreIDX + ", genreName=" + genreName + ", imagePath=" + imagePath + "]";
	}

}
