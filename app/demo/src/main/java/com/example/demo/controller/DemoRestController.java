package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.BookMapper;
import com.example.demo.util.Printer;


// @RestControllerは、jsonとかバイナリデータとかを返すアノテーション
@RestController
@RequestMapping(path="/api")
public class DemoRestController {
    
    private final Printer printer;
    private final BookMapper bookMapper;

    public DemoRestController(Printer printer, BookMapper bookMapper) {
        this.printer = printer;
        this.bookMapper = bookMapper;
    }


    @GetMapping("/get")
    public ResponseEntity<?> get() {
        printer._cyan("call api get");
        return ResponseEntity.ok().body(
            Map.of(
                "message", "hello",
                "method", "GET"
            )
        );
    }

    @PostMapping("/post")
    public ResponseEntity<?> post() {
        printer._cyan("call api post");
        return ResponseEntity.ok().body(
            Map.of(
                "method", "POST",
                "books", bookMapper.findAll()
            )
        );
    }

    @PutMapping("/put")
    public ResponseEntity<?> put() {
        printer._cyan("call api put");
        return ResponseEntity.ok().body(
            Map.of(
                "method", "PUT",
                "message", "put dayo!"
            )
        );
    }
    
    @PatchMapping("/patch")
    public ResponseEntity<?> patch() {
        printer._cyan("call api patch");
        return ResponseEntity.ok().body(
            Map.of(
                "method", "PATCH",
                "fruits", Map.of(
                    "apple", "red",
                    "banana", "yellow",
                    "melon", "green"
                )
            )
        );
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete() {
        printer._cyan("call api delete");
        return ResponseEntity.ok().body(
            List.of("method", "is", "DELETE")
        );
    }
}
