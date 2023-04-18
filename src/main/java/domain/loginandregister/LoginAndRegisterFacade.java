package domain.loginandregister;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class LoginAndRegisterFacade {

    RegisterRepository registerRepository;
    public User register(User user) {

        registerRepository.saveUser(user);
        return user;
    }
    public User findByUserName(String username) {
        User findedUser = registerRepository.findUserByUsername(username).orElseThrow(() -> new RuntimeException("not found"));
        return findedUser;
    }
}
