package net.dqsy.manager.controller;

import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.service.IAccountService;
import net.dqsy.manager.web.util.PageUtil;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


public class AccountRedirectController extends MultiActionController {

    private IAccountService accountService;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
        List<String> types = new ArrayList<String>();
        types.add(Account.ACCOUNT_MANAGER);
        types.add(Account.ACCOUNT_STUDENT);
        List<Account> accountList = accountService.findAccountList(types, 1, 10);

        String pagation = PageUtil.getPagation("", 100, 5, 5);

        ModelAndView mav = new ModelAndView("account/list");
        mav.getModel().put("accountList", accountList);
        mav.getModel().put("pageCode", pagation);
        return mav;
    }
}
