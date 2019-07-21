package com.order.rabbitmy.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 获取MQ的连接
 */
public class ConnectionUtils {

    public static Connection getConnection()throws IOException, TimeoutException {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置服务地址
        factory.setHost("127.0.0.1");

        //AMQP端口号： 5672
        factory.setPort(5672);

        //vhost虚拟主机名称
        factory.setVirtualHost("vhost_xufan");

        //用户名
        factory.setUsername("user_xufan");

        //密码
        factory.setPassword("123456");

        //将连接返回
        return factory.newConnection();

    }
}
