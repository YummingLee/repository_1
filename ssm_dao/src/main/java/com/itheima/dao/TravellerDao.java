package com.itheima.dao;


import com.itheima.domain.Traveller;
import org.apache.ibatis.annotations.Select;

public interface TravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public Traveller findById(String id);
}
