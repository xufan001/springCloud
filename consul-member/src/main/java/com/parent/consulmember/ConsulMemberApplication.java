package com.parent.consulmember;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 启动consul注册中心在cmd命令窗口启动
 * consul和eureka的区别，换不同的注册中心时，接口调用方式都不变，变化的是配置文件和地址maven依赖信息
 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ConsulMemberApplication {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/getMember")
    public String getMember(){

        return "会员服务，订单服务调用会员服务端口，端口号为："+serverPort;
    }

    public static void main(String[] args) {


        SpringApplication.run(ConsulMemberApplication.class, args);
    }


}
