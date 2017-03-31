package net.dqsy.manager.mapper;

import net.dqsy.manager.pojo.Account;
import org.apache.ibatis.annotations.Param;

/**
 * Created by CAI on 2017/3/19.
 * 对用户的操作
 */

public interface AccountMapper {

    Account findAccountByNameAndPassword(@Param("userName") String userName, @Param("userPwd") String userPwd);
}
