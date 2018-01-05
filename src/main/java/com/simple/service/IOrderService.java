package com.simple.service;

import com.github.pagehelper.PageInfo;
import com.simple.common.ServerResponse;
import com.simple.pojo.Order;

/**
 * Create by S I M P L E on 2018/01/04
 */
public interface IOrderService {

    ServerResponse<Order> createOrder(String orderNo, String userId, String shippingId, String payment, int paymentType, String postage, int status);

    ServerResponse<PageInfo> getOrderList(String userId, int pageNum, int pageSize);
}
