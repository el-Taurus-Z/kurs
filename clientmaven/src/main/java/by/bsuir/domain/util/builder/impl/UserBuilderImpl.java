package by.bsuir.domain.util.builder.impl;

import by.bsuir.domain.entity.User;
import by.bsuir.domain.entity.UserStatus;
import by.bsuir.domain.util.builder.UserBuilder;

public class UserBuilderImpl implements UserBuilder {

    private String id;
    private UserStatus status;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String phone;

    public UserBuilderImpl() {
        this.id = "";
    }

    public UserBuilderImpl(String id) {
        this.id = id;
    }


    @Override
    public UserBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    @Override
    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public UserBuilder withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public UserBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public UserBuilder withUserStatus(UserStatus status) {
        this.status = status;
        return this;
    }

    @Override
    public User build() {
        final User user = new User();
        user.setId(id);
        user.setUserStatus(status);
        user.setName(name);
        user.setSurname(surname);
        user.setPhone(phone);
        user.setLogin(login);
        user.setPassword(password);
        return user;
    }
}
