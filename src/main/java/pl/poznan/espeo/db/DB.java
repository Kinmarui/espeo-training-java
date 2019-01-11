package pl.poznan.espeo.db;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class DB {
    public final Map<UUID, Object> storage = new HashMap<>();
}
