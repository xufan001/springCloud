package com.order.rabbitmy.route;

import com.order.rabbitmy.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.net.ConnectException;
import java.util.concurrent.TimeoutException;

/**
 * 路由模式
 * 1.路由表必须明确
 * 2.根据routingKey发送到指定队列
 * 3.exchange的type=direct；key去匹配消费者routingKey
 */
public class Send {
    private final static String EXCHANGE_NAME="test_exchange_direct";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        //exchange
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");

        String msg="direct 模式";

        String routingKey = "info";
        channel.basicPublish(EXCHANGE_NAME,routingKey,null,msg.getBytes());

        System.out.println("send :"+msg);
        channel.close();
        connection.close();
    }
}
