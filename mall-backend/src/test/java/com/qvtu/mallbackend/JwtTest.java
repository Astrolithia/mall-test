package com.qvtu.mallbackend;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.auth0.jwt.JWT;

@SpringBootTest
public class JwtTest {

    @Test
    public void testGenerateToken() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "张三");
        // 生成jwt的代码
        String token = JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12))
                .sign(Algorithm.HMAC256("qvtu"));
        System.out.println(token);
    }

    @Test
    public void testVerifyToken() {
        // 定义字符串，模拟用户传过来的token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3MzkyMDAzOTl9." +
                "6K-zodykNtQkA9rC3Mux-lSDqghHrSJe-yNQ22sdkcw";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("qvtu")).build();
        DecodedJWT jwt = jwtVerifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        System.out.println(claims.get("user"));
    }

}
