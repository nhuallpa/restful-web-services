package com.huallpa.rest.webservices.restfulwebservices.user;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {

    private Integer Id;

    @Size(min=2)
    private String name;

    @Past
    private Date birthDate;

    protected User() {

    }

    public User(Integer id, String name, Date birth) {
        Id = id;
        this.name = name;
        this.birthDate = birth;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", birth=" + birthDate +
                '}';
    }
}
