package net.dqsy.manager.service.impl;

import net.dqsy.manager.mapper.DepartmentMemberMapper;
import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.pojo.DepartmentMember;
import net.dqsy.manager.service.IDepartmentMemberService;
import net.dqsy.manager.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentMemberServiceImpl implements IDepartmentMemberService{
    @Autowired
    private DepartmentMemberMapper departmentMemberMapper;
    @Autowired
    private IDepartmentService departmentService;
    @Override
    public List<Account> findDepartMemberList(long departmentId, int start, int limit) {
        return departmentMemberMapper.findDepartmentMemberList(departmentId, (start - 1) * limit, limit);
    }

    @Override
    public int getTotalCount(long id) {
        return departmentMemberMapper.getTotalCount(id);
    }

    @Override
    public void delete(long departmentId, long accountId) {
        departmentMemberMapper.delete(departmentId, accountId);
    }

    @Override
    public void insert(DepartmentMember member) {
        departmentMemberMapper.insert(member);
    }

    @Override
    public Account findManager(long departmentId, int role) {
        List<Account> members = departmentMemberMapper.findManager(departmentId, role);
        if(members.size() > 0){
            Account account = members.get(0);
            return account;
        }
        return null;
    }

    @Override
    public DepartmentMember findMemberByAccountId(long accountId) {
        List<DepartmentMember> memberList = departmentMemberMapper.findMemberByAccountId(accountId);
        if(memberList.size() > 0){
            return memberList.get(0);
        }
        return null;
    }
}
