package by.bsuir.domain.command.impl.company;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.connector.Connection;
import by.bsuir.domain.message.Message;

public class UpdateCompanyCommand implements Command {

    private Connection connection;

    public UpdateCompanyCommand(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Message execute(Message request) {
        request.setCommand(Commands.UPDATE_COMPANY);
        return connection.makeDialog(request);

    }
}
