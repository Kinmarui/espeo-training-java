package pl.poznan.espeo.modules.user.rabbit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.poznan.espeo.events.EventEnvelope;
import pl.poznan.espeo.events.EventLogger;

import static pl.poznan.espeo.modules.user.rabbit.UserRabbitConfig.USER_QUEUE;

@Slf4j
@Component
@RabbitListener(queues = USER_QUEUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserReceiver {
    private final EventLogger logger;

    @RabbitHandler(isDefault = true)
    public void receive(EventEnvelope e) {
        log.info("Received event envelope: {}", e.getId());
        logger.logEvent(e);
    }
}
