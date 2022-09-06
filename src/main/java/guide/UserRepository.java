package guide;

import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Note: If we have an actual DB, this would be an
 * interface extending ReactiveStreamsCrudRepository.
 */
@Singleton
public class UserRepository {

    private final Set<User> users = Set.of(
            new User(UUID.randomUUID(), "a1@b.com", 18, true),
            new User(UUID.randomUUID(), "a@b.com", 67, false),
            new User(UUID.randomUUID(), "a@b.com", 34, true)
    );

    public Mono<User> getUserByEmail(String email) {
        //@@todo: potential bug here since multiple users can have same email
        Optional<User> maybeUser = users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
        return Mono.justOrEmpty(maybeUser);
    }

    public Flux<User> getUsers() {
        return Flux.fromIterable(users);
    }

}
