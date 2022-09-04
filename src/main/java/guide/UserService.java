package guide;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.util.Date;

@Slf4j
@Singleton
public class UserService {

    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> getUserByEmail(String email) {
        return userRepository.getUserByEmail(email)
                .log()
                .doOnNext(System.out::println);
    }

    public Flux<User> getAllUsers() {
        return userRepository.getUsers()
                .doOnNext(System.out::println)
                .doFirst(() -> System.out.println("Starting: " + new Timestamp(new Date().getTime())))
                .doOnComplete(() -> System.out.println("Ending: " + new Timestamp(new Date().getTime())));
    }

}
