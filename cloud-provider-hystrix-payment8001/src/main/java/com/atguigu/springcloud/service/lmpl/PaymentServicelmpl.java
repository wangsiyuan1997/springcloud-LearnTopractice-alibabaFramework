package com.atguigu.springcloud.service.lmpl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Date And @Time: 2022/1/21  11:08
 */
@Service
public class PaymentServicelmpl implements PaymentService {
    @Override
    public String paymentInfo_Ok(Integer id) {
        //线程池名称
        String ThreadName = Thread.currentThread().getName();
        return "线程池名称: " +ThreadName+",paymentInfo_Ok,id:"+id+"\t"+"O(∩_∩)O哈哈~";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            /*该方法设置3秒超时 则启动兜底方法*/
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int TimeNumber = 5;
        //线程池名称
        String ThreadName = Thread.currentThread().getName();
        try {
            TimeUnit.SECONDS.sleep(TimeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池名称: " +ThreadName+",paymentInfo_TimeOut,id:"+id+"\t"+"O(∩_∩)O哈哈~"+"耗时（秒）"+TimeNumber;
    }

    @Override
    public String paymentInfo_TimeOutHandler(Integer id) {
        //线程池名称
        String ThreadName = Thread.currentThread().getName();
        return "线程池名称: " +ThreadName+",paymentInfo_TimeOut,id:"+id+"\t"+"8001系统繁忙，请重试!";
    }

    /*********************服务熔断***********************/
    @Override
    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }

    @Override
    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }
}
