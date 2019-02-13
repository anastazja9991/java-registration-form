package sas.karolina.registrationproject.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sas.karolina.registrationproject.registration.Registration;
import sas.karolina.registrationproject.registration.RegistrationService;

import javax.validation.Valid;


@Controller
public class LoginController {

    private RegistrationService registrationService;

    public LoginController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @InitBinder("login")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new LoginValidator(registrationService));
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("login", new LoginDto());
        return "login";
    }
    @PostMapping("/login")
    public String loginSubmit(@Valid @ModelAttribute("login") LoginDto loginDto, BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
           return "login";
      }
      Registration registration = registrationService.getRegistration(loginDto.getLogin());
      model.addAttribute("registration", registration);
       return "final";
    }
}
