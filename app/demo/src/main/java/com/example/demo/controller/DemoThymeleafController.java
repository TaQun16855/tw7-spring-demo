package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.DemoThymeleafService;
import com.example.demo.util.Printer;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/thymeleaf")
public class DemoThymeleafController {

    private final Printer printer;
    private final DemoThymeleafService demoThymeleafService;
    
    // Thymeleaf画面
    @GetMapping()
    public String getThymeleaf (Model model, HttpSession session) {
        printer._cyan("call thymeleaf");

        // modelに値をセット
        model = demoThymeleafService.setModel(model);

        return "thymeleaf-view";
    }

}
