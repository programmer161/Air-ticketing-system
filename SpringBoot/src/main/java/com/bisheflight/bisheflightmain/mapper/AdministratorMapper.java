package com.bisheflight.bisheflightmain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bisheflight.bisheflightmain.Attribute;
import com.bisheflight.bisheflightmain.model.Administrator;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/*
* 具体使用查看mybatis-plus
* url:https://mp.baomidou.com
* 无需编写.xml
* 复杂sql语句还需自行编写.xml
* 2019/3/22
* */
public interface AdministratorMapper extends BaseMapper<Administrator> {
   /**
     * <p>
     * 插入一条记录
     * </p>
     *
     * @param entity 实体对象
     * @return 插入成功记录数

   int insert(Administrator administrator);

    /**
     * <p>
     * 根据 ID 删除
     * </p>
     *
     * @param id 主键ID
     * @return 删除成功记录数

    int deleteById(Integer id);

    /**
     * <p>
     * 根据 ID 查询
     * </p>
     *
     * @param id 主键ID
     * @return 实体


   /* Administrator selectById(Integer id);*/

    /**
     * <p>
     * 根据 ID 修改
     * </p>
     *
     * @param entity 实体对象
     * @return 修改成功记录数

    int updateById(Administrator administrator);
*/

    List<Administrator> searchByAttributes(List<Attribute> attributes);

    @Select("select username from administrator where username=#{username} and password=#{password}")
    String login(@Param("username") String username,@Param("password") String password);

}
