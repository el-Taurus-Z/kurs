package by.bsuir.domain.command.impl.user;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.connector.Connection;
import by.bsuir.domain.message.Message;
import by.bsuir.starter.ControllerManager;

import static by.bsuir.domain.configuration.Pages.SIGN_IN_PAGE;

public class SignUpCommand implements Command {

    private final Connection connection;

    public SignUpCommand(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Message execute(Message request) {

        request.setCommand(Commands.SIGN_UP);

        Message response = connection.makeDialog(request);

        String exception = (String) response.getByKey("ex");

        if (exception == null) {
            ControllerManager.changeScene(SIGN_IN_PAGE);
        }


        return response;
    }
}
