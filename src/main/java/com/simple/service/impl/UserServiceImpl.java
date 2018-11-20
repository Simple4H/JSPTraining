package com.simple.service.impl;

import com.simple.common.Const;
import com.simple.common.ServerResponse;
import com.simple.common.TokenCache;
import com.simple.dao.UserMapper;
import com.simple.pojo.User;
import com.simple.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("iUserService")
public class UserServiceImpl implements IUserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

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
    public ServerResponse<String> updateUserPassword(String oldPassword, String newPassword, String username) {
        if (userMapper.checkPassword(oldPassword) == 0) {
            return ServerResponse.createByErrorMessage("旧密码错误");
        }
        int resultCount = userMapper.updateUserPassword(oldPassword, newPassword, username);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("修改密码成功");
        }
        return ServerResponse.createByErrorMessage("修改密码错误");
    }

    //校验问题和答案,获取token
    public ServerResponse<String> checkQuestionAnswer(String username, String question, String answer) {
        if (userMapper.checkUsername(username) == 0) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        int resultCount = userMapper.checkQuestionAndAnswer(username, question, answer);
        if (resultCount > 0) {
            String forgetToken = UUID.randomUUID().toString();
            TokenCache.setKey(TokenCache.TOKEN_PREFIX + username, forgetToken);
            return ServerResponse.createBySuccess("获取token成功", forgetToken);
        }
        return ServerResponse.createByErrorMessage("问题或答案错误");
    }

    //通过token修改个人密码
    public ServerResponse<String> resetPassword(String username, String newPassword, String forgetToken) {
        if (StringUtils.isBlank(forgetToken)) {
            return ServerResponse.createByErrorMessage("没有token,token需要传递");
        }
        if (userMapper.checkUsername(username) == 0) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        String token = TokenCache.getKey(TokenCache.TOKEN_PREFIX + username);
        if (StringUtils.isBlank(token)) {
            return ServerResponse.createByErrorMessage("token无效或者过期");
        }
        if (StringUtils.equals(forgetToken, token)) {
            int resultCount = userMapper.resetPassword(username, newPassword);
            if (resultCount > 0) {
                return ServerResponse.createBySuccessMessage("修改密码成功");
            }
        } else {
            return ServerResponse.createByErrorMessage("token错误,请重新获取重置密码的token");
        }
        return ServerResponse.createByErrorMessage("修改密码错误");
    }

    //获取个人信息
    public ServerResponse<User> getUserInformation(String username) {
        User user = userMapper.getUserInformation(username);
        if (user != null) {
            user.setPassword(StringUtils.EMPTY);
            return ServerResponse.createBySuccess("查询成功", user);
        }
        return ServerResponse.createByErrorMessage("查询失败");
    }

    //更新用户问题和答案
    public ServerResponse<String> updateQuestionAndAnswer(String question, String answer, String username) {
        int resultCount = userMapper.updateQuestionAndAnswer(question, answer, username);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("修改问题和答案成功");
        }
        return ServerResponse.createByErrorMessage("修改密码问题和答案失败");
    }

    //校验是不是管理员
    public ServerResponse checkAdmin(User user) {
        if (user.getRole() == Const.Role.ROLE_ADMIN) {
            return ServerResponse.createBySuccessMessage("是管理员");
        }
        return ServerResponse.createByErrorMessage("不是管理员");
    }

    public ServerResponse getQuestionInformation(String username) {
        int result = userMapper.checkUsername(username);
        if (result > 0) {
            String question = userMapper.getQuestionInformation(username);
            if (!StringUtils.isEmpty(question)) {
                return ServerResponse.createBySuccess("获取成功", question);
            }
            return ServerResponse.createBySuccessMessage("发生异常");
        }
        return ServerResponse.createByErrorMessage("用户不存在");
    }
}
