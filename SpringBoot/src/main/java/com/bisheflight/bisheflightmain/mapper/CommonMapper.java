package com.bisheflight.bisheflightmain.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/*
* passenger and order
* 2019/3/25
* */
public interface CommonMapper {
    @Insert("INSERT INTO order_passenger(orderid,passengerid    ) VALUES (#{orderid},#{passengerid})")
    int insertOrderAndPassenger(@Param("orderid")int orderid,@Param("passengerid")int passengerid);

    @Select("select * from order_passenger where orderid=#{orderid}")
    List<Map<String,Object>> searchPassengerByOrderId(@Param("orderid")int orderid);

    @Delete("delete from order_passenger where id=#{id}")
    int deleteOrderAndPassenger(@Param("id")int id);
}
