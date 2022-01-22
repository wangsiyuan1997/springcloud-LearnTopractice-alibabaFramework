package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Date And @Time: 2022/1/20  4:16
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String INVOKE_URL = "http://cloud-payment-service";

    @GetMapping("/consumerzk/payment/zk")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }
}
