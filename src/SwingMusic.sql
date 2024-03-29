show tables;

DESC songs;
DROP TABLE users;
DELETE FROM users;
SELECT * FROM songs;

-- Users (사용자)
CREATE TABLE users (
	userIDX INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	userID VARCHAR(50) NOT NULL,
	password VARCHAR(255) NOT NULL,
	UserName VARCHAR(50) NOT NULL,
	phoneNumber VARCHAR(20) NOT NULL,
	joinDate DATETIME DEFAULT NOW() -- DEFAULT 키워드로 기본값 설정
);

-- Artists (아티스트)
CREATE TABLE artists (
	artistIDX INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	artistName VARCHAR(100) NOT NULL,
	imagePath VARCHAR(255)
);

INSERT INTO artists VALUES (DEFAULT, 'Ariana Grande', null);


-- Albums (앨범)
CREATE TABLE albums (
	albumIDX INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	artistIDX INT NOT NULL,
	genreIDX INT NOT NULL,
	albumName VARCHAR(100) NOT NULL,
	releaseDate DATE NOT NULL,
	coverPath VARCHAR(255),
	FOREIGN KEY (artistIDX) REFERENCES artists (artistIDX),
	FOREIGN KEY (genreIDX) REFERENCES genres (genreIDX)
);

INSERT INTO albums (artistIDX, genreIDX, albumName, releaseDate, coverPath) VALUES 


-- Songs (노래)
CREATE TABLE songs (
    songIDX INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    albumIDX INT NOT NULL,
    artistIDX INT NOT NULL,
    songName VARCHAR(100) NOT NULL,
	duration INT NOT NULL, -- 삭제
    FOREIGN KEY (albumIDX) REFERENCES albums(albumIDX),
    FOREIGN KEY (artistIDX) REFERENCES artists(artistIDX)
);
ALTER TABLE songs DROP COLUMN duration;



-- Genres (장르)
CREATE TABLE genres (
	genreIDX INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	genreName VARCHAR(50) NOT NULL,
	imagePath VARCHAR(255)
);

INSERT INTO genres (genreName, imagePath) VALUES ('pop', null);
INSERT INTO genres (genreName, imagePath) VALUES ('rnbSoul', null);
INSERT INTO genres (genreName, imagePath) VALUES ('hiphop', null);
INSERT INTO genres (genreName, imagePath) VALUES ('rock', null);
INSERT INTO genres (genreName, imagePath) VALUES ('jazz', null);
INSERT INTO genres (genreName, imagePath) VALUES ('kpop', null);


-- SongGenres (노래 장르)
CREATE TABLE songGenres (
	songIDX INT NOT NULL,
	genreIDX INT NOT NULL,
	FOREIGN KEY (songIDX) REFERENCES songs(songIDX),
	FOREIGN KEY (genreIDX) REFERENCES genres(genreIDX)
);

-- UserLibrary (사용자 라이브러리)
CREATE TABLE userLibrary (
	userIDX INT,
	albumIDX INT,
	artistIDX INT,
	songIDX INT,
	addDate DATETIME NOT NULL,
	FOREIGN KEY (userIDX) REFERENCES users(userIDX),
	FOREIGN KEY (albumIDX) REFERENCES albums(albumIDX),
	FOREIGN KEY (artistIDX) REFERENCES artists(artistIDX),
	FOREIGN KEY (songIDX) REFERENCES songs(songIDX)
);

-- Playlists (플레이리스트)
CREATE TABLE playlists (
	playlistIDX INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	userIDX INT NOT NULL,
	playlistName VARCHAR(100) NOT NULL,
	isFavorite BOOLEAN NOT NULL,
	FOREIGN KEY (userIDX) REFERENCES users(userIDX)
);

-- PlaylistSongs (플레이리스트 노래)
CREATE TABLE playlistSongs (
	playlistIDX INT NOT NULL,
	songIDX INT NOT NULL,
	addDate DATETIME NOT NULL,
	FOREIGN KEY (playlistIDX) REFERENCES playlists(playlistIDX),
	FOREIGN KEY (songIDX) REFERENCES songs(songIDX)
);
