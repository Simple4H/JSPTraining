package com.simple.dao;

import com.simple.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    //查询所有的订单详情
    List<OrderItem> getOrderItemList(int userId);

    //订单详情
    int insertOrderItem(@Param("userId") int userId,@Param("orderNo") String orderNo,@Param("productId") int productId,@Param("productName") String productName,@Param("mainImage")String mainImage,@Param("price") BigDecimal price, @Param("quantity")BigDecimal quantity,@Param("productPayment")BigDecimal productPayment);
}