package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Date And @Time: 2022/1/18  21:28
 */
public interface PayService {
    //保存一条数据
    public int create(Payment payment);

    //根据id查询一条数据
    public Payment getPaymentById(@Param("id") long id);
}
