package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Date And @Time: 2022/1/26  19:04
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    //调用storage微服务  查询商品id 修改库存数量
    @PostMapping(value = "/storage/decrease")
    public CommonResult<Order>  decrease (@RequestParam("productId") long productId,
                                          @RequestParam("count") Integer count);

}
