package com.parent.memberserver.apiController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member-server")
public class MemberApi {
    private static final Logger logger = LoggerFactory.getLogger(MemberApi.class);


    @Value("${server.port}")
    private String ServerPort;

    @RequestMapping("/getMember")
    public String getMember(){
        Object girl = new Object();
        girl.equals("beautifulGirl ");
        return "this is member,会员服务;端口号："+ServerPort;
    }
}
