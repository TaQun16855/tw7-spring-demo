INSERT INTO 
    test 
VALUES 
    (1)
; 


INSERT INTO 
    books (title, author)
VALUES 
    ('ドラゴンボール', '鳥山明'), 
    ('ワンピース', '尾田栄一郎'),
    ('名探偵コナン', '青山剛昌'),
    ('ゴールデンカムイ', '野田サトル'),
    ('進撃の巨人', '諫山創')
; 

INSERT INTO 
    book_details (book_id, context)
VALUES 
    (1, 'サイヤ人いっぱい'), 
    (2, '海賊いっぱい'),
    (3, '犯人は毛利小五郎'),
    (4, 'おそま'),
    (5, '巨人でかい')
;

INSERT INTO 
    genres (code, name)
VALUES 
    ('J001', 'アクション'), 
    ('J002', 'コメディ'),
    ('J003', 'ミステリー'),
    ('J004', 'ジャンプ'),
    ('J005', 'ファンタジー'),
    ('J006', 'ホラー')
;

INSERT INTO 
    book_genres (book_id, genre_code)
VALUES 
    (1, 'J001'), 
    (1, 'J004'),
    (1, 'J005'),
    (2, 'J001'),
    (2, 'J004'),
    (2, 'J005'),
    (3, 'J001'),
    (3, 'J003'),
    (4, 'J001'),
    (4, 'J002'),
    (4, 'J003'),
    (5, 'J001'),
    (5, 'J005')
;