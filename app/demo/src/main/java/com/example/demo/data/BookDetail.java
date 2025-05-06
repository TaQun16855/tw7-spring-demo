package com.example.demo.data;

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
