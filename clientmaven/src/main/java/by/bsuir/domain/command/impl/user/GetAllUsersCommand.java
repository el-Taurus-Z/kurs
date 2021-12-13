package by.bsuir.domain.command.impl.user;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.connector.Connection;
import by.bsuir.domain.entity.User;
import by.bsuir.domain.message.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class GetAllUsersCommand implements Command {

    private Connection connection;

    public GetAllUsersCommand(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Message execute(Message request)  {
        request.setCommand(Commands.GET_ALL_USERS);
        Message response = connection.makeDialog(request);
        List<User> users = (List<User>) response.getByKey("users");

        ObservableList<User> userObservableList = FXCollections.observableList(users);

        response.add("users", userObservableList);

        return response;
    }
}
