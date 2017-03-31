package net.dqsy.manager.service.impl;

import net.dqsy.manager.mapper.AccountMapper;
import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by CAI on 2017/3/19.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account logon(String username, String password) {
        //查询用户信息
        Account account = accountMapper.findAccountByNameAndPassword(username, password);
        //用户信息不为空切用户输入的密码与数据库的密码相同,返回用户信息
        if (account != null) {
            return account;
        }
        return null;
    }
}
