package com.qvtu.mallbackend.interceptors;

import com.qvtu.mallbackend.utils.JwtUtil;
import com.qvtu.mallbackend.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 放行OPTIONS请求
        if ("OPTIONS".equals(request.getMethod())) {
            return true;
        }
        // 获取当前请求的路径
        String requestURI = request.getRequestURI();
        System.out.println("Interceptor - Request URI: " + requestURI); // 添加日志

        // 如果是注册或登录接口,直接放行
        if (requestURI.equals("/user/register") || requestURI.equals("/user/login")) {
            System.out.println("Interceptor - Allowing access to " + requestURI); // 添加日志
            return true;
        }
        
        // 令牌验证
        String token = request.getHeader("Authorization");
        // 验证token
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            // 把业务数据存储到ThreadLocal中
            ThreadLocalUtil.set(claims);
            // 放行
            return true;
        } catch (Exception e) {
            // http响应状态码为401
            response.setStatus(401);
            // 不放行
            return false;
        }
    }

    // 释放
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清空ThreadLocal中的数据
        ThreadLocalUtil.remove();
    }
}
