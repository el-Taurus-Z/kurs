package by.bsuir.domain.command.impl;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.entity.User;
import by.bsuir.domain.message.Message;
import by.bsuir.domain.service.UserService;
import by.bsuir.domain.service.exception.ServiceException;
import by.bsuir.domain.service.factory.ServiceFactory;

public class SignInCommand implements Command {

    private UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public Message execute(Message request) {

        final String login = (String) request.getByKey("login");
        final String password = (String) request.getByKey("password");

        final Message response = new Message();

        try {
            User user = userService.signIn(login, password);
            if (user != null) {
                response.add("user", user);
            } else {
                response.add("ex", "Неверный логин или пароль!");
            }

        } catch (ServiceException e) {
            e.printStackTrace();
            response.add("ex", e.getMessage());
        }

        return response;
    }

}
