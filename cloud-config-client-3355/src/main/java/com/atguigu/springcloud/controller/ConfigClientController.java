package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date And @Time: 2022/1/23  16:11
 */
@RestController
@RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)      //刷新client 客户端 同步 3355
public class ConfigClientController {

    @Value("${config.info}")
   private String configInfo;

    @GetMapping("/configInfo")
    private String getConfigInfo(){
        return configInfo;
    }

    public void setConfigInfo(String configInfo){
        this.configInfo=configInfo;
    }

}
