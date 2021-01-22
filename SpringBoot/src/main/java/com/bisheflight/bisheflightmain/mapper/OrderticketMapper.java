package com.bisheflight.bisheflightmain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bisheflight.bisheflightmain.model.Flight;
import com.bisheflight.bisheflightmain.model.Orderticket;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/*
 * 具体使用查看mybatis-plus
 * url:https://mp.baomidou.com
 * 2019/3/22
 * */
public interface OrderticketMapper extends BaseMapper<Orderticket> {

    @Select("SELECT * FROM flight WHERE start_airport=#{startAirport} AND end_airport=#{endAirport}")
    List<Flight> selectFlight(@Param("startAirport") String startAirport,@Param("endAirport") String endAirport);

    @Select("SELECT * FROM flight WHERE start_airport=#{startAirport} AND end_airport=#{endAirport} AND flight_no=#{flightNo}")
    List<Flight> forOrderSelect(@Param("startAirport") String startAirport,@Param("endAirport") String endAirport,@Param("flightNo") String flightNo);

    @Select("SELECT * FROM orderticket WHERE " +
            "order_no LIKE CONCAT('%',#{keyword},'%') or " +
            "start_city LIKE CONCAT('%',#{keyword},'%') or " +
            "end_city LIKE CONCAT('%',#{keyword},'%') or " +
            "arrival_time LIKE CONCAT('%',#{keyword},'%') or " +
            "start_time LIKE CONCAT('%',#{keyword},'%') or " +
            "person LIKE CONCAT('%',#{keyword},'%') or " +
            "phone LIKE CONCAT('%',#{keyword},'%') or " +
            "order_status LIKE CONCAT('%',#{keyword},'%') or " +
            "idcard LIKE CONCAT('%',#{keyword},'%') or " +
            "create_time LIKE CONCAT('%',#{keyword},'%') or " +
            "price LIKE CONCAT('%',#{keyword},'%') or " +
            "flight_class LIKE CONCAT('%',#{keyword},'%') or " +
            "flight_no LIKE CONCAT('%',#{keyword},'%')")
    List<Orderticket> searchByKeyword(@Param("keyword")String keyword);

    //删除时查询飞机表
    @Select("SELECT * FROM flight WHERE start_time=#{startTime} AND arrival_time=#{arrivalTime} AND flight_no=#{flightNo}")
    List<Flight> deleteToSelectFlight(@Param("startTime") Date startTime, @Param("arrivalTime") Date arrivalTime, @Param("flightNo") String flightNo);

    //根据ID查
    @Select("SELECT * FROM orderticket WHERE id=#{id}")
    List<Orderticket> selectOrderByID(@Param("id") Integer orderID);
}
