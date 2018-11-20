package com.simple.service;

import com.github.pagehelper.PageInfo;
import com.simple.common.ServerResponse;

public interface ICartService {

    ServerResponse<String> addNewProduct(int userId, int productId, int quantity);

    ServerResponse<PageInfo> getCartList(int pageNum, int pageSize);
}
