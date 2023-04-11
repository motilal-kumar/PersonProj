package com.example.personproj.entity;

import javax.persistence.*;

@Embeddable
public class Author {

    private String name;
    private String login;

    public Author(String name, String login) {
        this.name = name;
        this.login = login;
    }

    public Author() {
        }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }
}
