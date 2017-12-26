package com.simple.service;

import com.simple.common.ServerResponse;
import com.simple.pojo.User;

/**
 * Create by S I M P L E on 2017/12/26
 */
public interface IUserService {

    ServerResponse<String> register(String username, String password, String question, String answer, String phone, String email);

    ServerResponse<User> login(String username, String password);
}
