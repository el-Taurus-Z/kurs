package by.bsuir.domain.service.impl;

import by.bsuir.dao.SegmentRepository;
import by.bsuir.dao.exception.DAOException;
import by.bsuir.dao.factory.RepositoryFactory;
import by.bsuir.domain.entity.Segment;
import by.bsuir.domain.service.SegmentService;
import by.bsuir.domain.service.exception.ServiceException;

import java.util.List;

public class SegmentServiceImpl implements SegmentService {

    private SegmentRepository segmentRepository = RepositoryFactory.getInstance().getSegmentRepository();

    @Override
    public void addNewSegment(Segment segment) throws ServiceException {
        try {
            segmentRepository.add(segment);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }


    @Override
    public void deleteSegment(String segmentId) throws ServiceException {
        try {
            segmentRepository.removeById(segmentId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void updateSegment(Segment segment) throws ServiceException {
        try {
            segmentRepository.update(segment);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Segment> getAllSegments() throws ServiceException {
        try {
            return segmentRepository.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
