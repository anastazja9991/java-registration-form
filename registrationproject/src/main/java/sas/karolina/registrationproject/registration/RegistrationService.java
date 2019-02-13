package sas.karolina.registrationproject.registration;

import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public void save(RegistrationDto registrationDto) {
        Registration registration = new Registration();
        registration.setId(registrationDto.getId());
        registration.setName(registrationDto.getName());
        registration.setLastName(registrationDto.getLastName());
        registration.setLogin(registrationDto.getLogin());
        registration.setMail(registrationDto.getMail());
        registration.setTel(registrationDto.getTel());
        registration.setPassword(Sha512.hash(registrationDto.getPassword()));
        registrationRepository.save(registration);
    }

    public boolean areCredentialsCorrect(String login, String password) {
        try {
            Registration registration = registrationRepository.findByLogin(login);
            if (registration == null) {
                return false;
            }
          String hashedPassword = Sha512.hash(password);
            return registration.getPassword().equals(hashedPassword);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginExists(String login) {
        try {
            Registration registration = registrationRepository.findByLogin(login);
            return registration != null ? true : false;
        } catch (Exception e) {
            return false;
        }
    }

    public Registration getRegistration(String login) {
        return registrationRepository.findByLogin(login);
    }
}
