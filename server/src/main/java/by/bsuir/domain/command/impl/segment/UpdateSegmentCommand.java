package by.bsuir.domain.command.impl.segment;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.entity.Segment;
import by.bsuir.domain.message.Message;
import by.bsuir.domain.service.SegmentService;
import by.bsuir.domain.service.exception.ServiceException;
import by.bsuir.domain.service.factory.ServiceFactory;

public class UpdateSegmentCommand implements Command {

    private SegmentService segmentService = ServiceFactory.getInstance().getSegmentService();

    @Override
    public Message execute(Message request) {
        Segment segment = (Segment) request.getByKey("segment");

        Message response = new Message();
        try {
            segmentService.updateSegment(segment);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.add("ex", e.getMessage());
        }
        return response;
    }

}
