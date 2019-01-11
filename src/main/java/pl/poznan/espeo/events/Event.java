package pl.poznan.espeo.events;

import java.io.Serializable;
import java.util.function.Consumer;

public interface Event extends Serializable {
    default void apply(Consumer<Event> handler) {
        handler.accept(this);
    }
}
