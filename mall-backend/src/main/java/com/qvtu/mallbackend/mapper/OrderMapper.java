package com.qvtu.mallbackend.mapper;

import com.qvtu.mallbackend.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("INSERT INTO `order` (user_id, merchant_id, order_status, payment_status, payment_time, order_total, shipping_status, shipping_time) " +
            "VALUES (#{userId}, #{merchantId}, #{orderStatus}, #{paymentStatus}, #{paymentTime}, #{orderTotal}, #{shippingStatus}, #{shippingTime})")
    void insertOrder(Order order);

    @Select("SELECT * FROM `order`")
    List<Order> list(Integer userId);
}
