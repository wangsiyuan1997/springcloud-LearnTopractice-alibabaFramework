package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Date And @Time: 2022/1/18  21:39
 */
@RestController
public class PaymentController {
    @Autowired
    private PayService payService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = payService.create(payment);

        if (result>0){
            return new CommonResult(200,"插入数据库成功,服务端口号serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(404,"插入数据库失败",null);
        }
    }
    @GetMapping("/payment/select/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){
        Payment payment = payService.getPaymentById(id);
        if (payment != null){
            return new CommonResult(200,"查询成功!服务端口号serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(404,"查询失败!查询的id为:"+id,null);
        }
    }

    //服务发现Discovery
    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("******service:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println("服务id："+instance.getServiceId()+",端口号:"+instance.getPort()+",ip地址:"+instance.getHost()+
                    ",URL地址:"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
