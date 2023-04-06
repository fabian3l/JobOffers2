package domain.loginandregister;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LoginAndRegisterFacade {

    List<User> userList = new ArrayList<User>();
    public User findByUserName(String userName) {
        User findedUser = userList.stream()
                .filter(user -> user.username().equals(userName))
                .findFirst()
                .orElse(null);
        return findedUser;
    }
    public User register(String username, String password) {
        String id = UUID.randomUUID().toString();
        User user = User.builder()
                    .id(id)
                    .username(username)
                    .password(password)
                    .build();
        userList.add(user);
        return user;
    }
}
