package by.bsuir.domain.util.builder;

import by.bsuir.domain.entity.User;
import by.bsuir.domain.entity.UserStatus;

public interface UserBuilder {

    UserBuilder withLogin(String login);

    UserBuilder withPassword(String password);

    UserBuilder withName(String name);

    UserBuilder withSurname(String surname);

    UserBuilder withPhone(String phone);

    UserBuilder withUserStatus(UserStatus status);

    User build();
}
