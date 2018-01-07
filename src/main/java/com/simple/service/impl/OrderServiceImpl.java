package com.simple.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.common.Const;
import com.simple.common.ServerResponse;
import com.simple.dao.CartMapper;
import com.simple.dao.OrderMapper;
import com.simple.dao.ProductMapper;
import com.simple.pojo.Cart;
import com.simple.pojo.Order;
import com.simple.pojo.Product;
import com.simple.service.IOrderService;
import com.simple.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
@Service("iOrderService")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductMapper productMapper;

    public ServerResponse<Order> createOrder(int userId, String shippingId) {
        String orderNo = DateUtil.dateChange(String.valueOf(userId));
        List<Cart> cartList = cartMapper.getCartList();
        Cart cart = cartList.get(0);
        //获取产品的ID
        int productId = cart.getProductId();
        //获取购物车的产品数量
        int a = cart.getQuantity();
        BigDecimal quantity = new BigDecimal(a);
        //获取产品的单价
        List<Product> productList = productMapper.getProductById(productId);
        Product product = productList.get(0);
        BigDecimal price = product.getPrice();
        //获取总金额
        BigDecimal payment = price.multiply(quantity);
        int resultCount = orderMapper.createOrder(orderNo, userId, shippingId, payment, Const.PaymentTypeEnum.OFFLINE_PAY.getCode(), "8", Const.OrderStatusEnum.NO_PAY.getCode());
        //执行到这里说明生成订单ojbk
        if (resultCount > 0){
            //清空购物车
            cartMapper.deleteAllProduct();
            return ServerResponse.createBySuccessMessage("创建订单成功");
        }
        return ServerResponse.createByErrorMessage("创建订单失败");
    }

    public ServerResponse<PageInfo> getOrderList(String userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderMapper.getOrderList(userId);
        PageInfo<Order> orderPageInfo = new PageInfo<>(orderList);
        if (orderPageInfo.getSize() > 0) {
            return ServerResponse.createBySuccess("查询到该用户的订单", orderPageInfo);
        }
        return ServerResponse.createByErrorMessage("该用户没有任何订单");
    }

}
