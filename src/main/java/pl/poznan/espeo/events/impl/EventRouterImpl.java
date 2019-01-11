package pl.poznan.espeo.events.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.poznan.espeo.events.Event;
import pl.poznan.espeo.events.EventEnvelope;
import pl.poznan.espeo.events.EventHandler;
import pl.poznan.espeo.events.EventRouter;

import java.util.Collection;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventRouterImpl implements EventRouter {
    private final Collection<EventHandler<?>> handlers;

    @Override
    @SuppressWarnings("unchecked")
    public void route(EventEnvelope e) {
        log.info("Routing event envelope: {}", e.getId());
        handlers.stream()
                .filter(h -> h.canHandle(e.getEvent()))
                .map(h -> (EventHandler<Event>) h)
                .forEach(h -> h.handle(e.getEvent()));
    }
}
