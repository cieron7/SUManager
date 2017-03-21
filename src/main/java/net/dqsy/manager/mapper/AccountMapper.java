package net.dqsy.manager.mapper;

import net.dqsy.manager.pojo.Account;
import org.springframework.stereotype.Repository;

/**
 * Created by CAI on 2017/3/19.
 *
 * 对用户的操作
 */

public interface AccountMapper {

    public Account getAccountByName(String username);
}
