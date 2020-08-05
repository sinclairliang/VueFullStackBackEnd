package com.evan.wj.controller;

import com.evan.wj.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import com.evan.wj.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

@Controller
public class LoginController {
    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(User requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        System.out.println(username);
        if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
            String message = "Login Error";
            System.out.println("test");
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}

