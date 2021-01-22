package com.bisheflight.bisheflightmain.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bisheflight.bisheflightmain.mapper.CustomerMapper;
import com.bisheflight.bisheflightmain.model.Customer;
import com.bisheflight.bisheflightmain.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 * 具体使用查看mybatis-plus
 * url:https://mp.baomidou.com
 * 2019/3/22
 * */

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Resource CustomerMapper customerMapper;

    public String login(String mobilePhone,String password){
        return customerMapper.login(mobilePhone,password);
    }

    public List<Customer> searchByKeyword(String keyword){
        return customerMapper.searchByKeyword(keyword);
    }
}
