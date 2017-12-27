package com.simple.service;

import com.simple.common.ServerResponse;
import com.simple.pojo.User;

/**
 * Create by S I M P L E on 2017/12/26
 */
public interface IUserService {

    ServerResponse<String> register(String username, String password, String email, String phone, String question, String answer);

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> updateUserPhone(String phone,String username);

    ServerResponse<String> updateUserEmail(String email, String username);

    ServerResponse<String> updateUserPassword(String oldPassword,String newPassword,String username);

    ServerResponse<String> checkQuestionAnswer(String username,String question,String answer);

    ServerResponse<String> resetPassword(String username, String newPassword, String forgetToken);

}
