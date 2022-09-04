package guide;

import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.UUID;

/**
 * If we have an actual DB, this would be an
 * interface extending ReactiveStreamsCrudRepository.
 */
@Singleton
public class UserRepository {

    private User[] usersArray = {
            new User(UUID.randomUUID(), "a1@b.com", 18, true),
            new User(UUID.randomUUID(), "a@b.com", 67, false),
            new User(UUID.randomUUID(), "a@b.com", 34, true),
    };

    public Mono<User> getUserByEmail(String email) {
        Mono<User> userMono = Mono.empty();
        for (User user : usersArray) {
            if (user.getEmail() == email) userMono = Mono.just(user);
        }
//        return Mono.just(u);
//        return Mono.error(new IllegalArgumentException("Wrong args"));
        return userMono;
    }

    public Flux<User> getUsers() {
//        Flux<User> usersFlux = Flux.fromArray(usersArray);
        Flux<User> usersFlux = Flux.fromIterable(Arrays.asList(usersArray));
        return usersFlux;
    }

}