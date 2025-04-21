package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.UserForm;
import com.example.demo.util.Printer;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = "/form-validation")
@AllArgsConstructor
public class DemoFormController {
    
    private final Printer printer;


    @GetMapping()
    public String getForm(Model model) {
        printer._cyan("call form-validation get");
        
        model.addAttribute("userForm", new UserForm());
        return "form-validation-view";
    }

    // BindingResultは、Formのバリデーション用のアノテーションを付けたものを次の画面に渡すためのもの
    // ※BindingResultは、@ValidするFormの直後に書かないとだめ
    @PostMapping()
    public String postForm(Model model, @Valid UserForm userForm, BindingResult bindingResult) {
        printer._cyan("call form-validation post");

        // バリデーションエラーがあった場合、エラーメッセージを表示する
        if (bindingResult.hasErrors()) {
            return "form-validation-view";
        }

        model.addAttribute("message", "hello!");
        return "form-validation-view";
    }
}
