package com.bisheflight.bisheflightmain.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bisheflight.bisheflightmain.mapper.AirportMapper;
import com.bisheflight.bisheflightmain.model.Airport;
import com.bisheflight.bisheflightmain.service.AirportService;
import org.springframework.stereotype.Service;

/*
 * 具体使用查看mybatis-plus
 * url:https://mp.baomidou.com
 * 2019/3/22
 * */

@Service
public class AirportServiceImpl extends ServiceImpl<AirportMapper, Airport> implements AirportService {
}
