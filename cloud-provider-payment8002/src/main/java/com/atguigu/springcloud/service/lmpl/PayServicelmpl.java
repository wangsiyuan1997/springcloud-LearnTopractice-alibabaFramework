package com.atguigu.springcloud.service.lmpl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date And @Time: 2022/1/18  21:29
 */
@Service
public class PayServicelmpl implements PayService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(long id) {

        Payment paymentById = paymentDao.getPaymentById(id);
        return paymentById;
    }
}
