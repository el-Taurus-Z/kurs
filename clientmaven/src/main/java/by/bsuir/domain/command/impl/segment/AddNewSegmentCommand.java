package by.bsuir.domain.command.impl.segment;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.connector.Connection;
import by.bsuir.domain.message.Message;

public class AddNewSegmentCommand implements Command {
    private Connection connection;

    public AddNewSegmentCommand(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Message execute(Message request) {
        request.setCommand(Commands.ADD_NEW_SEGMENT);

        Message response = connection.makeDialog(request);

        return response;
    }
}
