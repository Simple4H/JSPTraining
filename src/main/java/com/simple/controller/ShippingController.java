package com.simple.controller;

import com.github.pagehelper.PageInfo;
import com.simple.common.Const;
import com.simple.common.ResponseCode;
import com.simple.common.ServerResponse;
import com.simple.pojo.User;
import com.simple.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Create by S I M P L E on 2018/01/03
 *
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
@Controller
@RequestMapping(value = "/shipping/", method = RequestMethod.POST)
public class ShippingController {

    @Autowired
    private IShippingService iShippingService;

    //添加新的收货地址
    @RequestMapping(value = "add_shipping_address.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addShippingAddress(HttpSession session, @RequestBody Map map) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        String userId = String.valueOf(user.getId());
        String receiverName = (String) map.get("receiverName");
        String receiverPhone = (String) map.get("receiverPhone");
        String receiverMobile = (String) map.get("receiverMobile");
        String receiverProvince = (String) map.get("receiverProvince");
        String receiverCity = (String) map.get("receiverCity");
        String receiverDistrict = (String) map.get("receiverDistrict");
        String receiverAddress = (String) map.get("receiverAddress");
        String receiverZip = (String) map.get("receiverZip");
        return iShippingService.addNewShippingAddress(userId, receiverName, receiverPhone, receiverMobile, receiverProvince, receiverCity, receiverDistrict, receiverAddress, receiverZip);
    }

    //删除收货地址
    @RequestMapping(value = "delete_shipping_address.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> deleteShippingAddress(HttpSession session, @RequestBody Map map) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        String shippingId = (String) map.get("shippingId");
        String userId = String.valueOf(user.getId());
        return iShippingService.deleteShippingAddress(shippingId, userId);
    }


    //获取收货地址列表
    @RequestMapping(value = "get_shipping_address.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> getShippingAddress(@RequestBody Map map, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        int pageNum = Integer.parseInt(String.valueOf(map.get("pageNum")));
        int pageSize = Integer.parseInt(String.valueOf(map.get("pageSize")));
        String userId = String.valueOf(user.getId());
        return iShippingService.getShippingAddress(pageNum, pageSize, userId);
    }

    //更新收货地址
    @RequestMapping(value = "update_shipping_address.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateShippingAddress(HttpSession session, @RequestBody Map map) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        String userId = String.valueOf(user.getId());
        String shippingId = (String) map.get("shippingId");
        String receiverName = (String) map.get("receiverName");
        String receiverPhone = (String) map.get("receiverPhone");
        String receiverMobile = (String) map.get("receiverMobile");
        String receiverProvince = (String) map.get("receiverProvince");
        String receiverCity = (String) map.get("receiverCity");
        String receiverDistrict = (String) map.get("receiverDistrict");
        String receiverAddress = (String) map.get("receiverAddress");
        String receiverZip = (String) map.get("receiverZip");
        return iShippingService.updateShippingAddress(userId, shippingId, receiverName, receiverPhone, receiverMobile, receiverProvince, receiverCity, receiverDistrict, receiverAddress, receiverZip);
    }
}
