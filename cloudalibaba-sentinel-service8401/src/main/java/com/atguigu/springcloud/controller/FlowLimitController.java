package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Date And @Time: 2022/1/25  16:52
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        System.out.println(Thread.currentThread().getName());
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {

//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("testD 测试RT");
        int i = 10 / 0;
        return "------testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "--------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e){
        return "--------deal_testHotKey, 热点限流 资源名兜底方法";
    }

}
