package com.simple.service;

import com.github.pagehelper.PageInfo;
import com.simple.common.ServerResponse;

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
