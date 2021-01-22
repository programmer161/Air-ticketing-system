package com.bisheflight.bisheflightmain.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bisheflight.bisheflightmain.Attribute;
import com.bisheflight.bisheflightmain.mapper.AdministratorMapper;
import com.bisheflight.bisheflightmain.model.Administrator;
import com.bisheflight.bisheflightmain.service.AdministratorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/*
 * 具体使用查看mybatis-plus
 * url:https://mp.baomidou.com
 * 2019/3/22
 * */

@Service
public class AdministratorServiceImpl extends ServiceImpl<AdministratorMapper,Administrator> implements AdministratorService {

    @Resource
    private AdministratorMapper administratorMapper;

    public List<Administrator> searchByAttributes(List<Attribute> attributes){
        return administratorMapper.searchByAttributes(attributes);
    }

    public String login(String username,String password)
    {
        return administratorMapper.login(username,password);
    }
}
