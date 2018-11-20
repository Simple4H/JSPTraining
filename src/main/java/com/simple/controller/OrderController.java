package com.simple.controller;

import com.github.pagehelper.PageInfo;
import com.simple.common.Const;
import com.simple.common.ResponseCode;
import com.simple.common.ServerResponse;
import com.simple.pojo.Order;
import com.simple.pojo.User;
import com.simple.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RequestMapping(value = "/order/")
@Controller
public class OrderController {

    private final IOrderService iOrderService;

    @Autowired
    public OrderController(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }

    //新建订单
    @RequestMapping(value = "create_order.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Order> createOrder(@RequestBody Map map, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        int userId = user.getId();
        int  a = (int) map.get("shippingId");
        String shippingId = String.valueOf(a);
        return iOrderService.createOrder(userId,shippingId) ;
    }

    //获取订单列表
    @RequestMapping(value = "get_order_list.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> getOrderList(HttpSession session, @RequestBody Map map) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        int a =user.getId();
        String userId = String.valueOf(a);
        int pageNum = Integer.parseInt(String.valueOf(map.get("pageNum")));
        int pageSize = Integer.parseInt(String.valueOf(map.get("pageSize")));
        return iOrderService.getOrderList(userId, pageNum, pageSize);
    }
}
