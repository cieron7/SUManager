package net.dqsy.manager.mapper;


import net.dqsy.manager.pojo.DepartmentApply;
import org.apache.ibatis.annotations.Param;

public interface DepartmentApplyMapper {
    void save(@Param("departmentApply") DepartmentApply departmentApply);
}
