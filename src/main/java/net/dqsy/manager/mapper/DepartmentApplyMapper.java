package net.dqsy.manager.mapper;


import net.dqsy.manager.pojo.DepartmentApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentApplyMapper {
    void save(@Param("departmentApply") DepartmentApply departmentApply);

    List<DepartmentApply> findApplyList(@Param("accountId") long accountId,@Param("start") int start,@Param("limit") int limit);

    int getTotalCount(@Param("accountId") long accountId);

    DepartmentApply findById(@Param("applyId") Long applyId);

    void deleteById(@Param("applyId") Long applyId);
}
