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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class AccountRedirectController extends MultiActionController {

    private IAccountService accountService;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public ModelAndView list(HttpServletRequest request, HttpServletResponse response){

        Account account = (Account) request.getSession().getAttribute("currentAccount");

        int start = ParamUtils.getIntParameter(request, "page", 1);
        int limit = ParamUtils.getIntParameter(request, "limit", 50);

//        List<Integer> types = new ArrayList<Integer>();
//        types.add(Account.ACCOUNT_MANAGER);
//        types.add(Account.ACCOUNT_STUDENT);
        int totalCount = accountService.getTotalCount(Arrays.asList(Account.ACCOUNT_MANAGER, Account.ACCOUNT_STUDENT));
        List<Account> accountList = accountService.findAccountList(Arrays.asList(Account.ACCOUNT_MANAGER, Account.ACCOUNT_STUDENT), start, limit);

        String pagation = PageUtil.getPagation("/accountRedirectController.do?action=list", totalCount, start, limit);

        ModelAndView mav = new ModelAndView("account/list");
        mav.getModel().put("accountList", accountList);
        mav.getModel().put("pageCode", pagation);
        return mav;
    }

    public void add(HttpServletRequest request, HttpServletResponse response){

        Long account_id = ParamUtils.getLongParameter(request, "account_id", 0L);
        String username = ParamUtils.getParameter(request, "username");
        int sex = ParamUtils.getIntParameter(request, "sex", 1);
        String mobile = ParamUtils.getParameter(request, "mobile");

        if(account_id == 0L || StringUtils.isBlank(username)){
            ResultUtil.fail(LocalizationUtil.getClientString("Account_22", request), response);
            return;
        }

        Account oldAccount = accountService.findAccountById(account_id);
        if(oldAccount != null){
            ResultUtil.fail("当前学号的学生已经存在！", response);
            return ;
        }

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
        ResultUtil.success(response);

    }


}
