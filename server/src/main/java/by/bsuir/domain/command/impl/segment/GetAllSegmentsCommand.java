package by.bsuir.domain.command.impl.segment;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.entity.Segment;
import by.bsuir.domain.message.Message;
import by.bsuir.domain.service.SegmentService;
import by.bsuir.domain.service.exception.ServiceException;
import by.bsuir.domain.service.factory.ServiceFactory;

import java.util.List;

public class GetAllSegmentsCommand implements Command {

    private SegmentService segmentService = ServiceFactory.getInstance().getSegmentService();

    @Override
    public Message execute(Message request) {
        Message response = new Message();
        try {
            List<Segment> segments = segmentService.getAllSegments();
            response.add("segments", segments);
        } catch (ServiceException e) {
            response.add("ex", "can`t get all departments");
        }
        return response;
    }


}
