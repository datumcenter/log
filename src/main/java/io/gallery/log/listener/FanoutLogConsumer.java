package io.gallery.log.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutLogConsumer {

    @RabbitListener(queues = "log.login")
    public void login(Object msg) {
        System.out.println("login消费者收到消息：" + msg.toString());
    }

    @RabbitListener(queues = "log.logout")
    public void logout(Object msg) {
        System.out.println("logout消费者收到消息：" + msg.toString());
    }

    @RabbitListener(queues = "log.crud")
    public void crud(Object msg) {
        System.out.println("crud消费者收到消息：" + msg.toString());
    }

}
