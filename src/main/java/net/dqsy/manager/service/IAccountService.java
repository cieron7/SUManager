package net.dqsy.manager.service;

import net.dqsy.manager.pojo.Account;

import java.util.List;

public interface IAccountService {

    //用户登录
    Account logon(String username, String password);

    List<Account> findAccountList(List<Integer> types, String userName, int start, int limit);


    int getTotalCount(List<Integer> types, String userName);

    void save(Account account);

    Account findAccountById(Long account_id);

    void update(Account oldAccount);

    void deteleById(Long account_id);
}
