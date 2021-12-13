package by.bsuir.domain.command.impl.user;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.entity.User;
import by.bsuir.domain.message.Message;
import by.bsuir.domain.service.UserService;
import by.bsuir.domain.service.exception.ServiceException;
import by.bsuir.domain.service.factory.ServiceFactory;

import java.util.List;

public class GetAllUsersCommand implements Command {

    private UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public Message execute(Message request) {
        Message response = new Message();
        try {
            List<User> users = userService.getAll();
            response.add("users", users);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.add("ex", e.getMessage());
        }

        return response;
    }

}
