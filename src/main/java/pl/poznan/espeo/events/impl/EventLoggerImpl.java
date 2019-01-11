package pl.poznan.espeo.events.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.poznan.espeo.events.*;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventLoggerImpl implements EventLogger {
    private final EventRouter router;
    private final EventStore store;

    @Override
    public void logEvent(EventEnvelope e) {
        log.info("Persisting event envelope: {}", e.getId());
        store.write(e);
        router.route(e);
    }
}
