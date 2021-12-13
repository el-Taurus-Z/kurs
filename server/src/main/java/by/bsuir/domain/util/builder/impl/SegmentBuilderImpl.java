package by.bsuir.domain.util.builder.impl;

import by.bsuir.domain.entity.Segment;
import by.bsuir.domain.util.builder.SegmentBuilder;

public class SegmentBuilderImpl implements SegmentBuilder {

    private String segmentId;
    private String segmentName;

    public SegmentBuilderImpl() {
        this.segmentId = "";
    }


    public SegmentBuilderImpl(String segmentId) {
        this.segmentId = segmentId;
    }

    @Override
    public SegmentBuilder withName(String name) {
        this.segmentName = name;
        return this;
    }

    @Override
    public Segment build() {
        Segment segment = new Segment(segmentId);
        segment.setName(segmentName);
        return segment;
    }
}
