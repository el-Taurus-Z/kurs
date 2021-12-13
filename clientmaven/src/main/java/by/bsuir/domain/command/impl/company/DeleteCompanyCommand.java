package by.bsuir.domain.command.impl.company;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.connector.Connection;
import by.bsuir.domain.message.Message;

public class DeleteCompanyCommand implements Command {

    private Connection connection;

    public DeleteCompanyCommand(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Message execute(Message request) {
        request.setCommand(Commands.DELETE_COMPANY);
        return connection.makeDialog(request);
    }
}
