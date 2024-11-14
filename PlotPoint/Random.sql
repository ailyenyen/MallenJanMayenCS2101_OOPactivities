CREATE DATABASE book_tracker;

USE book_tracker;

-- Users table
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    date_joined TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
);

CREATE TABLE books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publication_date DATE,
    page_count INT,
    synopsis TEXT,
    average_rating DECIMAL(3, 2) DEFAULT 0
);

CREATE TABLE tags (
    tag_id INT AUTO_INCREMENT PRIMARY KEY,
    tag_name VARCHAR(50) NOT NULL UNIQUE,
    tag_type ENUM('genre', 'mood') NOT NULL
);

CREATE TABLE book_tags (
    book_id INT,
    tag_id INT,
    PRIMARY KEY (book_id, tag_id),
    FOREIGN KEY (book_id) REFERENCES books(book_id) ON DELETE CASCADE,
    FOREIGN KEY (tag_id) REFERENCES tags(tag_id) ON DELETE CASCADE
);

CREATE TABLE reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT,
    user_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    review_text TEXT,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (book_id) REFERENCES books(book_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    CONSTRAINT unique_user_book_review UNIQUE (user_id, book_id)
);


CREATE TABLE shelves (
    shelf_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    shelf_name VARCHAR(50) NOT NULL,
    UNIQUE(user_id, shelf_name),
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE shelf_books (
    shelf_book_id INT AUTO_INCREMENT PRIMARY KEY,
    shelf_id INT,
    book_id INT,
    date_added TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (shelf_id) REFERENCES shelves(shelf_id) ON DELETE CASCADE,
    FOREIGN KEY (book_id) REFERENCES books(book_id) ON DELETE CASCADE
);


DELIMITER //

CREATE TRIGGER update_average_rating_after_insert
AFTER INSERT ON reviews
FOR EACH ROW
BEGIN
    DECLARE new_avg_rating DECIMAL(3, 2);

    SELECT AVG(rating) INTO new_avg_rating
    FROM reviews
    WHERE book_id = NEW.book_id;

    UPDATE books
    SET average_rating = new_avg_rating
    WHERE book_id = NEW.book_id;
END;
//

CREATE TRIGGER update_average_rating_after_update
AFTER UPDATE ON reviews
FOR EACH ROW
BEGIN
    DECLARE new_avg_rating DECIMAL(3, 2);

    SELECT AVG(rating) INTO new_avg_rating
    FROM reviews
    WHERE book_id = NEW.book_id;

    UPDATE books
    SET average_rating = new_avg_rating
    WHERE book_id = NEW.book_id;
END;
//

CREATE TRIGGER create_default_shelves
AFTER INSERT ON users
FOR EACH ROW
BEGIN
    INSERT INTO shelves (user_id, shelf_name)
    VALUES (NEW.user_id, 'Read'),
           (NEW.user_id, 'Reading'),
           (NEW.user_id, 'Want to Read');
END //

DELIMITER ;

-- Inserting sample books
INSERT INTO books (title, author, publication_date, page_count, synopsis)
VALUES 
    ('To Kill a Mockingbird', 'Harper Lee', '1960-07-11', 281, 'A novel about racial injustice in the Deep South.'),
    ('1984', 'George Orwell', '1949-06-08', 328, 'A dystopian novel set in a totalitarian society under constant surveillance.'),
    ('Pride and Prejudice', 'Jane Austen', '1813-01-28', 279, 'A romantic novel exploring the issues of marriage, money, and class.'),
    ('The Great Gatsby', 'F. Scott Fitzgerald', '1925-04-10', 180, 'A story of the mysteriously wealthy Jay Gatsby and his love for Daisy Buchanan.'),
    ('Moby Dick', 'Herman Melville', '1851-10-18', 635, 'An epic tale of the obsessive quest of Captain Ahab for revenge on Moby Dick.');

-- Inserting sample tags for genres
INSERT INTO tags (tag_name, tag_type)
VALUES 
    ('Classic', 'genre'),
    ('Science Fiction', 'genre'),
    ('Romance', 'genre'),
    ('Dystopian', 'genre'),
    ('Adventure', 'genre'),
    ('Drama', 'genre'),
    ('Mystery', 'genre');

-- Inserting sample tags for moods
INSERT INTO tags (tag_name, tag_type)
VALUES 
    ('Reflective', 'mood'),
    ('Exciting', 'mood'),
    ('Thought-provoking', 'mood'),
    ('Intense', 'mood'),
    ('Heartwarming', 'mood');

-- Associating books with genres in the book_tags table
INSERT INTO book_tags (book_id, tag_id)
VALUES 
    (1, 1),  -- To Kill a Mockingbird is a Classic
    (1, 6),  -- To Kill a Mockingbird is also Drama
    (2, 4),  -- 1984 is Dystopian
    (2, 2),  -- 1984 is also Science Fiction
    (3, 1),  -- Pride and Prejudice is a Classic
    (3, 3),  -- Pride and Prejudice is Romance
    (4, 1),  -- The Great Gatsby is a Classic
    (4, 6),  -- The Great Gatsby is Drama
    (5, 5);  -- Moby Dick is Adventure

-- Associating books with moods in the book_tags table
INSERT INTO book_tags (book_id, tag_id)
VALUES 
    (1, 7),  -- To Kill a Mockingbird is Reflective
    (2, 8),  -- 1984 is Thought-provoking
    (2, 9),  -- 1984 is Intense
    (3, 10), -- Pride and Prejudice is Heartwarming
    (4, 7),  -- The Great Gatsby is Reflective
    (5, 8);  -- Moby Dick is Exciting

