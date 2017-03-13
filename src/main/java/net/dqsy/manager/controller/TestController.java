package net.dqsy.manager.controller;


import net.dqsy.manager.pojo.Customer;
import net.dqsy.manager.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CAI on 2017/3/7.
 */
@Controller
@RequestMapping("/Test")
public class TestController {
    @Resource
    private CustomerService customerService;


    //查询列表
    @RequestMapping("/list.action")
    public String List(){
        List<Customer> list = customerService.queryCustomer();
        System.err.println(list);
        return "ok";
    }
    //主页
    @RequestMapping("/index.action")
    public String index(){
        return "index";
    }
}
