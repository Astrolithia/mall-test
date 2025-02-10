package com.qvtu.mallbackend.config;

import com.qvtu.mallbackend.interceptors.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor())
                // 不需要拦的路径
                .excludePathPatterns("/user/login", "/user/register")
                .addPathPatterns("/**");
    }
}
