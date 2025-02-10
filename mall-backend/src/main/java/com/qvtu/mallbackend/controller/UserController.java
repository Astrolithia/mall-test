package com.qvtu.mallbackend.controller;

import com.qvtu.mallbackend.pojo.Result;
import com.qvtu.mallbackend.pojo.User;
import com.qvtu.mallbackend.service.UserService;
import com.qvtu.mallbackend.utils.JwtUtil;
import com.qvtu.mallbackend.utils.Md5Util;
import com.qvtu.mallbackend.utils.ThreadLocalUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{2,10}$") String username,
                           @Pattern(regexp = "^\\S{8,16}$")String password, String email, String phone) {
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

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{2,10}$") String username,
                                @Pattern(regexp = "^\\S{8,16}$")String password) {
        // 根据用户名查询用户
        User loginUser = userService.findByUserName(username);
        // 判断该用户是否存在
        if (loginUser == null) {
            return Result.error("用户名错误");
        }

        // 判断密码是否正确 loginUser对象中的password是密文
        if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
            // 登录成功
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getUserId());
            claims.put("username", loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }
        return Result.error("密码错误");
    }

    @GetMapping("/userInfo")
    public Result<User> getUserInfo(@RequestHeader(name = "Authorization") String token) {
        // 根据用户名查询用户
//        Map<String, Object> map = JwtUtil.parseToken(token);
//        String username = (String) map.get("username");

        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result update(@Valid @RequestBody User user) {
        userService.update(user);
        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam String avatarUrl) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        userService.updateAvatar(avatarUrl, userId);
        return Result.success();
    }

    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String, String> params) {
        // 1. 校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        if (oldPwd == null || newPwd == null || rePwd == null) {
            return Result.error("缺少必要的参数");
        }

        // 原密码是否正确
        // 调用userService根据用户名拿到原密码，再和old_pwd比对
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findByUserName(username);
        if (loginUser == null) {
            return Result.error("用户不存在");
        }
        if (!Md5Util.getMD5String(oldPwd).equals(loginUser.getPassword())) {
            return Result.error("原密码错误");
        }

        // 2. 判断新密码和确认密码是否一致
        if (!newPwd.equals(rePwd)) {
            return Result.error("新密码和确认密码不一致");
        }

        // 3. 更新密码
        userService.updatePwd(newPwd);
        return Result.success();
    }
}
