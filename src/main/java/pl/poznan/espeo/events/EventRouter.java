package pl.poznan.espeo.events;

public interface EventRouter {
    void route(EventEnvelope e);
}
