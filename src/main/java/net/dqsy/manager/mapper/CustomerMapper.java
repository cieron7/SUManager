package net.dqsy.manager.mapper;

import net.dqsy.manager.pojo.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CAI on 2017/3/7.
 */

public interface CustomerMapper {
    //查询所有
    List<Customer> queryCustomerList();
}
