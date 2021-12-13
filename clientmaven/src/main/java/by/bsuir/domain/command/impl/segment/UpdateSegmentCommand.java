package by.bsuir.domain.command.impl.segment;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.connector.Connection;
import by.bsuir.domain.message.Message;

public class UpdateSegmentCommand implements Command {

    private final Connection connection;

    public UpdateSegmentCommand(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Message execute(Message request) {
        request.setCommand(Commands.UPDATE_SEGMENT);

        return connection.makeDialog(request);
    }
}