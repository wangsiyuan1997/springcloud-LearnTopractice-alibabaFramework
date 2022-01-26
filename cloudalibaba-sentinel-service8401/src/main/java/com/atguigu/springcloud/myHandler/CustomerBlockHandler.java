package com.atguigu.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

/**
 * @Date And @Time: 2022/1/25  21:32
 */
public class CustomerBlockHandler {

    public static CommonResult<Payment> handlerException1(BlockException e){
        return new CommonResult(444,"自定义限流兜底方法---------->handlerException1");
    }
    public static CommonResult<Payment> handlerException2(BlockException e){
        return new CommonResult(444,"自定义限流兜底方法---------->handlerException2");
    }
}
