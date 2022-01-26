package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Date And @Time: 2022/1/26  17:59
 */
@Mapper
public interface OrderDao {


    public void create(Order order);

    public void update(@Param("userId") long userId,@Param("status") Integer status);
}
