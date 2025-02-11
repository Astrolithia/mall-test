package com.qvtu.mallbackend.mapper;

import com.qvtu.mallbackend.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("INSERT INTO `order` (user_id, merchant_id, order_status, payment_status, payment_time, order_total, shipping_status, shipping_time) " +
            "VALUES (#{userId}, #{merchantId}, #{orderStatus}, #{paymentStatus}, #{paymentTime}, #{orderTotal}, #{shippingStatus}, #{shippingTime})")
    void insertOrder(Order order);

    List<Order> list(@Param("userId") Integer userId, @Param("orderStatus") String orderStatus);

    @Select("SELECT * FROM `Order` WHERE order_id=#{orderId}")
    Order findById(Integer orderId);

    void update(Order order);
}
