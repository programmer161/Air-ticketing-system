package com.bisheflight.bisheflightmain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bisheflight.bisheflightmain.model.Flight;

import java.util.List;

/*
 * 具体使用查看mybatis-plus
 * url:https://mp.baomidou.com
 * 2019/3/22
 * */
public interface FlightService extends IService<Flight> {
    List<Flight> searchByKeyword(String keyword);
}
