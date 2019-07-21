package com.parent.memberserver.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;

public class JsonWebToken {
    public static void main(String[] args) {
        //生成token字符串
        JwtBuilder builder = Jwts.builder();

        //构建token
        HashMap<String, Object> map = new HashMap<>();
        map.put("type","hr");

        //头部
        builder.setHeader(map);

        //载荷
        builder.setId("1");//验证唯一性
        //token签发时间
        builder.setIssuedAt(new Date());
        //设置token过期时间
        long l = System.currentTimeMillis();
        //累加2分钟后过期
        l += 1000*60*2;
        //设置过期时间
        builder.setExpiration(new Date(l));
        //存储个人信息
        builder.claim("username","huaWei");
        builder.claim("age","20");

        //签证 加盐加密方式
        builder.signWith(SignatureAlgorithm.HS256, "Tuesday");

        //生成token
        String token = builder.compact();
        System.out.println("Token:"+token);


    }
}
