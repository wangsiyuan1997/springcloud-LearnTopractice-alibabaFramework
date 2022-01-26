package com.atguigu.springcloud.serivce.lmpl;

import com.atguigu.springcloud.dao.StorageDao;
import com.atguigu.springcloud.serivce.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Date And @Time: 2022/1/26  21:14
 */
@Service
public class StorageServicelmpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServicelmpl.class);

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decrease(long productId, Integer count) {
        storageDao.decrease(productId, count);
    }
}
