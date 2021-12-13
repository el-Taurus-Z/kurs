package by.bsuir.controller.user;

import by.bsuir.controller.ShowAlert;
import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.command.factory.CommandFactory;
import by.bsuir.domain.configuration.Pages;
import by.bsuir.domain.entity.User;
import by.bsuir.domain.entity.UserStatus;
import by.bsuir.domain.message.Message;
import by.bsuir.starter.ControllerManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import static by.bsuir.controller.ShowAlert.showErrorAlert;
import static by.bsuir.controller.ShowAlert.showMessageAlert;


public class UpdatePasswordController {

    @FXML
    private PasswordField textCurPass;
    @FXML
    private PasswordField textNewPass;
    @FXML
    private PasswordField textNewConfPass;

    private User user = ControllerManager.getUser();


    public void initialize() {

    }


    public void update(ActionEvent actionEvent) {

        String curPass = textCurPass.getText();
        String newPass = textNewPass.getText();
        String newPassConf = textNewConfPass.getText();

        if (!curPass.equals("")
                && !newPass.equals("")
                && !newPassConf.equals("")) {

            if (newPass.equals(newPassConf)) {


                Message message = new Message();

                message.add("userId", user.getId());
                message.add("curPass", curPass);
                message.add("newPass", newPass);
                message.add("newPassConf", newPassConf);

                Command command = CommandFactory.getInstance().createCommand(Commands.UPDATE_USER_PASSWORD);

                Message response = command.execute(message);
                String exception = (String) response.getByKey("ex");
                if (exception != null) {
                    showErrorAlert(exception);
                    clearFields();
                } else {
                    showMessageAlert("Пароль сменен!");
                    clearFields();
                }
            } else {
                ShowAlert.showErrorAlert("новый пароль не совпал с подтверждённым!");
                clearFields();
            }

        } else {
            ShowAlert.showErrorAlert("Заполните все поля");
        }

    }

    private void clearFields() {
        this.textCurPass.setText("");
        this.textNewPass.setText("");
        this.textNewConfPass.setText("");
    }

    public void back(ActionEvent actionEvent) {
        ControllerManager.changeScene(Pages.USER_PERSONAL_CABINET_PAGE);
    }
}
