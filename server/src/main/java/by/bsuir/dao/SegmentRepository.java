package by.bsuir.dao;

import by.bsuir.dao.core.CrudRepository;
import by.bsuir.dao.exception.DAOException;
import by.bsuir.domain.entity.Segment;

import java.util.List;

public interface SegmentRepository extends CrudRepository<Segment> {

    @Override
    Segment getEntityById(String id) throws DAOException;

    @Override
    boolean removeById(String id) throws DAOException;

    @Override
    boolean add(Segment segment) throws DAOException;

    @Override
    boolean update(Segment segment) throws DAOException;

    @Override
    List<Segment> getAll() throws DAOException;
}
