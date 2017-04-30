package net.dqsy.manager.service.impl;


import net.dqsy.manager.mapper.DepartmentApplyMapper;
import net.dqsy.manager.pojo.DepartmentApply;
import net.dqsy.manager.service.IDepartmentApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentApplyServiceImpl implements IDepartmentApplyService{
    @Autowired
    private DepartmentApplyMapper departmentApplyMapper;

    @Override
    public void add(DepartmentApply apply) {
        departmentApplyMapper.insert(apply);
    }
}
