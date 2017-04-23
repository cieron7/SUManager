package net.dqsy.manager.service;


import net.dqsy.manager.pojo.Function;

import java.util.List;

public interface IFunctionService {

    List<Function> findFunctionListByRole(int role);

}
