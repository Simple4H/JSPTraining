package com.simple.service;

import com.github.pagehelper.PageInfo;
import com.simple.common.ServerResponse;

/**
 * Create by S I M P L E on 2018/01/03
 */
public interface IShippingService {

    ServerResponse<String> addNewShippingAddress(String userId, String receiverName, String receiverPhone,
                                                 String receiverMobile, String receiverProvince,
                                                 String receiverCity, String receiverDistrict,
                                                 String receiverAddress, String receiverZip);

    ServerResponse<String> deleteShippingAddress(String shippingId, String userId);

    ServerResponse<PageInfo> getShippingAddress(int pageNum, int pageSize, String userId);
}
