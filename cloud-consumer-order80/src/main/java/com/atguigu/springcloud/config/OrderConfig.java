package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Date And @Time: 2022/1/19  16:11
 */
@Configuration
public class OrderConfig {

    @Bean
    @LoadBalanced//赋予RestTemplate 负载均衡注解的能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
