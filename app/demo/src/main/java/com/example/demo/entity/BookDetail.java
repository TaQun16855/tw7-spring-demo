package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 書籍詳細情報を保持
 * <li>context : 詳細情報
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDetail {

    private String context;
}
