package com.qvtu.mallbackend.mapper;

import com.qvtu.mallbackend.pojo.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    // 根据用户名查询用户
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);

    // 添加
    @Insert("insert into user (username, password, email, phone, create_time)" +
            " values (#{username}, #{password}, #{email}, #{phone}, now())")
    void add(String username, String password, String email, String phone);

    // 更新
    @Update("update user set username=#{username}, nickname=#{nickname}, email=#{email}, phone=#{phone}, update_time=now() where user_id=#{userId}")
    void update(User user);

    // 更新用户头像
    @Update("update user set avatar_url=#{avatarUrl} where user_id=#{userId}")
    void updateAvatar(String avatarUrl, Integer userId);
}
