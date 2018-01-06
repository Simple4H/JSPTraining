package com.simple.dao;

import com.simple.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    int findProductIdExist(int productId);

    int updateProductQuantity(@Param("productId")int productId,@Param("quantity")int quantity);

    int addNewProduct(@Param("userId") int userId,@Param("productId") int productId,@Param("quantity") int quantity);

    List<Cart> getCartList();

    //清空购物车
    int deleteAllProduct();

}