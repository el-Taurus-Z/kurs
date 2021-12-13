package by.bsuir.dao.impl.segment;

import by.bsuir.dao.SegmentRepository;
import by.bsuir.dao.core.InitializerRepository;
import by.bsuir.dao.core.exception.JdbcTemplateException;
import by.bsuir.dao.exception.DAOException;
import by.bsuir.dao.mapper.SegmentRowMapper;
import by.bsuir.domain.entity.Segment;

import java.util.List;

import static by.bsuir.dao.impl.segment.SegmentSqlUtil.*;

public class SegmentSqlRepository extends InitializerRepository implements SegmentRepository {


    @Override
    public Segment getEntityById(String id) throws DAOException {
        try {
            return jdbcTemplate.queryForObject(GET_SEGMENT_BY_ID, new SegmentRowMapper(), id);
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean removeById(String id) throws DAOException {
        try {
            jdbcTemplate.update(DELETE_SEGMENT, id);
            return true;
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean add(Segment segment) throws DAOException {
        try {
            jdbcTemplate.update(ADD_NEW_SEGMENT,
                    segment.getName());
            return true;
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean update(Segment segment) throws DAOException {
        try {
            jdbcTemplate.update(UPDATE_SEGMENT,
                    segment.getName(),
                    segment.getId());
            return true;
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Segment> getAll() throws DAOException {
        try {
            return jdbcTemplate.query(GET_ALL_SEGMENTS, new SegmentRowMapper());
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }
}
