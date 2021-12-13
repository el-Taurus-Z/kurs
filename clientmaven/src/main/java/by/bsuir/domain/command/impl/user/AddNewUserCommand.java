package by.bsuir.domain.command.impl.user;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.connector.Connection;
import by.bsuir.domain.message.Message;

public class AddNewUserCommand implements Command {

    private Connection connection;

    public AddNewUserCommand(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Message execute(Message request)  {

        request.setCommand(Commands.ADD_NEW_USER);

        Message response = connection.makeDialog(request);

        return response;
    }
}
