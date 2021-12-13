package by.bsuir.controller;


import by.bsuir.controller.listener.ServerContextListener;
import by.bsuir.domain.server.Server;


public class Controller {

    public static void main(String[] args) {
        ServerContextListener.getInstance().init();
        //
        Server server = new Server();
        server.startServer();
        //
        ServerContextListener.getInstance().destroy();
    }
}
