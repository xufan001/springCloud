package com.order.rabbitmy.simple;

import com.order.rabbitmy.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import javafx.scene.shape.QuadCurve;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    private static final String QUEUE_NAME = "test_simple_queue";
    public static void main(String[] args) throws IOException, TimeoutException {

        //获取一个连接
        Connection connection = ConnectionUtils.getConnection();

        //从连接中获取一个通道
        Channel channel = connection.createChannel();

        //创建队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);


        //要发送的内容
        String msg = "hello simple,SUCCESS";

        //发布出去
        channel.basicPublish("", QUEUE_NAME,null,msg.getBytes());

        System.out.println("send  msg:"+msg);

        //关闭通道
        channel.close();
        //关闭连接
        connection.close();
    }
}
