package by.bsuir.domain.command.impl.segment;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.message.Message;
import by.bsuir.domain.service.SegmentService;
import by.bsuir.domain.service.exception.ServiceException;
import by.bsuir.domain.service.factory.ServiceFactory;

public class DeleteSegmentCommand implements Command {
    private SegmentService segmentService = ServiceFactory.getInstance().getSegmentService();

    @Override
    public Message execute(Message request) {
        Message response = new Message();
        String segmentId = (String) request.getByKey("segmentId");

        try {
            segmentService.deleteSegment(segmentId);
        } catch (ServiceException e) {
            response.add("ex", "can`t delete cateory");
        }
        return response;
    }


}
