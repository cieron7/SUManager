package net.dqsy.manager.mapper;


import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.pojo.DepartmentMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMemberMapper {

    List<Account> findDepartmentMemberList(@Param("departmentId") long departmentId, @Param("start") int start, @Param("limit") int limit);

    int getTotalCount(@Param("departmentId") long id);

    void delete(@Param("departmentId") long departmentId, @Param("accountId") long accountId);

    void insert(@Param("member") DepartmentMember member);

    List<Account> findManager(@Param("departmentId") long departmentId, @Param("role") int role);
}
