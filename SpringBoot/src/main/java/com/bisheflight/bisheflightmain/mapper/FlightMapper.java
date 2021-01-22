package com.bisheflight.bisheflightmain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bisheflight.bisheflightmain.model.Flight;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*
 * 具体使用查看mybatis-plus
 * url:https://mp.baomidou.com
 * 2019/3/22
 * */
public interface FlightMapper extends BaseMapper<Flight> {

    @Select("SELECT * FROM flight WHERE " +
            "flight_no LIKE CONCAT('%',#{keyword},'%') or " +
            "start_time LIKE CONCAT('%',#{keyword},'%') or " +
            "start_airport LIKE CONCAT('%',#{keyword},'%') or " +
            "arrival_time LIKE CONCAT('%',#{keyword},'%') or " +
            "end_airport LIKE CONCAT('%',#{keyword},'%') or " +
            "business_class_amount LIKE CONCAT('%',#{keyword},'%') or " +
            "economy_class_amount LIKE CONCAT('%',#{keyword},'%') or " +
            "first_class_amount LIKE CONCAT('%',#{keyword},'%') or " +
            "business_class_price LIKE CONCAT('%',#{keyword},'%') or " +
            "economy_class_price LIKE CONCAT('%',#{keyword},'%') or " +
            "first_class_price LIKE CONCAT('%',#{keyword},'%') or " +
            "status LIKE CONCAT('%',#{keyword},'%')")
    List<Flight> searchByKeyword(@Param("keyword")String keyword);


}
