package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.GenreMapper;
import com.example.demo.util.Printer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DemoThymeleafService {
    
    private final Printer printer;
    private final BookMapper bookMapper;
    private final GenreMapper genreMapper;


    public Model setModel(Model model) {
        // String
        model.addAttribute("message", "hello!");
        // List
        model.addAttribute("list", new ArrayList<String>(
            Arrays.asList("one", "two", "three")
        ));
        // Map
        model.addAttribute("map", new HashMap<String, Integer>(){{
            put("one", 1);
            put("two", 2);
            put("three", 3);
        }});

        
        // DBから取得した値をセット
        try {
            model.addAttribute("book", bookMapper.findById(1));
            model.addAttribute("books", bookMapper.findAll());
            model.addAttribute("genre", genreMapper.findById("J001"));
            model.addAttribute("genres", genreMapper.findAll());

            printer.yellow(bookMapper.findAll());
            printer.green(genreMapper.findAll());
        } catch (Exception e) {
            printer.red("DB接続エラー", e);
            model.addAttribute("error", "db connect error");
        }

        return model;
    }
}
