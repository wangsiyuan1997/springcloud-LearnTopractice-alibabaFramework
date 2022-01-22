package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Date And @Time: 2022/1/20  17:41
 */
@Component
public class MyBL implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);


    //获得当前访问次数
    public final int getInstance(){
        //原始值
        int current;
        //下次的值
        int next;
        do {
            //当前次数的默认值
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("next访问次数为:"+next);
        return next;

    }


    //负载均衡算法
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstanceList) {
        int index = getInstance() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }




}
