package by.bsuir.domain.command.impl.company;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.connector.Connection;
import by.bsuir.domain.message.Message;

public class AddNewCompanyCommand implements Command {

    private Connection connection;

    public AddNewCompanyCommand(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Message execute(Message request) {
        request.setCommand(Commands.ADD_NEW_COMPANY);
        return connection.makeDialog(request);
    }
}
