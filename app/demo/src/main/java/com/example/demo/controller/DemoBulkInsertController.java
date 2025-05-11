package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.Goods;
import com.example.demo.mapper.GoodsMapper;
import com.example.demo.util.Printer;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/bulk-insert")
public class DemoBulkInsertController {
    
    @GetMapping()
    public String getBulkInsert() {
        return "bulk-insert-view";
    }
}

@RestController
@RequestMapping("/api/bulk-insert")
@AllArgsConstructor
class DemoBulkInsertRestController {

    private final Printer printer;
    private final GoodsMapper goodsMapper;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping()
    public ResponseEntity<Object> getGoodsList() {
        printer._cyan("call /api/bulk-insert get");
        return ResponseEntity.ok(goodsMapper.findAll());
    }

    @PostMapping()
    public ResponseEntity<Object> postGoods(@RequestBody Goods goods) {
        printer._cyan("call /api/bulk-insert post");
        printer._yellow(goods);

        if(!goodsMapper.existsGoods(goods)){
            return ResponseEntity.ok(Map.of("message", "no goods!"));
        }

        int sequence;
        try {
            sequence = goodsMapper.getMaxSeq() + 1;

            goodsMapper.insert(sequence, goods);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(Map.of("message", "failed!"));
        }

        return ResponseEntity.ok(Map.of("message", "success!", "resistered", goodsMapper.findAllSet(String.valueOf(sequence))));
    }

}


