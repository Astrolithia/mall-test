package com.qvtu.mallbackend.controller;

import com.qvtu.mallbackend.pojo.Good;
import com.qvtu.mallbackend.pojo.Result;
import com.qvtu.mallbackend.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodService goodService;

    @PostMapping("/add")
    public Result add(@RequestBody Good good) {
        goodService.add(good);
        return Result.success("商品添加成功");
    }
}
