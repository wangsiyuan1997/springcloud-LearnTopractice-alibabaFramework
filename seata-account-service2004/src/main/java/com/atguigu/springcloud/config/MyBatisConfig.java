package com.atguigu.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Date And @Time: 2022/1/26  19:33
 */
@Configuration
@MapperScan({"com.atguigu.springcloud.dao"})
public class MyBatisConfig {

}
