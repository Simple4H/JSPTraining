package com.simple.dao;

import com.simple.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //注册新用户
    int registerNewUser(@Param("username") String username, @Param("password")String password, @Param("email")String email, @Param("phone")String phone, @Param("question")String question, @Param("answer")String answer);

    //校验用户名字
    int checkUsername(String username);

    //校验邮箱
    int checkEmail(String email);
}