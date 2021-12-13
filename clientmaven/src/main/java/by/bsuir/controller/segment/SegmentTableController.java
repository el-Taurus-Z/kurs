package by.bsuir.controller.segment;

import by.bsuir.controller.ShowAlert;
import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.command.factory.CommandFactory;
import by.bsuir.domain.configuration.Pages;
import by.bsuir.domain.entity.Segment;
import by.bsuir.domain.message.Message;
import by.bsuir.starter.ControllerManager;
import by.bsuir.starter.ShowDialogController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import static by.bsuir.controller.SendInfoToServer.sendInfoToServer;

public class SegmentTableController {

    @FXML
    private TableView<Segment> table;
    @FXML
    private TableColumn<Segment, String> columnName;

    private ShowDialogController dialogController = new ShowDialogController();
    private DialogSegmentTableController dialogSegmentTableController;

    public void initialize() {
        dialogSegmentTableController = (DialogSegmentTableController) dialogController
                .getDialogController(dialogSegmentTableController, Pages.DIALOG_SEGMENT_PAGE);
        prepareAndSetDataToTable();
        initListeners();
    }


    private void prepareAndSetDataToTable() {
        initColumns();
        initList();
        table.refresh();
    }

    private void initListeners() {
        table.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                viewChange(table.getSelectionModel().getSelectedItem());
            }
        });

    }

    private void initList() {
        Command command = CommandFactory.getInstance().createCommand(Commands.GET_ALL_SEGMENT);
        Message message = new Message();
        Message response = command.execute(message);
        ObservableList<Segment> segments = (ObservableList<Segment>) response.getByKey("segments");
        table.setItems(segments);
    }


    private void initColumns() {
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    public void actionButtonPressed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) {
            return;
        }
        Segment selectedItem = table.getSelectionModel().getSelectedItem();
        Button clickedButton = (Button) source;

        switch (clickedButton.getId()) {
            case "btnAddNew": {
                showDialog();
                if (dialogSegmentTableController.getSegment() != null) {

                    sendInfoToServer(Commands.ADD_NEW_SEGMENT
                            , "segment", dialogSegmentTableController.getSegment());
                    dialogSegmentTableController.setNullEntity();
                    prepareAndSetDataToTable();
                }
            }
            break;
            case "btnChange": {
                if (selectedItem != null) {
                    viewChange(selectedItem);
                } else {
                    ShowAlert.showErrorAlert("Для изменения выберите запись из таблицы!");
                }
            }
            break;
            case "btnDelete": {
                if (selectedItem != null) {
                    sendInfoToServer(Commands.DELETE_SEGMENT, "segmentId", selectedItem.getId());
                    prepareAndSetDataToTable();
                } else {
                    ShowAlert.showErrorAlert("Для изменения выберите запись из таблицы!");
                }
            }
            break;
        }
    }

    private void viewChange(Segment selected) {
        if (selected != null) {
            dialogSegmentTableController.setSegment(selected);
            //
            showDialog();
            //
            sendInfoToServer(Commands.UPDATE_SEGMENT,
                    "segment",
                    dialogSegmentTableController.getSegment());
            dialogSegmentTableController.setNullEntity();
            prepareAndSetDataToTable();
        }
    }


    private void showDialog() {
        dialogController.showDialog();
    }


    public void goBack(ActionEvent actionEvent) {
        ControllerManager.changeScene(Pages.USER_PERSONAL_CABINET_PAGE);
    }
}
