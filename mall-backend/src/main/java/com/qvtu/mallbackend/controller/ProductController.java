package com.qvtu.mallbackend.controller;

import com.qvtu.mallbackend.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/list")
    public Result<String> list() {
        return Result.success("所有的文章数据...");
    }
}
