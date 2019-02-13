package sas.karolina.registrationproject.registration;

import javax.validation.constraints.*;


public class RegistrationDto {

    private Long id;
    @NotEmpty(message = "Pole nie może być puste")
    private String name;
    @NotEmpty(message = "Pole nie może być puste")
    private String lastName;
    @Email(message = "Niepoprawny format e-mail")
    private String mail;
    @Min(value = 9, message = "Za krótki numer telefonu")
    private int tel;
    @NotEmpty(message = "Pole nie może być puste")
    private String login;
    @NotEmpty(message = "Pole nie może być puste")
    private String password;
    @NotEmpty(message = "Pole nie może być puste")
    private String password2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}