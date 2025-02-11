package com.qvtu.mallbackend.service;

import com.qvtu.mallbackend.pojo.Order;
import com.qvtu.mallbackend.pojo.PageBean;

public interface OrderService {
    void submitOrder(Order order);

    PageBean<Order> list(Integer pageNum, Integer pageSize, String orderStatus);

    Order findById(Integer orderId);

    void update(Order order);

    void delete(Integer orderId);
}
