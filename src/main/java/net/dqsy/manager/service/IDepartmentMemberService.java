package net.dqsy.manager.service;


import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.pojo.DepartmentMember;

import java.util.List;

public interface IDepartmentMemberService {

    List<Account> findDepartMemberList(long departmentId, int start, int limit);

    int getTotalCount(long id);

    void delete(long departmentId, long accountId);

    void insert(DepartmentMember member);

    Account findManager(long departmentId, int role);

    DepartmentMember findMemberByAccountId(long accountId);
}
