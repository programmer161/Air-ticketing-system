package com.bisheflight.bisheflightmain.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bisheflight.bisheflightmain.mapper.OrderticketMapper;
import com.bisheflight.bisheflightmain.model.Flight;
import com.bisheflight.bisheflightmain.model.Orderticket;
import com.bisheflight.bisheflightmain.service.OrderticketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/*
 * 具体使用查看mybatis-plus
 * url:https://mp.baomidou.com
 * 2019/3/22
 * */

@Service
public class OrderticketServiceImpl extends ServiceImpl<OrderticketMapper, Orderticket> implements OrderticketService {
    @Resource
    OrderticketMapper orderMapper;

    public List<Flight> selectFlight(String startAirport,String endAirport){
        return orderMapper.selectFlight(startAirport,endAirport);
    }

    public List<Flight> forOrderSelect(String startAirport,String endAirport,String flightNo){
        return orderMapper.forOrderSelect(startAirport,endAirport,flightNo);
    }

    public List<Orderticket> searchByKeyword(String keyword){
        return orderMapper.searchByKeyword(keyword);
    }

    public List<Flight> deleteToSelectFlight(Date startTime, Date arrivalTime, String flightNo){
        return orderMapper.deleteToSelectFlight(startTime,arrivalTime,flightNo);
    }

    public List<Orderticket> selectOrderByID(Integer orderID){
        return orderMapper.selectOrderByID(orderID);
    }
}
