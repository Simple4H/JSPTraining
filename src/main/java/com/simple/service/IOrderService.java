package com.simple.service;

import com.github.pagehelper.PageInfo;
import com.simple.common.ServerResponse;
import com.simple.pojo.Order;

public interface IOrderService {

    ServerResponse<Order> createOrder(int userId, String shippingId);

    ServerResponse<PageInfo> getOrderList(String userId, int pageNum, int pageSize);
}
