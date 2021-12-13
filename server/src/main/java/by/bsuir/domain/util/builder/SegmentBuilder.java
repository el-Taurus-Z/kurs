package by.bsuir.domain.util.builder;

import by.bsuir.domain.entity.Segment;

public interface SegmentBuilder {

    SegmentBuilder withName(String name);

    Segment build();
}
