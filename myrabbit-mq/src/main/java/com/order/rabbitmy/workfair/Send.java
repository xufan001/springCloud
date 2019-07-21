package com.order.rabbitmy.workfair;

import com.order.rabbitmy.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    private static final String QUEUE_NAME = "test_work_queue";
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        //获取一个连接
        Connection connection = ConnectionUtils.getConnection();

        //从连接中获取一个通道
        Channel channel = connection.createChannel();

        //创建队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        /**
         * 每个消费者发送确认消息之前，消息队列不发送下一个消息到消费者，一次只处理一个消息
         * 限制发送给同一个消费者 不得超过一条信息
         */
        int prefetchCount = 1;
        channel.basicQos(prefetchCount);
        for(int i = 0; i < 50; i++){
            //要发送的内容
            String msg = "hello workFair,SUCCESS:"+i;
            System.out.println("[WQ] send"+msg);
            //发布出去
            channel.basicPublish("", QUEUE_NAME,null,msg.getBytes());
            Thread.sleep(i*20);
            System.out.println("send  msg:"+msg);
        }



        //关闭通道
        channel.close();
        //关闭连接
        connection.close();
    }
}
