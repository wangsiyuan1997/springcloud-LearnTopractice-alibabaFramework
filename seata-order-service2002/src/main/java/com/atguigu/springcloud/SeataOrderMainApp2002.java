package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Date And @Time: 2022/1/26  17:52
 */
//取消数据源自动创建，把数据源交给seata
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableDiscoveryClient
public class SeataOrderMainApp2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMainApp2002.class,args);
    }
}
