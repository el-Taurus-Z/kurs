package by.bsuir.domain.command.impl.user;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.message.Message;
import by.bsuir.domain.service.UserService;
import by.bsuir.domain.service.exception.ServiceException;
import by.bsuir.domain.service.factory.ServiceFactory;

public class UpdateUserPasswordCommand implements Command {


    private final UserService userService = ServiceFactory.getInstance().getUserService();


    @Override
    public Message execute(Message request) {
        String userId = (String) request.getByKey("userId");
        String curPass = (String) request.getByKey("curPass");
        String newPass = (String) request.getByKey("newPass");
        String newPassConf = (String) request.getByKey("newPassConf");

        Message response = new Message();
        //

        try {
            userService.updateUserPassword(userId, curPass, newPass, newPassConf);
        } catch (ServiceException e) {
            response.add("ex", e.getMessage());
        }

        return response;
    }


}
