package com.harium.etyl.geometry.path;

import com.harium.etyl.geometry.Point2D;
import com.harium.etyl.geometry.curve.Curve;

import static com.harium.etyl.geometry.path.CurveType.SEGMENT;

public abstract class DataCurve {

    public static final int SEGMENT_COUNT = 16;

    protected CurveType type;

    protected Point2D start;
    protected Point2D end;

    protected Curve curve;

    protected Point2D[] segments;

    protected int segmentCount = SEGMENT_COUNT;

    public DataCurve() {

    }

    public Point2D getStart() {
        return start;
    }

    public void setStart(Point2D start) {
        this.start = start;
        curve.p0 = start;
        updateCurve();
    }

    public Point2D getEnd() {
        return end;
    }

    public void setEnd(Point2D end) {
        this.end = end;
        curve.p1 = end;
        updateCurve();
    }

    public CurveType getType() {
        return type;
    }

    public Curve getData() {
        return curve;
    }

    public int getSegmentCount() {
        return segmentCount;
    }

    public void setSegmentCount(int segmentCount) {
        this.segmentCount = segmentCount;
    }

    protected void updateCurve() {
        segments = curve.flattenCurve(segmentCount);
    }

}
