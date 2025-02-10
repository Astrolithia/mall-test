package com.qvtu.mallbackend.mapper;

import com.qvtu.mallbackend.pojo.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    // 根据用户名查询用户
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);

    // 添加
    @Insert("insert into user (username, password, email, phone, create_time)" +
            " values (#{username}, #{password}, #{email}, #{phone}, now())")
    void add(String username, String password, String email, String phone);
}
