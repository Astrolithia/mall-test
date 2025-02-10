package com.qvtu.mallbackend.service.impl;

import com.qvtu.mallbackend.mapper.UserMapper;
import com.qvtu.mallbackend.pojo.User;
import com.qvtu.mallbackend.service.UserService;
import com.qvtu.mallbackend.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 将服务注册到容器中
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        User u = userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(String username, String password, String email, String phone) {
        // 需要对密码进行加密处理
        String md5String = Md5Util.getMD5String(password);
        // 添加
        userMapper.add(username, md5String, email, phone);
    }
}
