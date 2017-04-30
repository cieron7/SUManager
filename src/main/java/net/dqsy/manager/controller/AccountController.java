package net.dqsy.manager.controller;

import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.service.IAccountService;
import net.dqsy.manager.web.util.IpUtil;
import net.dqsy.manager.web.util.LocalizationUtil;
import net.dqsy.manager.web.util.MD5Util;
import net.dqsy.manager.web.util.PageUtil;
import net.dqsy.manager.web.util.ParamUtils;
import net.dqsy.manager.web.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController{

    @Autowired
    private IAccountService accountService;
    @RequestMapping(value = "list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response){

        Account account = (Account) request.getSession().getAttribute("currentAccount");

        int start = ParamUtils.getIntParameter(request, "page", 1);
        int limit = ParamUtils.getIntParameter(request, "limit", 10);
        String userName = ParamUtils.getParameter(request, "s_userName");
        if(StringUtils.isBlank(userName) || "null".equals(userName)){
            userName = null;
        }

        int totalCount = accountService.getTotalCount(Arrays.asList(Account.ACCOUNT_MANAGER, Account.ACCOUNT_STUDENT), userName);
        List<Account> accountList = accountService.findAccountList(Arrays.asList(Account.ACCOUNT_MANAGER, Account.ACCOUNT_STUDENT), userName, start, limit);

        String pagation = PageUtil.getPagation("/account/list&s_userName=" + userName, totalCount, start, limit);

        ModelAndView mav = new ModelAndView("account/list");
        mav.getModel().put("accountList", accountList);
        mav.getModel().put("pageCode", pagation);
        return mav;
    }
    @RequestMapping(value = "add")
    public void add(HttpServletRequest request, HttpServletResponse response){

        Long account_id = ParamUtils.getLongParameter(request, "account_id", 0L);
        String username = ParamUtils.getParameter(request, "username");
        int sex = ParamUtils.getIntParameter(request, "sex", 1);
        String mobile = ParamUtils.getParameter(request, "mobile");
        String email = ParamUtils.getParameter(request, "email", "");
        String screenName = ParamUtils.getParameter(request, "screenName", "");


        if(account_id == 0L || StringUtils.isBlank(username)){
            ResultUtil.fail(LocalizationUtil.getClientString("Account_22", request), response);
            return;
        }


        Account oldAccount = accountService.findAccountById(account_id);
        if(oldAccount != null){
            oldAccount.setId(account_id);
            oldAccount.setUsername(username);
            oldAccount.setMobile(mobile);
            oldAccount.setSex(sex);
            oldAccount.setEmail(email);
            oldAccount.setScreenName(screenName);
            accountService.update(oldAccount);
        }else{
            Account account = new Account();
            account.setId(account_id);
            account.setUsername(username);
            account.setMobile(mobile);
            account.setSex(sex);
            account.setCreateTime(new Date());
            account.setActivated(true);
            account.setEnabled(true);
            account.setRegisterIp(IpUtil.getIpStr(request));
            account.setPassword(MD5Util.getMD5("123456".getBytes()));
            account.setScreenName(username);
            account.setLocale(request.getLocale().getLanguage() +"_"+request.getLocale().getCountry());
            account.setRegisterTime(new Date());
            account.setCreateTime(new Date());
            account.setType(Account.ACCOUNT_STUDENT);
            accountService.save(account);
        }

        ResultUtil.success(response);

    }
    @RequestMapping(value = "detail")
    public void detail(HttpServletRequest request, HttpServletResponse response){
        Long account_id = ParamUtils.getLongParameter(request, "account_id", 0L);
        if(account_id == 0L){
            ResultUtil.fail(LocalizationUtil.getClientString("Account_22", request), response);
            return;
        }

        Account account = accountService.findAccountById(account_id);
        ResultUtil.success(account, response);

    }
    @RequestMapping(value = "delete")
    public void delete(HttpServletRequest request, HttpServletResponse response){
        Long account_id = ParamUtils.getLongParameter(request, "account_id", 0L);
        if(account_id == 0L){
            ResultUtil.fail(LocalizationUtil.getClientString("Account_22", request), response);
            return;
        }
        accountService.deteleById(account_id);

        Account account = accountService.findAccountById(account_id);
        ResultUtil.success(account, response);

    }



}
