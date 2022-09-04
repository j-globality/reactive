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
        /**
         * todo: Log and then print the item
         */
        return userRepository.getUserByEmail(email);
    }

    public Flux<User> getAllUsers() {
        /**
         * todo: Execute side effects by chaining to print the
         *  1. item emitted
         *  2. time at the start of the sequence
         *  3. time at the end of the sequence
         */
        return userRepository.getUsers();

    }

}
