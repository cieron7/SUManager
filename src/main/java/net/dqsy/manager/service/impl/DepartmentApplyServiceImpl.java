package net.dqsy.manager.service.impl;


import net.dqsy.manager.mapper.DepartmentApplyMapper;
import net.dqsy.manager.pojo.DepartmentApply;
import net.dqsy.manager.service.IDepartmentApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentApplyServiceImpl implements IDepartmentApplyService{
    @Autowired
    private DepartmentApplyMapper departmentApplyMapper;

    @Override
    public void add(DepartmentApply apply) {
        departmentApplyMapper.save(apply);
    }

    @Override
    public List<DepartmentApply> findApplyList(long accountId, int start, int limit) {
        return departmentApplyMapper.findApplyList(accountId, (start - 1) * limit, limit);
    }

    @Override
    public int getTotalCount(long accountId) {
        return departmentApplyMapper.getTotalCount(accountId);
    }

    @Override
    public DepartmentApply findById(Long applyId) {
        return departmentApplyMapper.findById(applyId);
    }

    @Override
    public void deleteById(long id) {
        departmentApplyMapper.deleteById(id);
    }

    @Override
    public void update(long applyId, int status) {
        departmentApplyMapper.update(applyId, status);
    }
}
