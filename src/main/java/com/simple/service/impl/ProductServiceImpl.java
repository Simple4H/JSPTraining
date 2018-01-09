package com.simple.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.common.ServerResponse;
import com.simple.dao.ProductMapper;
import com.simple.pojo.Product;
import com.simple.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by S I M P L E on 2018/01/05
 *
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
@Service("iProductService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    public ServerResponse<PageInfo> getProductList(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> productList = productMapper.getProductList();
        PageInfo<Product> productPageInfo = new PageInfo<>(productList);
        if (productPageInfo.getSize() > 0) {
            return ServerResponse.createBySuccess("查询所有的产品",productPageInfo);
        }
        return ServerResponse.createByErrorMessage("没有找到任何的产品");
    }
}
