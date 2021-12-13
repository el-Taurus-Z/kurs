package by.bsuir.domain.command.impl.company;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.connector.Connection;
import by.bsuir.domain.entity.Company;
import by.bsuir.domain.message.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class GetAllCompaniesCommand implements Command {

    private Connection connection;

    public GetAllCompaniesCommand(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Message execute(Message request) {
        request.setCommand(Commands.GET_ALL_COMPANIES);
        Message response = connection.makeDialog(request);
        List<Company> companies = (List<Company>) response.getByKey("companies");

        ObservableList<Company> companyObservableList = FXCollections.observableList(companies);

        response.add("companies", companyObservableList);

        return response;
    }
}
