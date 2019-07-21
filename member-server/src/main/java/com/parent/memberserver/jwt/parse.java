package com.parent.memberserver.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

public class parse {

    public static void main(String[] args) {
        String token ="eyJ0eXBlIjoiaHIiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwiaWF0IjoxNTU3MTk1NTY5LCJleHAiOjE1NTcxOTU2ODksInVzZXJuYW1lIjoiaHVhV2VpIiwiYWdlIjoiMjAifQ.RVwFU9kBcgGpZ-bftI06TBokcMoP2CfOYvu3fGlid-U";
        //解析token
        Claims claims=Jwts.parser().setSigningKey("Tuesday").parseClaimsJws(token).getBody();

        //获取到内容
        String username = (String) claims.get("username");
        String o = (String) claims.get("age");
        System.out.println(username + o);
    }
}
