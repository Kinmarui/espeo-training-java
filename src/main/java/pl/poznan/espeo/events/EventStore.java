package pl.poznan.espeo.events;

public interface EventStore {
    void write(EventEnvelope e);
}
