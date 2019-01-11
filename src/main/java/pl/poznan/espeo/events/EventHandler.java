package pl.poznan.espeo.events;

public interface EventHandler<T extends Event> {
    boolean canHandle(Event e);
    void handle(T e);
}
