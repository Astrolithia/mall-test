package com.qvtu.mallbackend.controller;

import com.qvtu.mallbackend.pojo.Result;
import com.qvtu.mallbackend.pojo.User;
import com.qvtu.mallbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username, String password, String email,String phone) {
        // 查询用户
        User u = userService.findByUserName(username);
        if (u == null) {
            // 用户名没有被占用
            // 注册
            userService.register(username, password, email, phone);
            return Result.success();
        } else {
            // 用户名被占用
            return Result.error("用户名已被占用");
        }
    }
}
