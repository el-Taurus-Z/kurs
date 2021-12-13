package by.bsuir.domain.manager;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.factory.CommandFactory;
import by.bsuir.domain.message.Message;


public class Manager {

    public Message doAction(Message message) {
        CommandFactory factory = CommandFactory.getInstance();
        Command command = factory.getCommand(message.getCommand());
        return command.execute(message);
    }
}
