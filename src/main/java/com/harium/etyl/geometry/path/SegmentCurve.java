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
    }

    public Curve getData() {
        return curve;
    }

    public Point2D getStart() {
        return curve.p0;
    }

    public void setStart(Point2D start) {
        curve.p0 = start;
        updateCurve();
    }

    public Point2D getEnd() {
        return curve.p1;
    }

    public void setEnd(Point2D end) {
        curve.p1 = end;
        updateCurve();
    }

    public DataCurve copy(SegmentCurve dataCurve) {
        // Call them directly to not trigger the updateCurve multiple times
        curve.p0.set(dataCurve.curve.p0);
        curve.p1.set(dataCurve.curve.p1);
        updateCurve();

        return this;
    }
}
