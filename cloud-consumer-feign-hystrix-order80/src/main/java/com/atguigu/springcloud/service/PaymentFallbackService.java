package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Date And @Time: 2022/1/21  15:30
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "-----PaymentFallbackService fall back-->paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-->paymentInfo_OK , (┬＿┬)";
    }
}
