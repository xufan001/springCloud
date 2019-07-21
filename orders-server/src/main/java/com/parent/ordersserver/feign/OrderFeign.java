package com.parent.ordersserver.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "member-server")
public interface OrderFeign {

    @RequestMapping("/member-server/getMember")
    public String getMember();



}
