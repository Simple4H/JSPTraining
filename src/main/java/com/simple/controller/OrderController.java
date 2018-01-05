package com.simple.controller;

import com.simple.common.Const;
import com.simple.common.ResponseCode;
import com.simple.common.ServerResponse;
import com.simple.pojo.Order;
import com.simple.pojo.User;
import com.simple.service.IOrderService;
import com.simple.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Create by S I M P L E on 2018/01/04
 */
@RequestMapping(value = "/order/")
@Controller
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    @RequestMapping(value = "create_order.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Order> createOrder(@RequestBody Map map, HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        String orderNo = DateUtil.dateChange(String.valueOf(user.getId()));
        String userId = String.valueOf(user.getId());
        String shippingId = (String) map.get("shippingId");
        String payment = (String) map.get("payment");
        String postage = (String) map.get("postage");
        return iOrderService.createOrder(orderNo,userId,shippingId,
                payment,Const.PaymentTypeEnum.OFFLINE_PAY.getCode(),postage,Const.OrderStatusEnum.NO_PAY.getCode());

    }
}
