package guide;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/user")
public class UserController {
    @Get
    public String index() {
        return "Hello";
    }
}
