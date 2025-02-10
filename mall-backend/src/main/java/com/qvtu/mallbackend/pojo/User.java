package com.qvtu.mallbackend.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer userId;

    private String username;

    private String password;

    private String nickname;

    private String email;

    private String phone;

    private Date registrationTime;

    private String status;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;
}
