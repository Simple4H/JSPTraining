package com.simple.controller;

import com.simple.common.Const;
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
 */
@Controller
@RequestMapping(value = "/shipping/", method = RequestMethod.POST)
public class ShippingController {

    @Autowired
    private IShippingService iShippingService;

    @RequestMapping(value = "add_shipping_address.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addShippingAddress(HttpSession session, @RequestBody Map map) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户未登录，无法新建新的收货地址");
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
}
