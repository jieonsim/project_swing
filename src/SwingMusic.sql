show tables;

DESC artists;
--DROP TABLE users;
--DELETE FROM users;
SELECT * FROM genres;
SELECT * FROM users;

-- 막 회원가입한 유저 삭제가 불가하여 아래와 같이 처리
/*
 * playlists 테이블에 이 사용자와 관련된 외래 키 제약 조건이 존재하기 때문에 삭제 작업을 완료할 수 없다는 것을 의미
 * . 즉, userIDX가 12인 사용자가 playlists 테이블에 하나 이상의 플레이리스트를 가지고 있기 때문에, 
 * 사용자 레코드를 삭제하려면 먼저 해당 사용자와 연관된 모든 플레이리스트를 playlists 테이블에서 삭제해야 합니다.
 */

DELETE FROM playlists WHERE userIDX = 12;
DELETE FROM users WHERE userIDX = 12;

--------------------------------------------------------
SELECT * FROM songs WHERE aritstIDX = 2;
SELECT * FROM playlists WHERE userIDX = 12;
SELECT * FROM playlists WHERE userIDX = 10 AND isFavorite = TRUE;

DELETE FROM users WHERE userIDX = 12;


-- Users (사용자)
CREATE TABLE users (
	userIDX INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	userID VARCHAR(50) NOT NULL,
	password VARCHAR(255) NOT NULL,
	UserName VARCHAR(50) NOT NULL,
	phoneNumber VARCHAR(20) NOT NULL,
);

ALTER TABLE users DROP COLUMN joinDate; -- joindate삭제


-- Artists (아티스트)
CREATE TABLE artists (
	artistIDX INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	artistName VARCHAR(100) NOT NULL,
	imagePath VARCHAR(255)
);

INSERT INTO artists (artistName, imagePath) VALUES 
('Emotional Oranges','emotinal.jpg'),
('21 Savage','21savage.jpg'),
('Oasis','oasis.jpg'),
('Amaro Freitas','amaro.jpg'),
('아일릿','illit.jpg');


UPDATE artists SET imagePath = 'ariana.jpg' WHERE artistIDX = 1;
UPDATE artists SET imagePath = 'sza.jpg' WHERE artistIDX = 2;
UPDATE artists SET imagePath = 'postmalone.jpg' WHERE artistIDX = 3;
UPDATE artists SET imagePath = 'hyukoh.jpg' WHERE artistIDX = 4;
UPDATE artists SET imagePath = 'newjeans.jpg' WHERE artistIDX = 6;
UPDATE artists SET imagePath = 'norajones.jpg' WHERE artistIDX = 7;


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
(20, 2, 'The Juice, Vol.I', '2019-05-10', 'juice1.jpg'),
(20, 2, 'The Juice, Vol.II', '2019-11-08', 'juice2.jpg'),
(21, 3, 'american dream', '2024-01-11', 'american.jpg'),
(22, 4, '(What''s the Story) Morning Glory?', '1995-10-02', 'morning.jpg'),
(23, 5, 'Y''Y', '2024-03-01', 'yy.jpg'),
(24, 6, 'SUPER REAL ME - EP', '2024-03-25', 'super.jpg');




UPDATE albums SET coverPath = 'sos.jpg' WHERE albumIDX = 7;
UPDATE albums SET coverPath = 'saturn.jpg' WHERE albumIDX = 8;
UPDATE albums SET coverPath = 'beerbong.jpg' WHERE albumIDX = 9;
UPDATE albums SET coverPath = 'hollywood.jpg' WHERE albumIDX = 10;
UPDATE albums SET coverPath = '23.jpg' WHERE albumIDX = 11;
UPDATE albums SET coverPath = 'love.jpg' WHERE albumIDX = 12;
UPDATE albums SET coverPath = '24.jpg' WHERE albumIDX = 13;
UPDATE albums SET coverPath = 'getup.jpg' WHERE albumIDX = 14;
UPDATE albums SET coverPath = 'newjeans.jpg' WHERE albumIDX = 15;
UPDATE albums SET coverPath = 'omg.jpg' WHERE albumIDX = 16;
UPDATE albums SET coverPath = 'comeaway.jpg' WHERE albumIDX = 17;
UPDATE albums SET coverPath = 'vision.jpg' WHERE albumIDX = 18;



INSERT INTO albums (artistIDX, genreIDX, albumName, releaseDate, coverPath) 
VALUES 
(7, 5, 'Come Away with Me (Remastered)', '2002-02-26', null),
(7, 5, 'Visions', '2024-03-08', null);

UPDATE albums SET albumName = 'SOS' WHERE artistIDX = 2 AND albumName = 'SZA' AND releaseDate = '2022-12-09';


-- Songs (노래)
CREATE TABLE songs (
    songIDX INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    albumIDX INT NOT NULL,
    artistIDX INT NOT NULL,
    songName VARCHAR(100) NOT NULL,
    FOREIGN KEY (albumIDX) REFERENCES albums(albumIDX),
    FOREIGN KEY (artistIDX) REFERENCES artists(artistIDX)
);
ALTER TABLE songs DROP COLUMN duration; -- 노래길이 삭제

INSERT INTO songs (albumIDX, artistIDX, songName) VALUES
(31, 24, 'My World'),
(31, 24, 'Magnetic'),
(31, 24, 'Midnight Fiction'),
(31, 24, 'Lucky Girl Syndrome');



INSERT INTO songs (albumIDX, artistIDX, songName) VALUES (7, 2, 'I Hate U');

UPDATE songs SET songName = 'don''t wanna break up again' WHERE songIDX = 3;

-- Genres (장르)
CREATE TABLE genres (
	genreIDX INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	genreName VARCHAR(50) NOT NULL,
	imagePath VARCHAR(255)
);


INSERT INTO genres (genreName, imagePath) VALUES ('pop', null); --1
INSERT INTO genres (genreName, imagePath) VALUES ('rnbSoul', null); --2
INSERT INTO genres (genreName, imagePath) VALUES ('hiphop', null); --3
INSERT INTO genres (genreName, imagePath) VALUES ('rock', null); --4
INSERT INTO genres (genreName, imagePath) VALUES ('jazz', null); --5
INSERT INTO genres (genreName, imagePath) VALUES ('kpop', null); --6

ALTER TABLE genres DROP COLUMN imagePath;



-- Playlists (플레이리스트)
CREATE TABLE playlists (
	playlistIDX INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	userIDX INT NOT NULL,
	playlistName VARCHAR(100) NOT NULL,
	isFavorite BOOLEAN NOT NULL,
	FOREIGN KEY (userIDX) REFERENCES users(userIDX)
);

/*
 	playlists 테이블에 playlistCoverImagePath 컬럼을 추가
 	사용자가 업로드한 플레이리스트의 커버 이미지 파일 경로를 저장하는 데 사용
 */
ALTER TABLE playlists
ADD COLUMN playlistCoverImagePath VARCHAR(255);
desc playlists;

select * from playlists where userIDX = 13;


-- PlaylistSongs (플레이리스트 노래)
CREATE TABLE playlistSongs (
	playlistIDX INT NOT NULL,
	songIDX INT NOT NULL,
	addDate DATETIME DEFAULT NOW(),
	FOREIGN KEY (playlistIDX) REFERENCES playlists(playlistIDX),
	FOREIGN KEY (songIDX) REFERENCES songs(songIDX)
);
