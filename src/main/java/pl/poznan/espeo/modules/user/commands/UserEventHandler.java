package pl.poznan.espeo.modules.user.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.poznan.espeo.events.Event;
import pl.poznan.espeo.events.EventHandler;
import pl.poznan.espeo.modules.user.domain.UserEvent;
import pl.poznan.espeo.modules.user.domain.UserRegistered;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserEventHandler implements EventHandler<UserEvent> {
    private final UserCommandService service;

    @Override
    public boolean canHandle(Event e) {
        return e instanceof UserEvent;
    }

    @Override
    public void handle(UserEvent e) {
        if ( e instanceof UserRegistered) {
            handleUserRegistered((UserRegistered) e);
        }
    }

    private void handleUserRegistered(UserRegistered e) {
        service.register(e);
    }
}
