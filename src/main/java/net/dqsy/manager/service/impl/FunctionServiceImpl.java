package net.dqsy.manager.service.impl;

import net.dqsy.manager.mapper.FunctionMapper;
import net.dqsy.manager.pojo.Function;
import net.dqsy.manager.service.IFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionServiceImpl implements IFunctionService {
    @Autowired
    private FunctionMapper functionMapper;
    @Override
    public List<Function> findFunctionListByRole(int role) {
        return functionMapper.findFunctionListByRole(role);
    }
}
