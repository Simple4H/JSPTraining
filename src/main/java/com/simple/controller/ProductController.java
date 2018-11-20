package com.simple.controller;

import com.github.pagehelper.PageInfo;
import com.simple.common.ServerResponse;
import com.simple.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@RequestMapping(value = "/product/")
@Controller
public class ProductController {

    private final IProductService iProductService;

    @Autowired
    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    //获取产品列表
    @RequestMapping(value = "get_product_list.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> getProductList(@RequestBody Map map) {
        int pageNum = Integer.parseInt(String.valueOf(map.get("pageNum")));
        int pageSize = Integer.parseInt(String.valueOf(map.get("pageSize")));
        return iProductService.getProductList(pageNum,pageSize);
    }
}
