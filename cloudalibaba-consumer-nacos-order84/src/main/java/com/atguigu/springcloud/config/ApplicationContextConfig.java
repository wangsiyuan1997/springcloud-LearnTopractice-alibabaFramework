package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Date And @Time: 2022/1/25  22:34
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced //ribbon 负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
