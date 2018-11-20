package com.simple.controller;

import com.github.pagehelper.PageInfo;
import com.simple.common.Const;
import com.simple.common.ResponseCode;
import com.simple.common.ServerResponse;
import com.simple.pojo.User;
import com.simple.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RequestMapping(value = "/order_item/")
@Controller
public class CartItemController {

    private final IOrderItemService iOrderItemService;

    @Autowired
    public CartItemController(IOrderItemService iOrderItemService) {
        this.iOrderItemService = iOrderItemService;
    }

    @RequestMapping(value = "get_list.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> getOrderItemList(@RequestBody Map map, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        int userId = user.getId();
        int pageNum = (Integer) map.get("pageNum");
        int pageSize = (Integer) map.get("pageSize");
        return iOrderItemService.getOrderItemList(pageNum, pageSize, userId);
    }
}
