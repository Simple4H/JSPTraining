package com.simple.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.common.ServerResponse;
import com.simple.dao.ShippingMapper;
import com.simple.pojo.Shipping;
import com.simple.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by S I M P L E on 2018/01/05
 *                       _oo0oo_
 #                      o8888888o
 #                      88" . "88
 #                      (| -_- |)
 #                      0\  =  /0
 #                    ___/`---'\___
 #                  .' \\|     |# '.
 #                 / \\|||  :  |||# \
 #                / _||||| -:- |||||- \
 #               |   | \\\  -  #/ |   |
 #               | \_|  ''\---/''  |_/ |
 #               \  .-\__  '-'  ___/-. /
 #             ___'. .'  /--.--\  `. .'___
 #          ."" '<  `.___\_<|>_/___.' >' "".
 #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 #         \  \ `_.   \_ __\ /__ _/   .-` /  /
 #     =====`-.____`.___ \_____/___.-`___.-'=====
 #                       `=---='
 #
 #
 #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 #
 #               佛祖保佑         永无BUG
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

    public ServerResponse<PageInfo> getShippingAddress(int pageNum, int pageSize, String userId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Shipping> shippingList = shippingMapper.getShippingAddress(userId);
        PageInfo<Shipping> resultPage = new PageInfo<>(shippingList);
        if (resultPage.getSize() > 0) {
            return ServerResponse.createBySuccess("查询到该用户的收货地址", resultPage);
        }
        return ServerResponse.createByErrorMessage("没有找到相关的收货地址");
    }

    public ServerResponse<String> updateShippingAddress(String userId, String shippingId, String receiverName,
                                                        String receiverPhone, String receiverMobile,
                                                        String receiverProvince, String receiverCity,
                                                        String receiverDistrict, String receiverAddress,
                                                        String receiverZip) {
        int resultCount = shippingMapper.updateShippingAddress(userId, shippingId, receiverName, receiverPhone, receiverMobile, receiverProvince, receiverCity, receiverDistrict, receiverAddress, receiverZip);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("更新收货地址成功");
        }
        return ServerResponse.createByErrorMessage("修改地址错误");
    }
}
