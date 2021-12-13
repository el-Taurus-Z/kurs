package by.bsuir.domain.command.factory;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.command.impl.SingInCommand;
import by.bsuir.domain.command.impl.company.*;
import by.bsuir.domain.command.impl.segment.AddNewSegmentCommand;
import by.bsuir.domain.command.impl.segment.DeleteSegmentCommand;
import by.bsuir.domain.command.impl.segment.GetAllSegmentsCommand;
import by.bsuir.domain.command.impl.segment.UpdateSegmentCommand;
import by.bsuir.domain.command.impl.user.*;
import by.bsuir.domain.connector.Connection;
import by.bsuir.domain.connector.Connector;

public class CommandFactory {

    private static final CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance() {
        return instance;
    }

    private CommandFactory() {

    }

    private static final Connection connection = Connector.getConnection();

    public Command createCommand(Commands command) {

        switch (command) {
            case SIGN_IN:
                return new SingInCommand(connection);

            /////
            case SIGN_UP:
                return new SignUpCommand(connection);
            case GET_ALL_USERS:
                return new GetAllUsersCommand(connection);
            case UPDATE_USER:
                return new UpdateUserCommand(connection);
            case ADD_NEW_USER:
                return new AddNewUserCommand(connection);
            case DELETE_USER:
                return new DeleteUserCommand(connection);
            case UPDATE_USER_PASSWORD:
                return new UpdateUserPasswordCommand(connection);
            /////
            case ADD_NEW_SEGMENT:
                return new AddNewSegmentCommand(connection);
            case UPDATE_SEGMENT:
                return new UpdateSegmentCommand(connection);
            case DELETE_SEGMENT:
                return new DeleteSegmentCommand(connection);
            case GET_ALL_SEGMENT:
                return new GetAllSegmentsCommand(connection);
            /////
            case ADD_NEW_COMPANY:
                return new AddNewCompanyCommand(connection);
            case UPDATE_COMPANY:
                return new UpdateCompanyCommand(connection);
            case DELETE_COMPANY:
                return new DeleteCompanyCommand(connection);
            case GET_ALL_COMPANIES:
                return new GetAllCompaniesCommand(connection);
            /////

            case GET_ALL_MARKED_COMPANIES:
                return new GetAllMarkedCompaniesCommand(connection);
            case GET_ALL_NON_MARKED_COMPANIES:
                return new GetAllNonMarkedCompaniesCommand(connection);


        }

        throw new RuntimeException("NO COMMAND");
    }

}
