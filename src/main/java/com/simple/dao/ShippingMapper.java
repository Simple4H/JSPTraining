package com.simple.dao;

import com.simple.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    int addNewShippingAddress(@Param("userId") String userId, @Param("receiverName") String receiverName, @Param("receiverPhone") String receiverPhone, @Param("receiverMobile") String receiverMobile, @Param("receiverProvince") String receiverProvince, @Param("receiverCity") String receiverCity, @Param("receiverDistrict") String receiverDistrict, @Param("receiverAddress") String receiverAddress, @Param("receiverZip") String receiverZip);

    int deleteShippingAddress(@Param("shippingId") String shippingId, @Param("userId") String userId);

    List<Shipping> getShippingAddress(String userId);

    int updateShippingAddress(@Param("userId") String userId, @Param("shippingId") String shippingId, @Param("receiverName") String receiverName, @Param("receiverPhone") String receiverPhone, @Param("receiverMobile") String receiverMobile, @Param("receiverProvince") String receiverProvince, @Param("receiverCity") String receiverCity, @Param("receiverDistrict") String receiverDistrict, @Param("receiverAddress") String receiverAddress, @Param("receiverZip") String receiverZip);
}