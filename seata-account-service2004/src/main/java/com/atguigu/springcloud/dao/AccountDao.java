package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Date And @Time: 2022/1/26  21:31
 */
@Mapper
public interface AccountDao {

    public void decrease(@Param("userId") long userId, @Param("money") BigDecimal money);
}
