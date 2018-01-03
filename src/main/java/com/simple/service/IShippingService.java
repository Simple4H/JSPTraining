package com.simple.service;

import com.simple.common.ServerResponse;

/**
 * Create by S I M P L E on 2018/01/03
 */
public interface IShippingService {

    ServerResponse<String> addNewShippingAddress(String userId, String receiverName, String receiverPhone,
                                                 String receiverMobile, String receiverProvince,
                                                 String receiverCity, String receiverDistrict,
                                                 String receiverAddress, String receiverZip);
}
