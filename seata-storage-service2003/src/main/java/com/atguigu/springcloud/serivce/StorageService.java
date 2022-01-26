package com.atguigu.springcloud.serivce;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Date And @Time: 2022/1/26  21:09
 */
public interface StorageService {

    public void decrease(@RequestParam("productId") long productId,
                         @RequestParam("count") Integer count);
}
