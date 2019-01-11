package pl.poznan.espeo.modules.user.commands;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.poznan.espeo.db.DB;
import pl.poznan.espeo.modules.user.domain.User;
import pl.poznan.espeo.modules.user.domain.UserRegistered;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserCommandService {
    private final DB db;

    void register(UserRegistered e) {
        log.info("Persisting user: {}", e.getId());
        db.storage.put(e.getId(), new User(e.getId(), e.getName(), e.getRole()));
    }
}
