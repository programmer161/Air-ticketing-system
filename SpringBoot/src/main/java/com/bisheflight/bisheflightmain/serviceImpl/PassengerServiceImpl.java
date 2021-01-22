package com.bisheflight.bisheflightmain.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bisheflight.bisheflightmain.mapper.PassengerMapper;
import com.bisheflight.bisheflightmain.model.Passenger;
import com.bisheflight.bisheflightmain.service.PassengerService;
import org.springframework.stereotype.Service;

/*
 * 具体使用查看mybatis-plus
 * url:https://mp.baomidou.com
 * 2019/3/22
 * */

@Service
public class PassengerServiceImpl extends ServiceImpl<PassengerMapper, Passenger> implements PassengerService {
}
