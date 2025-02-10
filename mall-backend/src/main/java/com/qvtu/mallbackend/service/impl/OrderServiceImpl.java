package com.qvtu.mallbackend.service.impl;

import com.qvtu.mallbackend.mapper.OrderMapper;
import com.qvtu.mallbackend.pojo.Order;
import com.qvtu.mallbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void submitOrder(Order order) {
        // 设置订单状态为"待支付"
        order.setOrderStatus("待支付");
        // 设置订单创建时间和更新时间
        order.setCreateTime(LocalDateTime.now());
        order.setUpdateTime(LocalDateTime.now());

        // 调用 Mapper 插入订单
        orderMapper.insertOrder(order);
    }
}
