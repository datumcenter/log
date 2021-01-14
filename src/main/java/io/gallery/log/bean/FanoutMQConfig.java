package io.gallery.log.bean;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 扇型交换机
 */
@Configuration
public class FanoutMQConfig {

    @Bean
    public Queue queueLogin() {
        return new Queue("log.login");
    }

    @Bean
    public Queue queueLogout() {
        return new Queue("log.logout");
    }

    @Bean
    public Queue queueCrud() {
        return new Queue("log.crud");
    }

    @Bean
    FanoutExchange logFanoutExchange() {
        return new FanoutExchange("logFanoutExchange");
    }

    @Bean
    Binding bindingExchangeA() {
        return BindingBuilder.bind(queueLogin()).to(logFanoutExchange());
    }

    @Bean
    Binding bindingExchangeB() {
        return BindingBuilder.bind(queueLogout()).to(logFanoutExchange());
    }

    @Bean
    Binding bindingExchangeC() {
        return BindingBuilder.bind(queueCrud()).to(logFanoutExchange());
    }

}