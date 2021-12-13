package by.bsuir.domain.command.impl.user;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.connector.Connection;
import by.bsuir.domain.message.Message;

public class UpdateUserCommand implements Command {

    private Connection connection;

    public UpdateUserCommand(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Message execute(Message request) {
        request.setCommand(Commands.UPDATE_USER);
        return connection.makeDialog(request);
    }
}
