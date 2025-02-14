package com.qvtu.mallbackend.mapper;

import com.qvtu.mallbackend.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    // 提交订单
    @Insert("INSERT INTO `order` (user_id, merchant_id, order_status, payment_status, payment_time, order_total, shipping_status, shipping_time) " +
            "VALUES (#{userId}, #{merchantId}, #{orderStatus}, #{paymentStatus}, #{paymentTime}, #{orderTotal}, #{shippingStatus}, #{shippingTime})")
    void insertOrder(Order order);

    // 分页查询订单列表
    List<Order> list(int offset, Integer pageSize, String orderStatus);

    // 查询订单总数
    Long count(String orderStatus);

    // 查询订单详情
    @Select("SELECT * FROM `Order` WHERE order_id=#{orderId}")
    Order findById(Integer orderId);

    // 更新订单信息
    void update(Order order);

    // 删除订单
    @Delete("DELETE FROM `Order` WHERE order_id=#{orderId}")
    void delete(Integer orderId);
}
