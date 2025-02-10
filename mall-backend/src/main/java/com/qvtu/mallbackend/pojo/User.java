package com.qvtu.mallbackend.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class User {

    private Integer userId;

    private String username;

    @JsonIgnore
    // JsonIgnore注解让Springmvc把当前对象转换为json字符串时忽略这个值
    private String password;

    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;

    @NotEmpty
    @Email
    private String email;

    private String phone;

    private Date registrationTime;

    private String status;

    private Date createTime;

    private Date updateTime;

    private Integer createUser;

    private Integer updateUser;

    private String avatarUrl;
}
