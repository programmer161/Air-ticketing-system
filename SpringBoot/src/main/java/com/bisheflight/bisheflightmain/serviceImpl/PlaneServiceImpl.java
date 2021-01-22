package com.bisheflight.bisheflightmain.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bisheflight.bisheflightmain.mapper.PlaneMapper;
import com.bisheflight.bisheflightmain.model.Plane;
import com.bisheflight.bisheflightmain.service.PlaneService;
import org.springframework.stereotype.Service;

/*
 * 具体使用查看mybatis-plus
 * url:https://mp.baomidou.com
 * 2019/3/22
 * */

@Service
public class PlaneServiceImpl extends ServiceImpl<PlaneMapper, Plane> implements PlaneService {
}
