package com.atguigu.springcloud.service.lmpl;

import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Date And @Time: 2022/1/26  19:05
 */
@Service
public class OrderServicelmpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "Order-tx",rollbackFor = Exception.class) //开启全局事务
    public void create(Order order) {
        System.out.println("------>开始创建新的订单!");
        //新建订单
        orderDao.create(order);
        System.out.println("--------->订单调用微服务开始调用库存，做Count扣减");
        //对商品库存进行扣减
        storageService.decrease(order.getProductId(),order.getCount());
        System.out.println("--------->订单调用微服务开始调用库存，做Count扣减----结束!");

        System.out.println("--------->订单调用微服务开始调用账户，做money扣减");
        //对用户 的账户余额进行扣减
        accountService.decrease(order.getUserId(),order.getMoney());
        System.out.println("--------->订单调用微服务开始调用账户，做money扣减-----结束");

        System.out.println("-------》修改订单状态");
        orderDao.update(order.getUserId(),0);
        System.out.println("-------》修改订单状态结束");

        System.out.println("整体调用结束..........");
    }
}
