package domain.loginandregister;

import domain.loginandregister.dto.RegisterUserDto;
import domain.loginandregister.dto.RegistratrionResultDto;
import domain.loginandregister.dto.UserDto;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class LoginAndRegisterFacadeTest {

    private final RegisterRepository registerRepository = new RegisterRepositoryTestImpl();
    private final LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterConfiguration().createForTest(registerRepository);
    @Test
    public void should_register_user() {
        //given
        RegisterUserDto registerUserDto = new RegisterUserDto("username", "password");
        //when
        RegistratrionResultDto register = loginAndRegisterFacade.register(registerUserDto);
        //then
        assertAll(
                () -> assertThat(register.isCreated()).isTrue(),
                () -> assertThat(register.username()).isEqualTo("username")
        );
    }
    @Test
    public void should_find_user_by_username() {
        //given
        RegisterUserDto registerUserDto = new RegisterUserDto("username", "password");
        RegistratrionResultDto register = loginAndRegisterFacade.register(registerUserDto);
        //when
        UserDto findedUser = loginAndRegisterFacade.findByUserName(register.username());
        //then
        assertThat(findedUser).isEqualTo(new UserDto(register.id(), "username", "password"));
    }
    @Test
    public void should_throw_exception_when_user_not_found() {
        //given
        String username = "someUser";

        //when
        Throwable thrown = catchThrowable(() -> loginAndRegisterFacade.findByUserName(username));
        //then
        AssertionsForClassTypes.assertThat(thrown)
                .isInstanceOf(UsernameNotFoundException.class)
                .hasMessage("User not found");
    }

}