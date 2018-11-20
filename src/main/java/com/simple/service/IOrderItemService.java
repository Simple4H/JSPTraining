package com.simple.service;

import com.github.pagehelper.PageInfo;
import com.simple.common.ServerResponse;

public interface IOrderItemService {

    ServerResponse<PageInfo> getOrderItemList(int pageNum, int pageSize, int userId);
}
