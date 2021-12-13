package by.bsuir.domain.command.impl.user;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.entity.User;
import by.bsuir.domain.entity.UserStatus;
import by.bsuir.domain.message.Message;
import by.bsuir.domain.service.UserService;
import by.bsuir.domain.service.exception.ServiceException;
import by.bsuir.domain.service.factory.ServiceFactory;
import by.bsuir.domain.util.builder.impl.UserBuilderImpl;

public class SignUpCommand implements Command {

    private final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public Message execute(Message request) {
        final String login = (String) request.getByKey("login");
        final String password = (String) request.getByKey("password");
        final String name = (String) request.getByKey("name");
        final String surname = (String) request.getByKey("surname");
        final String phone = (String) request.getByKey("phone");
        final UserStatus status = (UserStatus) request.getByKey("userStatus");

        final User user = new UserBuilderImpl()
                .withUserStatus(status)
                .withLogin(login)
                .withPassword(password)
                .withName(name)
                .withSurname(surname)
                .withPhone(phone)
                .build();

        final Message response = new Message();
        try {
            userService.addNewUser(user);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.add("ex", e.getMessage());
        }

        return response;
    }


}
