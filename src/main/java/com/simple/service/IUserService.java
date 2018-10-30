package com.simple.service;

import com.simple.common.ServerResponse;
import com.simple.pojo.User;

/**
 * Create by S I M P L E on 2018/01/05
 *
 *                       _oo0oo_
 *                      o8888888o
 #                      88" . "88
 #                      (| -_- |)
 #                      0\  =  /0
 #                    ___/`---'\___
 #                  .' \\|     |# '.
 #                 / \\|||  :  |||# \
 #                / _||||| -:- |||||- \
 #               |   | \\\  -  #/ |   |
 #               | \_|  ''\---/''  |_/ |
 #               \  .-\__  '-'  ___/-. /
 #             ___'. .'  /--.--\  `. .'___
 #          ."" '<  `.___\_<|>_/___.' >' "".
 #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 #         \  \ `_.   \_ __\ /__ _/   .-` /  /
 #     =====`-.____`.___ \_____/___.-`___.-'=====
 #                       `=---='
 #
 #
 #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 #
 #               佛祖保佑         永无BUG
 */
public interface IUserService {

    ServerResponse<String> register(String username, String password, String email, String phone, String question, String answer);

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> updateUserPhone(String phone, String username);

    ServerResponse<String> updateUserEmail(String email, String username);

    ServerResponse<String> updateUserPassword(String oldPassword, String newPassword, String username);

    ServerResponse<String> checkQuestionAnswer(String username, String question, String answer);

    ServerResponse<String> resetPassword(String username, String newPassword, String forgetToken);

    ServerResponse<User> getUserInformation(String username);

    ServerResponse<String> updateQuestionAndAnswer(String question, String answer, String username);

    ServerResponse checkAdmin(User user);

    ServerResponse getQuestionInformation(String username);

}
