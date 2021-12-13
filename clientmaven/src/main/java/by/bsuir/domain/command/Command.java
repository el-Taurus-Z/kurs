package by.bsuir.domain.command;

import by.bsuir.domain.message.Message;

public interface Command {

    Message execute(Message request);
}
