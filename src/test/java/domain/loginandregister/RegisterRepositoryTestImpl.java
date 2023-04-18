package domain.loginandregister;

import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class RegisterRepositoryTestImpl implements RegisterRepository{


    private final Map<String, User> userMap = new ConcurrentHashMap<>();

    @Override
    public User saveUser(User user) {
        userMap.put(user.id(), user);
        return user;
    }
    @Override
    public Optional<User> findUserByUsername(String username) {
        Optional findedUser = userMap.values()
                .stream()
                .filter(user -> user.username().equals(username))
                .findFirst();
        return findedUser;
    }
}
