package net.dqsy.manager.service.impl;

import net.dqsy.manager.mapper.AccountMapper;
import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.service.AccountService;
import net.dqsy.manager.web.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by CAI on 2017/3/19.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account logon(String username,String password) {
        //查询用户信息
        Account account = accountMapper.getAccountByName(username);
        //用户信息不为空切用户输入的密码与数据库的密码相同,返回用户信息
        try {
            if (account != null && account.getPassword().equals(MD5Util.EncoderByMd5(password))){
                //将用户数据存入redis缓存
                
                return account;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //否则返回null
        return null;
    }
}
