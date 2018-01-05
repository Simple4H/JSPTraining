package com.simple.service;

import com.github.pagehelper.PageInfo;
import com.simple.common.ServerResponse;

/**
 * Create by S I M P L E on 2018/01/05
 */
public interface ICartService {

    ServerResponse<String> addNewProduct(int userId, int productId, int quantity);

    ServerResponse<PageInfo> getCartList(int pageNum, int pageSize);
}
