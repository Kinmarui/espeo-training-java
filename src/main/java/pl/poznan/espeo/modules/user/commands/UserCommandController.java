package pl.poznan.espeo.modules.user.commands;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.poznan.espeo.events.EventEnvelope;
import pl.poznan.espeo.modules.user.domain.UserEvent;
import pl.poznan.espeo.modules.user.domain.UserRegistered;
import pl.poznan.espeo.modules.user.rabbit.UserSender;

import static java.util.UUID.randomUUID;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserCommandController {
    private final UserSender sender;

    @PostMapping("/users")
    public void registerUser(@RequestBody UserRegistered userRegistered) {
        log.info("Received user registration request");
        sender.send(EventEnvelope.<UserEvent>builder()
                .id(randomUUID())
                .event(userRegistered)
                .build());
    }
}
