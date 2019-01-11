package pl.poznan.espeo.modules.user.queries;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.poznan.espeo.modules.user.domain.User;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserQueryController {
    private final UserQueryService service;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") UUID id) {
        log.info("Querying for user: {}", id);
        return service.getUser(id);
    }
}
