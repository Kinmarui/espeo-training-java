package pl.poznan.espeo.db;

import org.springframework.stereotype.Component;
import pl.poznan.espeo.events.EventEnvelope;
import pl.poznan.espeo.events.EventStore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class EventStoreImpl implements EventStore {
    private final Map<UUID, EventEnvelope> store = new HashMap<>();

    @Override
    public void write(EventEnvelope e)  {
        store.put(e.getId(), e);
    }
}
