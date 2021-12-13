package by.bsuir.domain.service;

import by.bsuir.domain.entity.Segment;
import by.bsuir.domain.service.exception.ServiceException;

import java.util.List;

public interface SegmentService {

    void addNewSegment(Segment segment) throws ServiceException;

    void updateSegment(Segment segment) throws ServiceException;

    void deleteSegment(String segmentId) throws ServiceException;

    List<Segment> getAllSegments() throws ServiceException;
}
