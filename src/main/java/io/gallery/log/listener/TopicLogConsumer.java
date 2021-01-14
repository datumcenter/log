package io.gallery.log.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicLogConsumer {

    @RabbitListener(queues = "log.add")
    public void add(Object msg) {
        System.out.println("add消费者收到消息：" + msg.toString());
    }

    @RabbitListener(queues = "log.del")
    public void del(Object msg) {
        System.out.println("del消费者收到消息：" + msg.toString());
    }

    @RabbitListener(queues = "log.all")
    public void all(Object msg) {
        System.out.println("log消费者收到消息：" + msg.toString());
    }

}
