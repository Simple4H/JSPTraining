package com.simple.service.impl;

import com.simple.common.ServerResponse;
import com.simple.dao.UserMapper;
import com.simple.pojo.User;
import com.simple.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by S I M P L E on 2017/12/26
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    //注册
    public ServerResponse<String> register(String username, String password, String email, String phone, String question, String answer) {
        if (userMapper.checkUsername(username) > 0) {
            return ServerResponse.createByErrorMessage("用户名已经存在");
        }
        if (userMapper.checkEmail(email) > 0) {
            return ServerResponse.createByErrorMessage("邮箱已经存在");
        }
        int resultCount = userMapper.registerNewUser(username, password, email, phone, question, answer);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("注册成功");
        }
        return ServerResponse.createByErrorMessage("注册失败");
    }

    //登录
    public ServerResponse<User> login(String username, String password) {
        if (userMapper.checkUsername(username) == 0) {
            return ServerResponse.createByErrorMessage("该用户名不存在");
        }
        User user = userMapper.userLogin(username, password);
        if (user == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }
        //返回的时候将密码制空
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功", user);
    }

    //修改个人信息的手机
    public ServerResponse<String> updateUserPhone(String phone, String username) {
        int resultCount = userMapper.updateUserPhone(phone, username);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("修改手机号码成功");
        }
        return ServerResponse.createByErrorMessage("修改手机号码错误");
    }

    //修改个人信息的邮箱
    public ServerResponse<String> updateUserEmail(String email, String username) {
        if (userMapper.checkEmail(email) > 0) {
            return ServerResponse.createByErrorMessage("邮箱已经存在");
        }
        int resultCount = userMapper.updateUserEmail(email, username);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("修改邮箱成功");
        }
        return ServerResponse.createByErrorMessage("修改邮箱失败");
    }

    //登录状态下修改个人密码
    public ServerResponse<String> updateUserPassword(String oldPassword,String newPassword,String username){
        if (userMapper.checkPassword(oldPassword) == 0){
            return ServerResponse.createByErrorMessage("旧密码错误");
        }
        int resultCount = userMapper.updateUserPassword(oldPassword, newPassword, username);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("修改密码成功");
        }
        return ServerResponse.createByErrorMessage("修改密码错误");
    }

}
