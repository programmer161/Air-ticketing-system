package com.bisheflight.bisheflightmain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bisheflight.bisheflightmain.model.Customer;

import java.util.List;

/*
 * 具体使用查看mybatis-plus
 * url:https://mp.baomidou.com
 * 2019/3/22
 * */
public interface CustomerService extends IService<Customer> {

    String login(String mobilePhone,String password);

    List<Customer> searchByKeyword(String keyword);
}
