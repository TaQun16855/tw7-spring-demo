package com.example.demo.data;

import java.util.List;
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
public class Genre {
    
    private String code;

    private String name;

    private List<Book> books;
}
