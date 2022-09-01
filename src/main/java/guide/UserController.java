package guide;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@ExecuteOn(TaskExecutors.IO)
@Controller("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    @Get
    public Flux<String> index() {
        return userService.getUserNames();
    }
}
