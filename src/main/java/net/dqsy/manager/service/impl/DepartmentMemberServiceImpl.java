package net.dqsy.manager.service.impl;

import net.dqsy.manager.mapper.DepartmentMemberMapper;
import net.dqsy.manager.pojo.Account;
import net.dqsy.manager.service.IDepartmentMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentMemberServiceImpl implements IDepartmentMemberService{
    @Autowired
    private DepartmentMemberMapper departmentMemberMapper;
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
}
