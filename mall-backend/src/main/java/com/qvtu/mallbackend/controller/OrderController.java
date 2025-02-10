package com.qvtu.mallbackend.controller;

import com.qvtu.mallbackend.pojo.Order;
import com.qvtu.mallbackend.pojo.PageBean;
import com.qvtu.mallbackend.pojo.Result;
import com.qvtu.mallbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/submit")
    public Result submitOrder(@RequestBody Order order) {
        orderService.submitOrder(order);
        return Result.success("订单提交成功");
    }

    @GetMapping
    public Result<PageBean<Order>> list(Integer pageNum, Integer pageSize) {
        PageBean<Order> pb = orderService.list(pageNum, pageSize);
        return Result.success(pb);
    }
}
