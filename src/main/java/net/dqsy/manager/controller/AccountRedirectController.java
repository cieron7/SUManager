package net.dqsy.manager.controller;

import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.service.IAccountService;
import net.dqsy.manager.web.util.PageUtil;
import net.dqsy.manager.web.util.ParamUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
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
        int totalCount = accountService.getTotalCount(Arrays.asList(account.getType()));
        List<Account> accountList = accountService.findAccountList(Arrays.asList(account.getType()), start, limit);

        String pagation = PageUtil.getPagation("/accountRedirectController.do?action=list", totalCount, start, limit);

        ModelAndView mav = new ModelAndView("account/list");
        mav.getModel().put("accountList", accountList);
        mav.getModel().put("pageCode", pagation);
        return mav;
    }


}
