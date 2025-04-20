package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jakarta.servlet.http.HttpSession;

import com.example.demo.form.UserForm;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.GenreMapper;
import com.example.demo.util.Printer;


// @Controllerは、htmlを返すアノテーション
@Controller
public class DemoTemplateController {
    
    private final Printer printer;
    private final BookMapper bookMapper;
    private final GenreMapper genreMapper;

    public DemoTemplateController(Printer printer, BookMapper bookMapper, GenreMapper genreMapper) {
        this.printer = printer;
        this.bookMapper = bookMapper;
        this.genreMapper = genreMapper;
    }


    // ホーム画面
    @GetMapping(path = {"/", "/home"})
    public String home() {
        printer._cyan("call home");
        return "home";
    }

    // Thymeleaf画面
    @GetMapping(path = "/thymeleaf")
    public String thymeleafView (Model model, HttpSession session) {
        printer._cyan("call thymeleaf");

        // formデータをセット
        model.addAttribute("username", (String)session.getAttribute("username"));
        model.addAttribute("password", (String)session.getAttribute("password"));
        session.removeAttribute("username");
        session.removeAttribute("password");

        // modelに値をセット
        model.addAttribute("message", "hello!");
        model.addAttribute("list", new ArrayList<String>(
            Arrays.asList("one", "two", "three")
        ));
        model.addAttribute("map", new HashMap<String, Integer>(){{
            put("one", 1);
            put("two", 2);
            put("three", 3);
        }});
        model.addAttribute("userForm", new UserForm());

        
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

        return "thymeleaf-view";
    }


    // TODO: userForm用のページ作成
    @RequestMapping(path="/thymeleaf/user-send", method=RequestMethod.POST)
    public String postUserSendView(@Validated UserForm userForm, BindingResult bindingResult, HttpSession session) {
        printer._cyan("call user-send");  
        printer._pink(userForm);

        if(bindingResult.hasErrors()) {
            printer._red("validation error", bindingResult.getAllErrors());
        }

        session.setAttribute("username", userForm.getUsername());
        session.setAttribute("password", userForm.getPassword());

        return "redirect:/thymeleaf";
    }

    // RestAPI画面
    @GetMapping(path = "/api")
    public String apiView () {
        printer._cyan("call api");
        return "api-view";
    }
}

