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

    public Mono<String> getUserIdByEmail(String email) {
        // todo: Log and then transform the Mono to return just the user email
        return userRepository.getUserByEmail(email)
                .log()
                .map(User::getId)
                .cast(String.class);
    }

    public Flux<User> getAllUsers() {
        /**
         * todo: Execute side effects by chaining to print the
         *  1. item emitted
         *  2. time at the start of the sequence
         *  3. time at the end of the sequence
         */
        return userRepository.getUsers()
                .doOnNext(System.out::println)
                .doFirst(() -> System.out.println("Starting: " + new Timestamp(new Date().getTime())))
                .doOnComplete(() -> System.out.println("Ending: " + new Timestamp(new Date().getTime())));
    }

    public Flux<User> getActiveUsers() {
        // todo: Filter users to get only active ones
        return userRepository.getUsers()
                .filter(User::isActive);
    }

    public Flux<User> getDistinctUsers() {
        // todo: Filter users to get only distinct users by email
        return userRepository.getUsers()
                .distinct(User::getEmail);
    }

    public Flux<User> getFirst2Users() {
        // todo: Get the first 2 users only
        return userRepository.getUsers()
                .take(2);
    }

    public Mono<Integer> getSumOfAges() {
        // todo: Get the sum of all user ages
        return userRepository.getUsers()
                .map(User::getAge)
                .reduce(Integer::sum);
    }

    public Flux<User> addDummyUser() {
        // todo: Add a dummy user to the beginning of the sequence
        User[] users = new User[]{new User(UUID.randomUUID(), "d@b.com", 18, true)};
        return userRepository.getUsers()
                .startWith(users);
    }

    public Mono<Long> getTotal() {
        // todo: Get the total number of users
        return userRepository.getUsers()
                .count();
    }

}
