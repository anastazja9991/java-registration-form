package sas.karolina.registrationproject.registration;

import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepository extends CrudRepository<Registration, Long> {

    Registration findByLogin(String login);
}

