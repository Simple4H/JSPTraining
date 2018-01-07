package com.simple.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.common.ServerResponse;
import com.simple.dao.CartMapper;
import com.simple.pojo.Cart;
import com.simple.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by S I M P L E on 2018/01/05
 *                       _oo0oo_
 #                      o8888888o
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
@Service("iCartService")
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;

    public ServerResponse<String> addNewProduct(int userId,int productId,int quantity) {
        //检查产品是否已经在购物车
        int resultFind = cartMapper.findProductIdExist(productId);
        if (resultFind > 0 ) {
            //如果已经存在，就修改
            int resultUpdate = cartMapper.updateProductQuantity(productId, quantity);
            if (resultUpdate > 0 ){
                return ServerResponse.createBySuccessMessage("修改数量成功");
            }
            return ServerResponse.createByErrorMessage("修改数量错误");
        }
        //不存在则新增
        int resultCount = cartMapper.addNewProduct(userId,productId,quantity);
        if (resultCount > 0){
            return ServerResponse.createBySuccessMessage("加入购物车成功");
        }
        return ServerResponse.createByErrorMessage("加入购物车失败");
    }

    public ServerResponse<PageInfo> getCartList(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Cart> cartList = cartMapper.getCartList();
        PageInfo<Cart> cartPageInfo = new PageInfo<>(cartList);
        if (cartPageInfo.getSize() > 0) {
            return ServerResponse.createBySuccess("购物车内的商品",cartPageInfo);
        }
        return ServerResponse.createByErrorMessage("购物车为空");
    }
}
