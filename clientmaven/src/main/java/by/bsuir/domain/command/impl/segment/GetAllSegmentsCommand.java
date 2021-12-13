package by.bsuir.domain.command.impl.segment;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.command.Commands;
import by.bsuir.domain.connector.Connection;
import by.bsuir.domain.entity.Segment;
import by.bsuir.domain.message.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class GetAllSegmentsCommand implements Command {
    private Connection connection;

    public GetAllSegmentsCommand(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Message execute(Message request) {
        request.setCommand(Commands.GET_ALL_SEGMENT);

        Message response = connection.makeDialog(request);
        List<Segment> segments = (List<Segment>) response.getByKey("segments");

        ObservableList<Segment> segmentObservableList = FXCollections.observableList(segments);

        response.add("segments", segmentObservableList);

        return response;
    }
}
