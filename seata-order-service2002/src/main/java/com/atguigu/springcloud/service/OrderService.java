package com.atguigu.springcloud.service;

import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date And @Time: 2022/1/26  19:04
 */
public interface OrderService {

    public void create(Order order);
}
