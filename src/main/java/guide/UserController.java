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
    public Mono<String> getUserByEmail() {
        return userService.getUserIdByEmail("a1@b.com");
    }

    @Get("/total")
    public Mono<Long> getTotal() {
        return userService.getTotal();
    }

    @Get("/all")
    public Flux<User> getUsers() {
        return userService.getAllUsers();
    }

    @Get("/active")
    public Flux<User> getActiveUsers() {
        return userService.getActiveUsers();
    }

    @Get("/unique")
    public Flux<User> getDistinctUsers() {
        return userService.getDistinctUsers();
    }

    @Get("/firstTwo")
    public Flux<User> getFirst2Users() {
        return userService.getFirst2Users();
    }

    @Get("/sum")
    public Mono<Integer> getSum() {
        return userService.getSumOfAges();
    }

    @Get("/dummy")
    public Flux<User> addDummy() {
        return userService.addDummyUser();
    }

}
