package com.simple.dao;

import com.simple.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    int createOrder(@Param("orderNo") String orderNo, @Param("userId") int userId, @Param("shippingId") String shippingId, @Param("payment") BigDecimal payment, @Param("paymentType") int paymentType, @Param("postage") String postage, @Param("status") int status);

    List<Order> getOrderList(String userId);
}