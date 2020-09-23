package be.intecbrussel.models.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
public class PersonForm {
    @NotNull(message = "Name cannot be null")
    @Size(min=2, max=30)
    private String name;
    @NotNull(message = "Age cannot be null")
    @Min(value = 11, message = "Age should not be less than 11")
    @Max(value = 100, message = "Age should not be greater than 100")
    private Integer age ;
    @Autowired
    public PersonForm() {
        name = "your name";
        age = 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonForm{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
