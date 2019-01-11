package pl.poznan.espeo.events;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class EventEnvelope<T extends Event> implements Serializable {
    private final UUID id;
    private final T event;
}
