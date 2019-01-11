package pl.poznan.espeo.events;

public interface EventSender<T extends Event> {
    void send(EventEnvelope<T> e);
}
