package pl.poznan.espeo.modules.user.queries;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.poznan.espeo.db.DB;
import pl.poznan.espeo.modules.user.domain.User;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserQueryService {
    private final DB db;

    User getUser(UUID id) {
        log.info("Retrieving user: {}", id);
        return (User) db.storage.get(id);
    }
}
