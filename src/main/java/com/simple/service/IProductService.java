package com.simple.service;

import com.github.pagehelper.PageInfo;import com.simple.common.ServerResponse;

public interface IProductService {

    ServerResponse<PageInfo> getProductList(int pageNum,int pageSize);
}
