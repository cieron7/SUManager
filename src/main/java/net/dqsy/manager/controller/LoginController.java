package net.dqsy.manager.controller;

import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.service.AccountService;
import net.dqsy.manager.web.util.ParamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by CAI on 2017/3/12.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    public static Logger logger = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    private AccountService accountService;
    @RequestMapping("/")
    public String index(){
        // TODO: 2017/3/25 判断是否登陆 可以在拦截器中配置
        if(true){
            return "redirect:login.html";
        }else{
            return "redirect:index.html";
        }
    }


    //登录功能
    @RequestMapping("/logon")
    public String logon(HttpServletRequest request, HttpServletResponse response , Model model){
        //获取前台界面的username和password
        String username = ParamUtils.getParameter(request, "username", "");
        String password = ParamUtils.getParameter(request, "password", "");
        Account account = accountService.logon(username.trim(), password);
        if(account == null) {
            model.addAttribute(username);
            model.addAttribute("msg","用户名或密码错误");
            return "forward:/login";
        }
        //将用户护具存入session
        request.getSession().setAttribute("username",username);
        return "page/manager";
    }
}
