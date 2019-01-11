package pl.poznan.espeo.rabbit;

import org.springframework.amqp.core.Queue;

import java.util.Map;

import static pl.poznan.espeo.rabbit.RabbitConfig.DEAD_LETTER_EXCHANGE;
import static pl.poznan.espeo.rabbit.RabbitConfig.DEAD_LETTER_QUEUE;

public class QueueCreator {
    private static final Map<String, Object> PROPERTIES = Map.of(
            "x-dead-letter-exchange", DEAD_LETTER_EXCHANGE,
            "x-dead-letter-routing-key", DEAD_LETTER_QUEUE
    );

    public static final Queue createQueue(String name) {
        return new Queue(name, true, false, false, PROPERTIES);
    }
}
