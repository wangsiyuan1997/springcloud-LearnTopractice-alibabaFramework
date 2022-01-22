package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @Date And @Time: 2022/1/21  11:06
 */
public interface PaymentService {
    //成功
    public String paymentInfo_Ok(Integer id);
    //失败
    public String paymentInfo_TimeOut(Integer id);
    //失败则启用的方法
    public String paymentInfo_TimeOutHandler(Integer id);

    //服务熔断测试方法
    public String paymentCircuitBreaker(Integer id);
    //服务熔断测试方法的兜底方法
    public String paymentCircuitBreaker_fallback(Integer id);
}
