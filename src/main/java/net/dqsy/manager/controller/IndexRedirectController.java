package net.dqsy.manager.controller;

import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.pojo.Function;
import net.dqsy.manager.service.IAccountService;
import net.dqsy.manager.service.IFunctionService;
import net.dqsy.manager.web.util.MD5Util;
import net.dqsy.manager.web.util.ParamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("")
public class IndexRedirectController {

    @Autowired
    private IAccountService accountService;
    @Autowired
    private IFunctionService functionService;

    public static Logger logger = LoggerFactory.getLogger(IndexRedirectController.class);

    @RequestMapping("/login")
    public String logon(HttpServletRequest request, HttpServletResponse response, Model model) {

        //获取前台界面的username和password
        String username = ParamUtils.getParameter(request, "username", "");
        String password = ParamUtils.getParameter(request, "password", "");

        password = MD5Util.getMD5(password.getBytes());
        Account account = accountService.logon(username.trim(), password);
        if (account == null) {
            return "redirect:/index";
        }
        //将用户护具存入session
        request.getSession().setAttribute("currentAccount", account);
        // 权限列表
        List<Function> functions = functionService.findFunctionListByRole(account.getType());
        request.getSession().setAttribute("functions", functions);
        return "redirect:/index";
    }

    @RequestMapping(value = {"index", ""})
    public String indexPage(HttpServletRequest request, HttpServletResponse response) {
        Account account = (Account) request.getSession().getAttribute("currentAccount");
        if(account == null){
            return "login";
        }else{
            return "index";
        }

    }

}
