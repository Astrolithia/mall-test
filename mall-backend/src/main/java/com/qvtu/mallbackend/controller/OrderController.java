package com.qvtu.mallbackend.controller;

import com.qvtu.mallbackend.pojo.Order;
import com.qvtu.mallbackend.pojo.Result;
import com.qvtu.mallbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
