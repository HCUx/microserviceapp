package com.hcu.notificationservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Value("${spring.cloud.stream.bindings.input.destination}")
    public String STREAM_BINDINGS_INPUT_DESTINATION;

    @Bean
    Queue queue() {
        return new Queue(STREAM_BINDINGS_INPUT_DESTINATION, true);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(STREAM_BINDINGS_INPUT_DESTINATION);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(STREAM_BINDINGS_INPUT_DESTINATION);
    }

}
