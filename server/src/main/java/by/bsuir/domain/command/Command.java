package by.bsuir.domain.command;

import by.bsuir.domain.message.Message;

import java.io.Serializable;


public interface Command extends Serializable {

    Message execute(Message request);

}
