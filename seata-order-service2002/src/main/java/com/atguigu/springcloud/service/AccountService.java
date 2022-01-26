package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Date And @Time: 2022/1/26  19:05
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    //调用account微服务  查询用户id 修改账户余额
    @PostMapping("/account/decrease")
    public CommonResult<Order> decrease(@RequestParam("userId") long userId,
                                        @RequestParam("money")  BigDecimal money);
}
