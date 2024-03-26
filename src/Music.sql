show tables;

DESC genres;
DROP TABLE artists;
DELETE FROM songs;
SELECT * FROM artists;

-- Users (사용자)
CREATE TABLE users (
	userID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	userName VARCHAR(50) NOT NULL,
	password VARCHAR(255) NOT NULL,
	phoneNumber VARCHAR(20) NOT NULL,
	jointDate DATETIME NOT NULL
);

-- Artists (아티스트)
CREATE TABLE artists (
	artistIDX INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	artistName VARCHAR(100) NOT NULL
	/*bio TEXT 할지말지 고민중*/
);

-- Albums (앨범)
CREATE TABLE albums (
	albumIDX INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	artistIDX INT NOT NULL,
	albumName VARCHAR(100) NOT NULL,
	releaseDate DATE NOT NULL,
	FOREIGN KEY (artistIDX) REFERENCES artists (artistIDX) 
);

-- Songs (노래)
CREATE TABLE songs (
    songIDX INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    albumIDX INT NOT NULL,
    artistIDX INT NOT NULL,
    songName VARCHAR(100) NOT NULL,
    FOREIGN KEY (albumIDX) REFERENCES albums(albumIDX),
    FOREIGN KEY (artistIDX) REFERENCES artists(artistIDX)
    /* 할지 말지 고민 중
	duration INT NOT NULL,
	filePath VARCHAR(255) NOT NULL
	 */
);

-- Genres (장르)
CREATE TABLE genres (
	genreIDX INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	genreName VARCHAR(50) NOT NULL
);

-- SongGenres (노래 장르)
CREATE TABLE songGenres (
	songIDX INT NOT NULL,
	genreIDX INT NOT NULL,
	FOREIGN KEY (songIDX) REFERENCES songs(songIDX),
	FOREIGN KEY (genreIDX) REFERENCES genres(genreIDX)
);

-- UserLibrary (사용자 라이브러리)
CREATE TABLE userLibrary (
	userIDX INT NOT NULL,
	albumIDX INT,
	artistIDX INT,
	songIDX INT,
	addDate DATETIME NOT NULL,
	FOREIGN KEY (albumIDX) REFERENCES albums(albumIDX),
	FOREIGN KEY (artistIDX) REFERENCES artists(artistIDX),
	FOREIGN KEY (songIDX) REFERENCES songs(songIDX)
);

-- Playlists (플레이리스트)
CREATE TABLE playlists (
	playlistIDX INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	userID INT NOT NULL,
	playlistName VARCHAR(100) NOT NULL,
	isFavorite BOOLEAN NOT NULL,
	FOREIGN KEY (userID) REFERENCES users(userID)
);

-- PlaylistSongs (플레이리스트 노래)
CREATE TABLE playlistSongs (
	playlistIDX INT NOT NULL,
	songIDX INT NOT NULL,
	addDate DATETIME NOT NULL,
	FOREIGN KEY (playlistIDX) REFERENCES playlists(playlistIDX),
	FOREIGN KEY (songIDX) REFERENCES songs(songIDX)
);
