package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Date And @Time: 2022/1/18  21:00
 */
@Mapper
@Component
public interface PaymentDao {

    //保存一条数据
    public int create(Payment payment);

    //根据id查询一条数据
    public Payment getPaymentById(@Param("id") long id);
}
