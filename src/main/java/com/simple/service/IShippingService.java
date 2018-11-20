package com.simple.service;

import com.github.pagehelper.PageInfo;
import com.simple.common.ServerResponse;

public interface IShippingService {

    ServerResponse<String> addNewShippingAddress(String userId, String receiverName, String receiverPhone,
                                                 String receiverMobile, String receiverProvince,
                                                 String receiverCity, String receiverDistrict,
                                                 String receiverAddress, String receiverZip);

    ServerResponse<String> deleteShippingAddress(String shippingId, String userId);

    ServerResponse<PageInfo> getShippingAddress(int pageNum, int pageSize, String userId);

    ServerResponse<String> updateShippingAddress(String userId, String shippingId, String receiverName,
                                                 String receiverPhone, String receiverMobile,
                                                 String receiverProvince, String receiverCity,
                                                 String receiverDistrict, String receiverAddress,
                                                 String receiverZip);
}
