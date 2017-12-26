package com.simple.service.impl;

import com.simple.common.ServerResponse;
import com.simple.dao.UserMapper;
import com.simple.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by S I M P L E on 2017/12/26
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public ServerResponse<String> register(String username, String password, String email, String phone, String question, String answer) {
        if (userMapper.checkUsername(username) > 0) {
            return ServerResponse.createByErrorMessage("用户名字已经存在");
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

}
