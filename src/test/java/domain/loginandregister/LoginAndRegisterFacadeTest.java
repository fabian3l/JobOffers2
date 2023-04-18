package domain.loginandregister;

import domain.loginandregister.dto.UserDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class LoginAndRegisterFacadeTest {

    private final RegisterRepository registerRepository = new RegisterRepositoryTestImpl();
    @Test
    public void should_register_user() {
        //given
        String id = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        User user = User.builder()
                .username("username")
                .password("password")
                .id(id)
                .build();
        User user1 = User.builder()
                .username("username1")
                .password("password1")
                .id(id2)
                .build();
        LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterConfiguration().createForTest(registerRepository);
        loginAndRegisterFacade.register(user);
        loginAndRegisterFacade.register(user1);
        //when
        User findUser = loginAndRegisterFacade.findByUserName("username");
        //then
        User expectedUser = User.builder()
                .username("username")
                .password("password")
                .id(id)
                .build();
        assertThat(findUser).isEqualTo(expectedUser);

    }
    @Test
    public void should_find_user_by_username() {
        //given
        String id = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        User user = User.builder()
                .username("username")
                .password("password")
                .id(id)
                .build();
        User user1 = User.builder()
                .username("username1")
                .password("password1")
                .id(id2)
                .build();
        LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterConfiguration().createForTest(registerRepository);
        loginAndRegisterFacade.register(user);
        loginAndRegisterFacade.register(user1);
        //when
        User findUser = loginAndRegisterFacade.findByUserName("username");
        //then
        User expectedUser = User.builder()
                .username("username")
                .password("password")
                .id(id)
                .build();
        assertThat(findUser).isEqualTo(expectedUser);
    }
    @Test
    public void should_throw_exception_when_user_not_found() {
        //given
        String id = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        User user = User.builder()
                .username("username")
                .password("password")
                .id(id)
                .build();
        User user1 = User.builder()
                .username("username1")
                .password("password1")
                .id(id2)
                .build();
        LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterConfiguration().createForTest(registerRepository);
        loginAndRegisterFacade.register(user);
        loginAndRegisterFacade.register(user1);
        //when
        //then
        assertThrows(RuntimeException.class, () -> loginAndRegisterFacade.findByUserName("wrong"), "not found");
    }

}