package io.gallery.log.bean;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 主题交换机
 */
@Configuration
public class TopicMQConfig {

    //绑定键
    public final static String add = "log.add";
    public final static String del = "log.del";
    public final static String all = "log.all";

    @Bean
    public Queue logAddQueue() {
        return new Queue(add);
    }

    @Bean
    public Queue logDelQueue() {
        return new Queue(del);
    }

    @Bean
    public Queue logAllQueue() {
        return new Queue(all);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("logTopicExchange");
    }

    @Bean
    Binding bindingExchangeAdd() {
        return BindingBuilder.bind(logAddQueue()).to(exchange()).with(add);
    }

    @Bean
    Binding bindingExchangeDel() {
        return BindingBuilder.bind(logDelQueue()).to(exchange()).with(del);
    }

    @Bean
    Binding bindingExchangeMAll() {
        return BindingBuilder.bind(logAllQueue()).to(exchange()).with("log.#");
    }


}