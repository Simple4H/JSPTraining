package com.simple.dao;

import com.simple.pojo.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    int createOrder(@Param("orderNo") String orderNo, @Param("userId") String userId, @Param("shippingId") String shippingId, @Param("payment") String payment, @Param("paymentType") int paymentType, @Param("postage") String postage, @Param("status") int status);
}