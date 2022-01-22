package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date And @Time: 2022/1/20  17:04
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        RandomRule randomRule = new RandomRule(); //自定义随机 负载均衡
        return randomRule;
    }
}
