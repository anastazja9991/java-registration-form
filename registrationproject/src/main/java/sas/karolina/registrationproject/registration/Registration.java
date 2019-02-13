package sas.karolina.registrationproject.registration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Registration {

    @GeneratedValue
    @Id
    private Long id;
    @Column
    @NotNull
    @Size(min = 3, max = 20)
    private String name;
    @Column
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;
    @Column
    @NotNull
    @Email
    private String mail;
    @Column
    @NotNull
    @Min(value = 9)
    private int tel;
    @Column
    @NotNull
    @Size(min = 4, max = 20)
    private String login;
    @Column
    @NotNull
    @Size(min = 5, max = 200)
    private String password;

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
}

