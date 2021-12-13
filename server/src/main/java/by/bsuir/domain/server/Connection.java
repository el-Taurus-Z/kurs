package by.bsuir.domain.server;


import by.bsuir.domain.message.Message;


public interface Connection {

    void send(Message message);

    void close();
}
