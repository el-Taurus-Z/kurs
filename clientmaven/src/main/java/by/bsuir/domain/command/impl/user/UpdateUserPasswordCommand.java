package by.bsuir.domain.command.impl.user;


import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.connector.Connection;
import by.bsuir.domain.message.Message;

public class UpdateUserPasswordCommand implements Command {

    private Connection connection;

    public UpdateUserPasswordCommand(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Message execute(Message request) {
        request.setCommand(Commands.UPDATE_USER_PASSWORD);
        Message response = connection.makeDialog(request);
        return response;
    }
}

