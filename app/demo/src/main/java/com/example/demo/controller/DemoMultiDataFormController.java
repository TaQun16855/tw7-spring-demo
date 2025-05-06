package com.example.demo.controller;

import org.springframework.ui.Model;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.form.Sales;
import com.example.demo.mapper.SalesMapper;
import com.example.demo.util.Printer;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = "/form-multi-data")
public class DemoMultiDataFormController {

    private final Printer printer;
    private final ObjectMapper objectMapper = new ObjectMapper();;

    public DemoMultiDataFormController(Printer printer) {
        this.printer = printer;
    }
    

    @GetMapping()
    public String getForm(Model model) {
        printer._cyan("call form-multi-data get");
        
        model.addAttribute("sales", new Sales());
        return "form-multi-data-view";
    }

    @PostMapping()
    public String postForm(Model model, @ModelAttribute Sales sales) throws Exception{
        printer._cyan("call form-multi-data post", sales);

        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter()
                                    .writeValueAsString(sales);
            model.addAttribute("salesSuccess", json);
        } catch (Exception e) {
            model.addAttribute("salesError", "failed!");
        }
        return "form-multi-data-view";
    }
}


// 複数データをdbに登録する為のエンドポイント
@RestController
@RequestMapping(path = "/api/form-multi-data")
@AllArgsConstructor
class DemoMultiDataFormRestController {

    private final Printer printer;
    private final SalesMapper salesMapper;

    @GetMapping()
    public ResponseEntity<Object> register() {

        // 複数データの登録処理
        try {
            Sales sample = Sales.sample();
            printer._green(sample);

            salesMapper.insertSales(sample);
            salesMapper.insertSalesDetail(sample);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(Map.of(
                "message", "failed!"
            ));
        }

        return ResponseEntity.ok(Map.of(
            "message", "success"
        ));
    }
}