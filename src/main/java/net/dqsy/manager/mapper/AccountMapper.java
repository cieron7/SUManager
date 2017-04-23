package net.dqsy.manager.mapper;

import net.dqsy.manager.pojo.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {

    Account findAccountByNameAndPassword(@Param("userName") String userName, @Param("userPwd") String userPwd);

    List<Account> findAccountList(@Param("types") List<Integer> types, @Param("start") int start, @Param("limit") int limit);

    int getTotalCount(@Param("types") List<Integer> types);
}
