package com.bisheflight.bisheflightmain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bisheflight.bisheflightmain.model.Customer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
 * 具体使用查看mybatis-plus
 * url:https://mp.baomidou.com
 * 2019/3/22
 * */
public interface CustomerMapper extends BaseMapper<Customer> {

    //使用@Select时属性名无需转换下划线，直接使用数据库中的属性名
    @Select("select mobile_phone from customer where mobile_phone=#{mobilePhone} and password=#{password}")
    String login(@Param("mobilePhone") String mobilePhone, @Param("password") String password);

    @Select("SELECT * FROM customer WHERE " +
            "nick_name LIKE CONCAT('%',#{keyword},'%') or " +
            "real_name LIKE CONCAT('%',#{keyword},'%') or " +
            "sex LIKE CONCAT('%',#{keyword},'%') or " +
            "mobile_phone LIKE CONCAT('%',#{keyword},'%') or " +
            "email LIKE CONCAT('%',#{keyword},'%') or " +
            "birthday LIKE CONCAT('%',#{keyword},'%')")
    List<Customer> searchByKeyword(@Param("keyword")String keyword);
}
