package ru.gb.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * This class allow any producer to send messages to any topic exchange.
 * Topic exchange forwards the messages based on routing pattern
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class RabbitMqMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routingKey){
        log.info("PUBLISHING {}", payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("PUBLISHED {}", payload);
    }
}
