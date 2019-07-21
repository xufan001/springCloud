package com.order.rabbitmy.workfair;

import com.order.rabbitmy.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费者获取消息
 */
public class Recv2 {
    private static final String QUEUE_NAME = "test_work_queue";

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        //获取连接
        Connection connection = ConnectionUtils.getConnection();

        //创建频道
        final Channel channel = connection.createChannel();

        //队列声明，消息应答，消息持久化
        boolean durable = false;//rabbitMQ不支持重新定义（不同参数）一个已存在的队列
        channel.queueDeclare(QUEUE_NAME,durable,false,false,null);

        //保证一次只发一个
        channel.basicQos(1);

        //创建一个新的消费者5erwterwt
        DefaultConsumer consumer = new DefaultConsumer(channel) {

            //消息到达触发这个方法
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body,"utf-8");
                System.out.println("[2] Recv msg :"+msg);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("[2] done");
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };
        //自动应答
        boolean autoAck = false;
        //监听队列
        channel.basicConsume(QUEUE_NAME,autoAck,consumer);



    }

}
