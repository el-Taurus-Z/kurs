package by.bsuir.domain.command.impl.user;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.message.Message;
import by.bsuir.domain.service.UserService;
import by.bsuir.domain.service.exception.ServiceException;
import by.bsuir.domain.service.factory.ServiceFactory;

public class DeleteUserCommand implements Command {

    private UserService service = ServiceFactory.getInstance().getUserService();

    @Override
    public Message execute(Message request) {
        String id = (String) request.getByKey("userId");
        Message response = new Message();
        try {
            service.deleteUser(id);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.add("ex", e.getMessage());
        }

        return response;
    }


}
