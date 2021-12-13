package by.bsuir.domain.command.factory;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.command.impl.SignInCommand;
import by.bsuir.domain.command.impl.segment.AddNewSegmentCommand;
import by.bsuir.domain.command.impl.segment.DeleteSegmentCommand;
import by.bsuir.domain.command.impl.segment.GetAllSegmentsCommand;
import by.bsuir.domain.command.impl.segment.UpdateSegmentCommand;
import by.bsuir.domain.command.impl.company.*;
import by.bsuir.domain.command.impl.user.*;


public class CommandFactory {


    private static final CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance() {
        return instance;
    }

    private CommandFactory() {

    }


    public Command getCommand(Commands commandName) {

        switch (commandName) {
            case SIGN_IN:
                return new SignInCommand();
            //
            case ADD_NEW_USER:
                return new AddNewUserCommand();
            case GET_ALL_USERS:
                return new GetAllUsersCommand();
            case SIGN_UP:
                return new SignUpCommand();
            case UPDATE_USER:
                return new UpdateUserCommand();
            case DELETE_USER:
                return new DeleteUserCommand();
            case UPDATE_USER_PASSWORD:
                return new UpdateUserPasswordCommand();
            //
            case ADD_NEW_SEGMENT:
                return new AddNewSegmentCommand();
            case UPDATE_SEGMENT:
                return new UpdateSegmentCommand();
            case DELETE_SEGMENT:
                return new DeleteSegmentCommand();
            case GET_ALL_SEGMENT:
                return new GetAllSegmentsCommand();
            //
            case ADD_NEW_COMPANY:
                return new AddNewCompanyCommand();
            case UPDATE_COMPANY:
                return new UpdateCompanyCommand();
            case DELETE_COMPANY:
                return new DeleteCompanyCommand();
            case GET_ALL_COMPANIES:
                return new GetAllCompaniesCommand();

            case GET_ALL_MARKED_COMPANIES:
                return new GetAllMarkedCompaniesCommand();
            case GET_ALL_NON_MARKED_COMPANIES:
                return new GetAllNonMarkedCompaniesCommand();

        }
        return null;
    }
}
