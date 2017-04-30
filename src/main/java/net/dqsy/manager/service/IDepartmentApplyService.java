package net.dqsy.manager.service;


import net.dqsy.manager.pojo.DepartmentApply;

import java.util.List;

public interface IDepartmentApplyService {

    void add( DepartmentApply apply);

    List<DepartmentApply> findApplyList(long accountId, int start, int limit);

    int getTotalCount(long accountId);

    DepartmentApply findById(Long applyId);

    void deleteById(long id);
}
