package com.atguigu.springcloud.service;

import com.atguigu.springcloud.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Date And @Time: 2022/1/26  21:43
 */
public interface AccountService {

    public void decrease(@RequestParam("userId") long userId,
                         @RequestParam("money") BigDecimal money);
}
