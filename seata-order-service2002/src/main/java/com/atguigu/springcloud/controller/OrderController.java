package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date And @Time: 2022/1/26  19:30
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult<Order> create(Order order){
        orderService.create(order);
        return new CommonResult<>(200,"订单创建成功!");
    }
}
