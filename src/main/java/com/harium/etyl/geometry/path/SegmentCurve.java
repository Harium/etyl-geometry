package com.harium.etyl.geometry.path;

import com.harium.etyl.geometry.Point2D;
import com.harium.etyl.geometry.curve.Curve;

public class SegmentCurve extends DataCurve {

    public SegmentCurve() {
        type = CurveType.SEGMENT;
        curve = new Curve();
        segmentCount = 1;
    }

    public SegmentCurve(Point2D start, Point2D end) {
        this();
        curve.p0 = start;
        curve.p1 = end;
        this.start = start;
        this.end = end;
    }

    public Curve getData() {
        return curve;
    }
}
