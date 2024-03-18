package br.com.mmmsieto.order.infrastructure.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private final ConnectionFactory connectionFactory;

    public RabbitMQConfig(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Bean
    public Queue creatQueueOrderPendingAnalyzesCredit() {
        return QueueBuilder.durable("order-pending.ms-analyzes-credit").build();
    }

    @Bean
    public Queue creatQueueNewClient() {
        return QueueBuilder.durable("new-client").build();
    }

    @Bean
    public RabbitAdmin creatRabbitAdmin() {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> initAdmin() {
        return event -> this.creatRabbitAdmin().initialize();
    }

    @Bean
    public FanoutExchange creatFanoutExchangeOrderPendingAnalyzesCredit() {
        return ExchangeBuilder.fanoutExchange("order-pending.ms-analyzes-credit").build();
    }

    @Bean
    public Binding creatBindingOrderPendingAnalyzesCredit() {
        return BindingBuilder.bind(this.creatQueueOrderPendingAnalyzesCredit())
                .to(this.creatFanoutExchangeOrderPendingAnalyzesCredit());
    }

    @Bean
    public FanoutExchange creatFanoutExchangeNewClient() {
        return ExchangeBuilder.fanoutExchange("new-client-fanout").build();
    }

    @Bean
    public Binding creatBindingNewClient() {
        return BindingBuilder.bind(this.creatQueueNewClient())
                .to(this.creatFanoutExchangeNewClient());
    }

}
