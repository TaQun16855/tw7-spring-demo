package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ジャンルコードとジャンル名を保持
 * <li>code : ジャンルコード
 * <li>name : ジャンル名
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    
    private String id;

    private String title;

    private String author;

    private BookDetail detail;
}
