package com.simple.dao;

import com.simple.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    int addNewShippingAddress(@Param("userId") String userId,@Param("receiverName") String receiverName,@Param("receiverPhone") String receiverPhone,@Param("receiverMobile") String receiverMobile,@Param("receiverProvince") String receiverProvince,@Param("receiverCity") String receiverCity,@Param("receiverDistrict") String receiverDistrict,@Param("receiverAddress") String receiverAddress,@Param("receiverZip") String receiverZip);
}