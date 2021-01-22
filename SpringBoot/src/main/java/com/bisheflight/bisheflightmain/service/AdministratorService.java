package com.bisheflight.bisheflightmain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bisheflight.bisheflightmain.Attribute;
import com.bisheflight.bisheflightmain.model.Administrator;

import java.util.List;

/*
 * 具体使用查看mybatis-plus
 * url:https://mp.baomidou.com
 * 2019/3/22
 * */
public interface AdministratorService extends IService<Administrator> {

    List<Administrator> searchByAttributes(List<Attribute> attributes);
    String login(String username,String password);
}
