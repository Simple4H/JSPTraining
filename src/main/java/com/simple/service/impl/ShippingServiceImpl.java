package com.simple.service.impl;

import com.simple.common.ServerResponse;
import com.simple.dao.ShippingMapper;
import com.simple.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by S I M P L E on 2018/01/03
 */
@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    public ServerResponse<String> addNewShippingAddress(String userId, String receiverName, String receiverPhone,
                                                        String receiverMobile, String receiverProvince,
                                                        String receiverCity, String receiverDistrict,
                                                        String receiverAddress, String receiverZip) {
        int resultCount = shippingMapper.addNewShippingAddress(userId, receiverName, receiverPhone, receiverMobile, receiverProvince, receiverCity, receiverDistrict, receiverAddress, receiverZip);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("新建收货地址成功");
        }
        return ServerResponse.createByErrorMessage("新建收货地址失败");
    }

    public ServerResponse<String> deleteShippingAddress(String shippingId, String userId) {
        int resultCount = shippingMapper.deleteShippingAddress(shippingId, userId);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("删除收货地址成功");
        }
        return ServerResponse.createByErrorMessage("删除收货地址失败");
    }
}
