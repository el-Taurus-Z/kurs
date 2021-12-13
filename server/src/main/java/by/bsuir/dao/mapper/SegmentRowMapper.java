package by.bsuir.dao.mapper;

import by.bsuir.dao.core.RowMapper;
import by.bsuir.dao.mapper.builder.impl.SegmentRowMapperBuilder;
import by.bsuir.domain.entity.Segment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SegmentRowMapper implements RowMapper<Segment> {

    private static final int SEGMENT_ID = 1;
    private static final int SEGMENT_NAME = 2;

    @Override
    public Segment mapRow(ResultSet set) throws SQLException {
        return
                new SegmentRowMapperBuilder(SEGMENT_ID, SEGMENT_NAME)
                        .getBuiltEntity(set);
    }
}
