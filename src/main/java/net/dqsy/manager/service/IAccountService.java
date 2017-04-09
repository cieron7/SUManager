package net.dqsy.manager.service;

import net.dqsy.manager.pojo.Account;

import java.util.List;

public interface IAccountService {

    //用户登录
    Account logon(String username, String password);

    List<Account> findAccountList(List<String> types, int start, int limit);


}
