package by.bsuir.controller;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.command.factory.CommandFactory;
import by.bsuir.domain.message.Message;

public final class SendInfoToServer {
    private SendInfoToServer() {
    }


    public static boolean sendInfoToServer(Commands addNewPatient,
                                           String key,
                                           Object data) {

        Command command = CommandFactory.getInstance().createCommand(addNewPatient);
        Message request = new Message();
        request.add(key, data);
        Message response = command.execute(request);

        String exceptionMessage = (String) response.getByKey("ex");
        if (exceptionMessage != null) {
            ShowAlert.showErrorAlert(exceptionMessage);
            return false;
        } else {
            return true;
        }
    }
}
