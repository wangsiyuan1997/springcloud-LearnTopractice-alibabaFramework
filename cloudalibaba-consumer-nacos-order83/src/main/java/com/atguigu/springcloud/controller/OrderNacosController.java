package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Date And @Time: 2022/1/24  14:03
 */
@RestController
public class OrderNacosController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String PaymentInfo(@PathVariable("id") Integer id){
        String restTemplateForObject = restTemplate.getForObject(serverURL + "/payment/nacos/" + id, String.class);
        return restTemplateForObject;
    }
}
