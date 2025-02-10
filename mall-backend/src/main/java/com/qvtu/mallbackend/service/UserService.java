package com.qvtu.mallbackend.service;

import com.qvtu.mallbackend.pojo.User;

public interface UserService {
    User findByUserName(String username);

    void register(String username, String password, String email, String phone);

    void update(User user);

    void updateAvatar(String avatarUrl, Integer userId);

    void updatePwd(String newPwd);
}
