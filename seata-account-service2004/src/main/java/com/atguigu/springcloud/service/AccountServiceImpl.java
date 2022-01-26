package com.atguigu.springcloud.service;

import com.atguigu.springcloud.dao.AccountDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @Date And @Time: 2022/1/26  21:51
 */
@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);


    @Autowired
    private AccountDao accountDao;

    @Override
    public void decrease(long userId, BigDecimal money) {
        //超时异常
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.decrease(userId, money);

    }
}
