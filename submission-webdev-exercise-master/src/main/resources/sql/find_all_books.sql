SELECT title, description 
FROM Books, Genres
WHERE Books.genre_code = Genres.code;
