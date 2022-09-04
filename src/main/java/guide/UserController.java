package guide;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Inject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExecuteOn(TaskExecutors.IO)
@Controller("/users")
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Get("/user")
    public Mono<User> getUserByEmail() {
        return userService.getUserByEmail("a1@b.com");
    }

    @Get("/all")
    public Flux<User> getUsers() {
        return userService.getAllUsers();
    }

}
