package sas.karolina.registrationproject.login;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginDto {

    @NotNull(message = "Wpisz poprawny login")
    @Size(min=3, max=20)
    private String login;
    @NotNull(message = "Wpisz poprawne hasło")
    @Size(min=5, max=20)
    private String password;

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}

