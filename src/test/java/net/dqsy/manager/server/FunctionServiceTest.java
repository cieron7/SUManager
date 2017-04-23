package net.dqsy.manager.server;

import net.dqsy.manager.pojo.Function;
import net.dqsy.manager.service.IFunctionService;
import net.dqsy.manager.test.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Nathan on 2017/4/20.
 */
public class FunctionServiceTest extends BaseTest {
    @Autowired
    private IFunctionService functionService;
    @Test
    public void findFunctionListByAccountTest(){
        List<Function> functionListByRole = functionService.findFunctionListByRole(1);
        for (Function function : functionListByRole) {
            System.out.println(function.getName());
        }
    }

}
