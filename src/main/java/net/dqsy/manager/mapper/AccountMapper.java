package net.dqsy.manager.mapper;

import net.dqsy.manager.pojo.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {

    Account findAccountByNameAndPassword(@Param("userName") String userName, @Param("userPwd") String userPwd);

    List<Account> findAccountList(@Param("types") List<Integer> types,@Param("userName") String userName, @Param("start") int start, @Param("limit") int limit);

    int getTotalCount(@Param("types") List<Integer> types,@Param("userName") String userName);

    void save(@Param("account") Account account);

    Account findAccountById(@Param("accountId") Long accountId);

    void update(@Param("account") Account oldAccount);

    void deleteById(@Param("account_id")Long account_id);
}
