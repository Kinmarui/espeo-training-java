package pl.poznan.espeo.modules.user.rabbit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.poznan.espeo.events.EventEnvelope;
import pl.poznan.espeo.events.EventSender;
import pl.poznan.espeo.modules.user.domain.UserEvent;

import static pl.poznan.espeo.modules.user.rabbit.UserRabbitConfig.USER_REGISTERED_EXCHANGE;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserSender implements EventSender<UserEvent> {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void send(EventEnvelope<UserEvent> e) {
        log.info("Sending event envelope: {}", e.getId());
        rabbitTemplate.convertAndSend(USER_REGISTERED_EXCHANGE, "", e);
    }
}
