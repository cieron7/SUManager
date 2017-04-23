package net.dqsy.manager.service.impl;

import net.dqsy.manager.mapper.AccountMapper;
import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {
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

    @Override
    public List<Account> findAccountList(List<Integer> types, int start, int limit) {
        return accountMapper.findAccountList(types, (start - 1) * limit, limit);
    }

    @Override
    public int getTotalCount(List<Integer> types) {
        return accountMapper.getTotalCount(types);
    }
}
