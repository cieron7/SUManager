package net.dqsy.manager.service.impl;

import net.dqsy.manager.mapper.DepartmentMapper;
import net.dqsy.manager.pojo.Department;
import net.dqsy.manager.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService{
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> findList(long orgId, int start, int limit) {
        return departmentMapper.findList(orgId, (start - 1) * limit, limit);
    }

    @Override
    public void add(Department department) {
        departmentMapper.add(department);
    }

    @Override
    public int getTotalCount(long orgId) {
        return departmentMapper.getTotalCount(orgId);
    }

    @Override
    public Department findDepartmentById(Long departmentId) {
        return departmentMapper.findDepartmentById(departmentId);
    }

    @Override
    public void deleteById(Long departmentId) {
        departmentMapper.deleteById(departmentId);
    }

    @Override
    public void save(Department department) {
        departmentMapper.add(department);
    }
}
