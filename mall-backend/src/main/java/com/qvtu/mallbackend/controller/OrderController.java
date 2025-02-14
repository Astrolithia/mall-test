package com.qvtu.mallbackend.controller;

import com.qvtu.mallbackend.pojo.Order;
import com.qvtu.mallbackend.pojo.PageBean;
import com.qvtu.mallbackend.pojo.Result;
import com.qvtu.mallbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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

    @GetMapping("/list")
    public Result<PageBean<Order>> listOrders(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String orderStatus) {
        PageBean<Order> pb = orderService.list(pageNum, pageSize, orderStatus);
        return Result.success(pb);
    }

    @GetMapping("/detail")
    public Result<Order> detail(@RequestParam Integer orderId) {
        Order o = orderService.findById(orderId);
        return Result.success(o);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated Order order) {
        orderService.update(order);
        return Result.success("订单更新成功");
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam Integer orderId) {
        orderService.delete(orderId);
        return Result.success("订单删除成功");
    }
}
