package net.dqsy.manager.server;


import net.dqsy.manager.pojo.Department;
import net.dqsy.manager.service.IDepartmentService;
import net.dqsy.manager.test.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class DepartmentServiceTest extends BaseTest {
    @Autowired
    private IDepartmentService departmentService;

    @Test
    public void findListTest(){
        List<Department> list = departmentService.findList(1L, 1, 10);
        Department department = list.get(0);
        System.out.println(department.getDescription());
    }
    @Test
    public void addTest(){
        Department department = new Department();
        department.setCreateTime(new Date());
        department.setDescription("没有描述");
        department.setFunction("没有职能");
        department.setGoal("没有目标");
        department.setName("没有名字");
        department.setOrgId(1L);
        department.setPhotoUrl("www.baidu.com");
        departmentService.add(department);
    }

}
