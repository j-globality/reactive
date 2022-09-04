package guide;

import lombok.Value;
import java.util.UUID;

@Value
public class User {

    UUID id;
    String email;
    int age;
    Boolean active;

}
