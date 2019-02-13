package sas.karolina.registrationproject.login;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sas.karolina.registrationproject.registration.RegistrationService;


public class LoginValidator implements Validator {

    private final RegistrationService registrationService;

    public LoginValidator(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return LoginDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginDto loginDto = (LoginDto) target;
        if(!registrationService.areCredentialsCorrect(loginDto.getLogin(), loginDto.getPassword())) {
            errors.rejectValue("login", "invalidcredentials.login", "Login lub hasło niepoprawne");
        }
    }
}
