package com.harium.etyl.geometry.path;

import com.harium.etyl.geometry.Point2D;
import com.harium.etyl.geometry.curve.Curve;

/**
 * This class handles a curve and its segmented version
 */
public abstract class DataCurve {

    public static final int SEGMENT_COUNT = 16;

    protected CurveType type;

    protected Curve curve;

    protected Point2D[] segments;

    protected int segmentCount = SEGMENT_COUNT;

    public DataCurve() {

    }

    public abstract Point2D getStart();

    public abstract void setStart(Point2D start);

    public abstract Point2D getEnd();

    public abstract void setEnd(Point2D end);

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
        segments = flattenCurve(segmentCount);
    }

    public Point2D[] flattenCurve(int segmentCount) {
        return curve.flattenCurve(segmentCount);
    }

    public void translate(float x, float y) {
        curve.translate(x, y);
        updateCurve();
    }
}
