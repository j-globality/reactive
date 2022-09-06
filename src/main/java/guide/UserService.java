package guide;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;
import java.util.function.BiFunction;

@Slf4j
@Singleton
public class UserService {

    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<Integer> getUserAgeByEmail(String email) {
        // todo: Log and then transform the Mono to return just the user email
        return null;
    }

    public Flux<User> getAllUsers() {
        /**
         * todo: Execute side effects by chaining to print the
         *  1. item emitted
         *  2. time at the start of the sequence
         *  3. time at the end of the sequence
         */
        return Flux.empty();
    }

    public Flux<User> getActiveUsers() {
        // todo: Filter users to get only active ones
        return Flux.empty();
    }

    public Flux<User> getDistinctUsers() {
        // todo: Filter users to get only distinct users by email
        return Flux.empty();
    }

    public Flux<User> getFirst2Users() {
        // todo: Get the first 2 users only
        return Flux.empty();
    }

    public Mono<Integer> getSumOfAges() {
        // todo: Get the sum of all user ages
        return Mono.empty();
    }

    public Flux<User> addDummyUser() {
        // todo: Add a dummy user to the beginning of the sequence
        return Flux.empty();
    }

    public Mono<Long> getTotal() {
        // todo: Get the total number of users
        return Mono.empty();
    }

}
