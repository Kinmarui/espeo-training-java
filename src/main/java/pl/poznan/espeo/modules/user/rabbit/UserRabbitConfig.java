package pl.poznan.espeo.modules.user.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static pl.poznan.espeo.rabbit.QueueCreator.createQueue;

@Configuration
public class UserRabbitConfig {
    static final String USER_QUEUE = "user-queue";
    static final String USER_REGISTERED_EXCHANGE = "user-registered-exchange";

    @Bean
    public Queue userQueue() {
        return createQueue(USER_QUEUE);
    }

    @Bean
    public FanoutExchange userRegistrated() {
        return new FanoutExchange(USER_REGISTERED_EXCHANGE);
    }

    @Bean
    public Binding userRegisteredBinding(Queue userQueue, FanoutExchange userRegistered) {
        return BindingBuilder.bind(userQueue).to(userRegistered);
    }
}
