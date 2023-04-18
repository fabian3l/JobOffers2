package domain.loginandregister;

import java.util.Optional;

public interface RegisterRepository {

    User saveUser(User user);
    Optional<User> findUserByUsername(String username);
}
