package com.simple.service;

import com.simple.common.ServerResponse;

/**
 * Create by S I M P L E on 2017/12/26
 */
public interface IUserService {

    ServerResponse<String> register(String username, String password, String question, String answer, String phone, String email);
}
