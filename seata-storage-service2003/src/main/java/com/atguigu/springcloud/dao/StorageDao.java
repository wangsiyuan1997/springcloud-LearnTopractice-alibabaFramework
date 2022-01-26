package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Date And @Time: 2022/1/26  20:44
 */
@Mapper
public interface StorageDao {


    public void decrease(@Param("productId") long productId ,
                         @Param("count") Integer count);
}
