package io.gallery.log.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DicrectLogConsumer {

    @RabbitListener(queues = "logDirectQueue")//监听的队列名称
    public void deal(Object msg) {
        System.out.println("deal消费者收到消息：" + msg.toString());
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "logDirectQueue", durable = "true"), key = {"logDirectRouting"},
            exchange = @Exchange(name = "logDirectExchange", type = ExchangeTypes.DIRECT, ignoreDeclarationExceptions = "true")
    ))
    public void deal2(Object msg) {
        System.out.println("deal2消费者收到消息：" + msg.toString());
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "logDirectQueue4", durable = "true"), key = {"logDirectRouting4"},
            exchange = @Exchange(name = "logDirectExchange4", type = ExchangeTypes.DIRECT, ignoreDeclarationExceptions = "true")
    ))
    public void deal4(Object msg) {
        System.out.println("deal4消费者收到消息：" + msg.toString());
    }

}
