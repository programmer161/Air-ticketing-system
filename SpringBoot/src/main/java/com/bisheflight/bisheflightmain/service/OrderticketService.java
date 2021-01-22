package com.bisheflight.bisheflightmain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bisheflight.bisheflightmain.model.Flight;
import com.bisheflight.bisheflightmain.model.Orderticket;

import java.util.Date;
import java.util.List;

/*
 * 具体使用查看mybatis-plus
 * url:https://mp.baomidou.com
 * 2019/3/22
 * */
public interface OrderticketService extends IService<Orderticket> {

    List<Flight> selectFlight(String startAirport,String endAirport);

    List<Flight> forOrderSelect(String startAirport,String endAirport,String flightNo);

    List<Orderticket> searchByKeyword(String keyword);

    List<Flight> deleteToSelectFlight(Date startTime, Date arrivalTime, String flightNo);

    List<Orderticket> selectOrderByID(Integer orderID);
}
