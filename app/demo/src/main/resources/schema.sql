
-- 初期化
DROP TABLE IF EXISTS sales_details;
DROP TABLE IF EXISTS sales;
DROP TABLE IF EXISTS test;
DROP TABLE IF EXISTS book_genres;
DROP TABLE IF EXISTS genres;
DROP TABLE IF EXISTS book_details;
DROP TABLE IF EXISTS books;


-- テーブル定義
-- テスト用テーブル
CREATE TABLE test (
    id int primary key
); 

-- 書籍テーブル
CREATE TABLE books (
    id SERIAL, 
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,

    CONSTRAINT pk_book_01 PRIMARY KEY (id)
); 

-- 書籍詳細テーブル
CREATE TABLE book_details (
    book_id INT,
    context TEXT, 

    CONSTRAINT pk_book_details_01 PRIMARY KEY (book_id),
    CONSTRAINT fk_book_details_01 FOREIGN KEY (book_id) REFERENCES books (id) ON UPDATE CASCADE ON DELETE CASCADE
); 

-- ジャンルテーブル
CREATE TABLE genres (
    code VARCHAR(128),
    name VARCHAR(255) NOT NULL, 

    CONSTRAINT pk_genres_01 PRIMARY KEY (code)
); 

-- 書籍ジャンルテーブル(連関)
CREATE TABLE book_genres (
    book_id INT, 
    genre_code VARCHAR(128),

    CONSTRAINT pk_book_genres_01 PRIMARY KEY (book_id, genre_code),
    CONSTRAINT fk_book_genres_01 FOREIGN KEY (book_id) REFERENCES books (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_book_genres_02 FOREIGN KEY (genre_code) REFERENCES genres (code) ON UPDATE CASCADE ON DELETE CASCADE
); 



-- 販売テーブル
CREATE TABLE sales (
    sales_no VARCHAR(64), 

    CONSTRAINT pk_sales_01 PRIMARY KEY (sales_no) 
); 

-- 販売詳細テーブル
CREATE TABLE sales_details (
    sales_no VARCHAR(64),
    sales_detail_no INT, 
    name VARCHAR(128),
    price VARCHAR(128),
    quantity VARCHAR(128),

    CONSTRAINT pk_sales_details_01 PRIMARY KEY (sales_no, sales_detail_no),
    CONSTRAINT fk_sales_details_01 FOREIGN KEY (sales_no) REFERENCES sales (sales_no) ON UPDATE CASCADE ON DELETE CASCADE
);