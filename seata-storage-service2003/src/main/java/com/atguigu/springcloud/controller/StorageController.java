package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.domain.Storage;
import com.atguigu.springcloud.serivce.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date And @Time: 2022/1/26  21:18
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult<Storage> decrease(long productId,Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200, "扣减库存成功");
    }
}
