package net.dqsy.manager.service.impl;

import net.dqsy.manager.mapper.CustomerMapper;
import net.dqsy.manager.pojo.Customer;
import net.dqsy.manager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CAI on 2017/3/7.
 */
@Service
public class CustomerServiceImpl implements CustomerService{

   @Resource
   private CustomerMapper customerMapper;

    public List<Customer> queryCustomer() {
        List<Customer> customerList = customerMapper.queryCustomerList();
        return customerList;
    }
}
