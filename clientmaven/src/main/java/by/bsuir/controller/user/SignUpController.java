package by.bsuir.controller.user;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.command.factory.CommandFactory;
import by.bsuir.domain.entity.UserStatus;
import by.bsuir.domain.message.Message;
import by.bsuir.domain.util.validator.UserValidator;
import by.bsuir.starter.ControllerManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import static by.bsuir.controller.ShowAlert.showErrorAlert;
import static by.bsuir.domain.configuration.Pages.SIGN_IN_PAGE;

public class SignUpController {

    @FXML
    private TextField textLogin;

    @FXML
    private TextField textPassword;

    @FXML
    private TextField textName;

    @FXML
    private TextField textSurname;

    @FXML
    private TextField textPhone;


    public void initialize() {
        textLogin.setPromptText("введите логин");
        textPassword.setPromptText("введите пароль");
        textName.setPromptText("введите имя");
        textSurname.setPromptText("введите фамилию");
        textPhone.setPromptText("телефон: +375291111111");
    }

    public void signUp(ActionEvent actionEvent) {
        final String login = textLogin.getText();
        final String password = textPassword.getText();
        final String name = textName.getText();
        final String surname = textSurname.getText();
        final String phone = textPhone.getText();

        if (!(
                login.equals("")
                        && password.equals("")
                        && name.equals("")
                        && surname.equals("")
                        && phone.equals(""))) {

            if (UserValidator.validatePhone(phone)) {
                Message message = new Message();


                message.add("login", login);
                message.add("password", password);
                message.add("name", name);
                message.add("surname", surname);
                message.add("phone", phone);
                message.add("userStatus", UserStatus.USER);

                Command command = CommandFactory.getInstance().createCommand(Commands.SIGN_UP);
                Message response = command.execute(message);
                String exception = (String) response.getByKey("ex");
                if (exception != null) {
                    showErrorAlert(exception);
                }
            } else {
                showErrorAlert("Введите корретный телефон!");
            }
        }else{
            showErrorAlert("Заполните все поля");
        }
    }


    public void goBack(ActionEvent actionEvent) {
        ControllerManager.changeScene(SIGN_IN_PAGE);
    }
}
