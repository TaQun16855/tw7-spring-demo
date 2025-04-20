package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.Printer;


// @RestControllerは、jsonとかバイナリデータとかを返すアノテーション
@RestController
@RequestMapping(path="/api")
public class DemoRestController {
    
    private final Printer printer;

    public DemoRestController(Printer printer) {
        this.printer = printer;
    }


    @GetMapping("/get")
    public ResponseEntity<?> get() {
        printer._cyan("call api get");
        return ResponseEntity.ok().body("get!");
    }

    @PostMapping("/post")
    public ResponseEntity<?> post() {
        printer._cyan("call api post");
        return ResponseEntity.ok().body("post!");
    }

    @PutMapping("/put")
    public ResponseEntity<?> put() {
        printer._cyan("call api put");
        return ResponseEntity.ok().body("put!");
    }
    
    @PatchMapping("/patch")
    public ResponseEntity<?> patch() {
        printer._cyan("call api patch");
        return ResponseEntity.ok().body("patch!");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete() {
        printer._cyan("call api delete");
        return ResponseEntity.ok().body("delete!");
    }
}
