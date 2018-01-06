package com.simple.service;

import com.github.pagehelper.PageInfo;
import com.simple.common.ServerResponse;
import com.simple.pojo.Order;

/**
 * Create by S I M P L E on 2018/01/04
 */
public interface IOrderService {

    ServerResponse<Order> createOrder(int userId, String shippingId);

    ServerResponse<PageInfo> getOrderList(String userId, int pageNum, int pageSize);
}
