package domain.loginandregister;

public class LoginAndRegisterConfiguration {

    LoginAndRegisterFacade createForTest(RegisterRepository registerRepository) {
        return new LoginAndRegisterFacade(registerRepository);
    }
}
