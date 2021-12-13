package by.bsuir.domain.command.impl;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.connector.Connection;
import by.bsuir.domain.entity.User;
import by.bsuir.domain.message.Message;
import by.bsuir.starter.ControllerManager;

import static by.bsuir.domain.configuration.Pages.USER_PERSONAL_CABINET_PAGE;

public class SingInCommand implements Command {

    private final Connection connection;

    public SingInCommand(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Message execute(Message request) {

        request.setCommand(Commands.SIGN_IN);
        Message response = connection.makeDialog(request);
        User user = (User) response.getByKey("user");

        if (user != null) {
            ControllerManager.setUser(user);
            ControllerManager.changeScene(USER_PERSONAL_CABINET_PAGE);
        }
        return response;
    }


}
