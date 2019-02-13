package sas.karolina.registrationproject.registration;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegistrationValidator implements Validator {

    private final RegistrationService registrationService;

    public RegistrationValidator(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegistrationDto registrationDto = (RegistrationDto) target;
        if(!(registrationDto.getPassword().equals(registrationDto.getPassword2()))){
            errors.rejectValue("password", "notmatch.password", "Hasła nie są takie same!");
        }
        if( registrationService.isLoginExists(registrationDto.getLogin())) {
            errors.rejectValue("login", "alreadyexists.login", "Login już zajęty");
        }
    }
}
