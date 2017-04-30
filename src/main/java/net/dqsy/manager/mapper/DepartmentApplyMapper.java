package net.dqsy.manager.mapper;


import net.dqsy.manager.pojo.DepartmentApply;
import org.apache.ibatis.annotations.Param;

public interface DepartmentApplyMapper {
    void insert(@Param("apply") DepartmentApply apply);
}
