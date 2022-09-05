package guide;

import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Note: If we have an actual DB, this would be an
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
        // todo: Create a new empty Mono
        Mono<User> userMono = Mono.empty();
        for (User user : usersArray) {
            // todo: Create a Mono from the user
            if (user.getEmail() == email) userMono = Mono.just(user);
        }
        return userMono;
    }

    public Flux<User> getUsers() {
        // todo: Create a Flux from the usersArray
        Flux<User> usersFlux = Flux.fromArray(usersArray);
        return usersFlux;
    }

}
