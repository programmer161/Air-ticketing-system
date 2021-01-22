package com.bisheflight.bisheflightmain.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bisheflight.bisheflightmain.mapper.FlightMapper;
import com.bisheflight.bisheflightmain.model.Flight;
import com.bisheflight.bisheflightmain.service.FlightService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 * 具体使用查看mybatis-plus
 * url:https://mp.baomidou.com
 * 2019/3/22
 * */

@Service
public class FlightServiceImpl extends ServiceImpl<FlightMapper, Flight> implements FlightService {
    @Resource
    FlightMapper flightMapper;

    public List<Flight> searchByKeyword(String keyword){
        return flightMapper.searchByKeyword(keyword);
    }
}
