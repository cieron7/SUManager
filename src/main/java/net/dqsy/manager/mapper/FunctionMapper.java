package net.dqsy.manager.mapper;


import net.dqsy.manager.pojo.Function;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FunctionMapper {

    List<Function> findFunctionListByRole(@Param("role")int role);
}
