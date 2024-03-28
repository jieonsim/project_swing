package vo.library;

public class SongVO {
	private int songIDX;
	private AlbumVO album;
	private ArtistVO artist;
	private String songName;
	private int duration;

	public int getSongIDX() {
		return songIDX;
	}

	public void setSongIDX(int songIDX) {
		this.songIDX = songIDX;
	}

	public AlbumVO getAlbum() {
		return album;
	}

	public void setAlbum(AlbumVO album) {
		this.album = album;
	}

	public ArtistVO getArtist() {
		return artist;
	}

	public void setArtist(ArtistVO artist) {
		this.artist = artist;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "SongVO [songIDX=" + songIDX + ", album=" + album + ", artist=" + artist + ", songName=" + songName
				+ ", duration=" + duration + "]";
	}

}
