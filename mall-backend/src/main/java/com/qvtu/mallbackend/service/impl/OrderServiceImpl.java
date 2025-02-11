package com.qvtu.mallbackend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qvtu.mallbackend.mapper.OrderMapper;
import com.qvtu.mallbackend.pojo.Order;
import com.qvtu.mallbackend.pojo.PageBean;
import com.qvtu.mallbackend.service.OrderService;
import com.qvtu.mallbackend.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public PageBean<Order> list(Integer pageNum, Integer pageSize, String orderStatus) {
        PageBean<Order> pb = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        List<Order> ps = orderMapper.list(userId, orderStatus);
        Page<Order> p = (Page<Order>) ps;
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public Order findById(Integer orderId) {
        return orderMapper.findById(orderId);
    }


}
