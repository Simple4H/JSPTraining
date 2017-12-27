package com.simple.controller;

import com.simple.common.Const;
import com.simple.common.ResponseCode;
import com.simple.common.ServerResponse;
import com.simple.pojo.User;
import com.simple.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Create by S I M P L E on 2017/12/26
 */
@RequestMapping(value = "/user/")
@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    //注册
    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(@RequestBody Map map) {
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        String email = (String) map.get("email");
        String phone = (String) map.get("phone");
        String question = (String) map.get("question");
        String answer = (String) map.get("answer");
        return iUserService.register(username, password, email, phone, question, answer);
    }

    //登录
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(@RequestBody Map map, HttpSession session) {
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        ServerResponse<User> response = iUserService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    //修改个人信息的手机号码
    @RequestMapping(value = "update_user_phone.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateUserPhone(@RequestBody Map map, HttpSession session) {
        String phone = (String) map.get("phone");
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iUserService.updateUserPhone(phone, user.getUsername());
    }

    //修改个人信息的邮箱
    @RequestMapping(value = "update_user_email.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateUserEmail(@RequestBody Map map, HttpSession session) {
        String email = (String) map.get("email");
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iUserService.updateUserEmail(email, user.getUsername());
    }


    //登录状态下修改密码
    @RequestMapping(value = "update_user_password", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateUserPassword(@RequestBody Map map, HttpSession session) {
        String oldPassword = (String) map.get("oldPassword");
        String newPassword = (String) map.get("newPassword");
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iUserService.updateUserPassword(oldPassword, newPassword, user.getUsername());
    }
}
