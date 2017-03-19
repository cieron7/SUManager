package net.dqsy.manager.controller;

import net.dqsy.manager.web.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by CAI on 2017/3/12.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    public static Logger logger = LoggerFactory.getLogger(LoginController.class);

    //登录界面
    @RequestMapping("/login")
    public String  login(){

        logger.info("-------userName:------------Pwd:---------");
        String test = RedisUtil.get("test");
        RedisUtil.set("mygod","dfd", -1);
        System.out.println(test);
        return "page/login";

    }
}
