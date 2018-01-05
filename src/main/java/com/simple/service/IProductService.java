package com.simple.service;

import com.github.pagehelper.PageInfo;import com.simple.common.ServerResponse; /**
 * Create by S I M P L E on 2018/01/04
 */
public interface IProductService {

    ServerResponse<PageInfo> getProductList(int pageNum,int pageSize);
}
