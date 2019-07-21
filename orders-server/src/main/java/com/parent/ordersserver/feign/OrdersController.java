package com.parent.ordersserver.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

    @Autowired
    private OrderFeign orderFeign;

    @RequestMapping("/test")
    public String test(){


       return orderFeign.getMember();
    }


}
