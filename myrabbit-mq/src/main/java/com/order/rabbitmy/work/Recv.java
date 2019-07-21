package com.order.rabbitmy.work;

import com.order.rabbitmy.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费者获取消息
 */
public class Recv {
    private static final String QUEUE_NAME = "test_simple_queue";

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        //获取连接
        Connection connection = ConnectionUtils.getConnection();

        //创建频道
        Channel channel = connection.createChannel();

        //队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //创建一个新的消费者5erwterwt
        DefaultConsumer consumer = new DefaultConsumer(channel) {

            //消息到达触发这个方法
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body,"utf-8");
                System.out.println("[1] Recv msg :"+msg);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("[1] done");
                }
            }
        };
        boolean autoAck = true;
        //监听队列
        channel.basicConsume(QUEUE_NAME,autoAck,consumer);



    }

}
