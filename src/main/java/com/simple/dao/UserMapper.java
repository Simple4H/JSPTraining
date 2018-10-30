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
    int registerNewUser(@Param("username") String username, @Param("password") String password, @Param("email") String email, @Param("phone") String phone, @Param("question") String question, @Param("answer") String answer);

    //校验用户名字
    int checkUsername(String username);

    //校验邮箱
    int checkEmail(String email);

    //登录
    User userLogin(@Param("username") String username, @Param("password") String password);

    //修改手机号码
    int updateUserPhone(@Param("phone") String phone,@Param("username")String username);

    //修改邮箱
    int updateUserEmail(@Param("email")String email,@Param("username")String username);

    //校验密码
    int checkPassword(String oldPassword);

    //登录状态下修改个人密码
    int updateUserPassword(@Param("oldPassword")String oldPassword,@Param("newPassword")String newPassword,@Param("username")String username);

    //校验问题和答案
    int checkQuestionAndAnswer(@Param("username")String username,@Param("question")String question,@Param("answer")String answer);

    //重置密码
    int resetPassword(@Param("username")String username,@Param("newPassword")String newPassword);

    //获取用户信息
    User getUserInformation(String username);

    //更新用户问题和答案
    int updateQuestionAndAnswer(@Param("question")String question,@Param("answer")String answer,@Param("username")String username);

    String getQuestionInformation(String username);
}