package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Date And @Time: 2022/1/20  14:46
 */
@RestController
public class OrderConsulController {
    @Autowired
    private RestTemplate restTemplate;

    private String INVOKE_URL = "http://consul-provider-payment";

    @GetMapping(value = "/consumer/payment/consul")
    public String payment(){
        String template = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return template;

    }
}
