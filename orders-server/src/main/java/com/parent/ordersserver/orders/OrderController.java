package com.parent.ordersserver.orders;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order-server")
public class OrderController {
 private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String ServerPort;

//    @RequestMapping("/getOrder")
//    public String getOrder(){
//
//        //String url = "http://MEMBER-SERVER/getMember"; //使用别名去服务中心调用
//        //String result = restTemplate.getForObject(url, String.class);
//        String result = "123";
//        System.out.println("订单服务调用会员服务result:"+result);
//        return result;
//    }

    @RequestMapping("/test1")
    public String getTest(){

        String url = "http://MEMBER-SERVER/member-server/getMember"; //使用别名去服务中心调用
        String result = restTemplate.getForObject(url, String.class);
        logger.info("正确输出返回值："+result);
        return result;
    }
}
