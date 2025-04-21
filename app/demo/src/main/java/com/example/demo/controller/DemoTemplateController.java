package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.util.Printer;


// @Controllerは、htmlを返すアノテーション
@Controller
public class DemoTemplateController {
    
    @Autowired
    private Printer printer;


    // ホーム画面
    @GetMapping(path = {"/", "/home"})
    public String getHome() {
        printer._cyan("call home");
        return "home";
    }

    
    // RestAPI画面
    @GetMapping(path = "/api")
    public String getApi () {
        printer._cyan("call api");
        return "api-view";
    }
}

