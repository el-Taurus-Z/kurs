package by.bsuir.domain.connector;


import by.bsuir.domain.message.Message;

public interface Connection {

    int PORT =4549;

    void send(Message message);

    Message makeDialog(Message message);
    void close();
}
