package by.bsuir.dao.mapper.builder.impl;

import by.bsuir.dao.mapper.builder.RowMapperBuilder;
import by.bsuir.domain.entity.Segment;
import by.bsuir.domain.util.builder.impl.SegmentBuilderImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SegmentRowMapperBuilder implements RowMapperBuilder<Segment> {
    private final int SEGMENT_ID;
    private final int SEGMENT_NAME;

    public SegmentRowMapperBuilder(int SEGMENT_ID, int SEGMENT_NAME) {
        this.SEGMENT_ID = SEGMENT_ID;
        this.SEGMENT_NAME = SEGMENT_NAME;
    }

    @Override
    public Segment getBuiltEntity(ResultSet set) throws SQLException {
        return doBuildEntity(set);
    }

    private Segment doBuildEntity(ResultSet set) throws SQLException {
        return
                new SegmentBuilderImpl(set.getString(SEGMENT_ID))
                        .withName(set.getString(SEGMENT_NAME))
                        .build();
    }
}
