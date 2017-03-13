package net.dqsy.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by CAI on 2017/3/12.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    //登录界面
    @RequestMapping("/login")
    public String  login(){
        return "page/login";

    }
}
