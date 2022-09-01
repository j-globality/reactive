package guide;

import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@Singleton
public class UserService {
    public Flux<String> getUserNames() {
        Flux names = Flux.fromArray(new String[]{"a", "b"});
        return names;
    }

}
