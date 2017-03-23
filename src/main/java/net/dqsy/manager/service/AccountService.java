package net.dqsy.manager.service;

import net.dqsy.manager.pojo.Account;

/**
 * Created by CAI on 2017/3/19.
 */

public interface AccountService {

    //用户登录
    public Account logon(String username, String password);
}
