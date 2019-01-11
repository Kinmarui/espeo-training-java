package pl.poznan.espeo.modules.user.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class UserRegistered implements UserEvent {
    private final UUID id;
    private final String name;
    private final Role role;
}
