package com.example.demo.form;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    
    @NotBlank(message = "ユーザ名は必須")
    private String username;

    @NotBlank(message = "パスワードは必須")
    private String password;


    @AssertTrue(message = "そういう悪いことするの良くないよ!")
    public boolean isInjection() {
        if(username == null || password == null) {
            return true;
        }
        if(username.equals("root") && password.equals("root")) {
            return false;
        } 
        return true;
    }

}
