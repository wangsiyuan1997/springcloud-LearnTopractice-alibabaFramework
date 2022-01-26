package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.domain.Account;
import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Date And @Time: 2022/1/26  21:55
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonResult<Account> decrease(@RequestParam("userId") long userId,
                                          @RequestParam("money")BigDecimal money){
        accountService.decrease(userId, money);

        return new CommonResult<>(200,"扣减账户余额成功！");
    }
}
