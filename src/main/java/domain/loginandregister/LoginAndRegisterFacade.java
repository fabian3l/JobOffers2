package domain.loginandregister;

import domain.loginandregister.dto.RegisterUserDto;
import domain.loginandregister.dto.RegistratrionResultDto;
import domain.loginandregister.dto.UserDto;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class LoginAndRegisterFacade {

    private static final String USER_NOT_FOUND = "User not found";
    private final RegisterRepository registerRepository;
    public RegistratrionResultDto register(RegisterUserDto registerUserDto) {
        String id = UUID.randomUUID().toString();
        final User user = User.builder()
                .id(id)
                .username(registerUserDto.username())
                .password(registerUserDto.password())
                .build();
        User savedUser = registerRepository.saveUser(user);
        return new RegistratrionResultDto(savedUser.id(), true, savedUser.username());
    }
    public UserDto findByUserName(String username) {
        return registerRepository.findUserByUsername(username)
                .map(user -> new UserDto(user.id(), user.username(), user.password()))
                .orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND));
    }
}
