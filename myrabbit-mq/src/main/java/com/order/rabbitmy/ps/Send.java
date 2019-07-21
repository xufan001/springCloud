package com.order.rabbitmy.ps;

import com.order.rabbitmy.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 建立连接和通道，发送数据
 *  1.每个消费者都有自己的队列
 *  2.队列要绑定到交换机上
 *  3.一方面是接受消费者的消息，另一方面是向消费者推送消息（交换机类型为fonout,不处理路由键）
 *                  |——————Queue————Consumer
 * Producer------交换机
 *                 |——————Queue————Consumer
 */
public class Send {
    private final static String EXCHANGE_NAME="test_exchange_fanout";
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtils.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        //发送消息的内容
        String msg="交换机";
        //发布到队列
        channel.basicPublish(EXCHANGE_NAME,"",null,msg.getBytes());

        System.out.println("Send :"+msg);
        //关闭通道
        channel.close();
        //关闭连接
        connection.close();
    }
}
