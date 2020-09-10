package be.intecbrussel.models.users;

import org.springframework.beans.factory.annotation.Autowired;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {
    @NotNull(message = "Un nom d'utilisateur est requis")
    @Size(min=2, max=30)
    private String name;
    @NotNull(message = "Un mot de passe est requis")
    @Size(min=8, max=30)
    private String password;
    @Autowired
    public Person() {
        name = "your name";
        password = "your password";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PersonForm{" +
                "name='" + name + '\'' +
                ", password=" + password +
                '}';
    }
}
