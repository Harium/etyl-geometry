package com.harium.etyl.geometry;

import com.harium.etyl.geometry.path.*;

import java.util.ArrayList;
import java.util.List;

public class Path2D {

    Point2D lastPoint = new Point2D();

    List<DataCurve> curves = new ArrayList<>();

    public Path2D() {
        super();
    }

    public void add(DataCurve curve) {
        curves.add(curve);
    }

    public boolean isEmpty() {
        return curves.isEmpty();
    }

    public int size() {
        return curves.size();
    }

    public List<DataCurve> getCurves() {
        return curves;
    }

    public void removeLast() {
        curves.remove(curves.size() - 1);
    }

    public DataCurve lastCurve() {
        return curves.get(curves.size() - 1);
    }

    /**
     * Method to add a segment (based on awt methods)
     *
     * @param x
     * @param y
     */
    public void lineTo(double x, double y) {
        Point2D end = new Point2D(x, y);
        add(new SegmentCurve(lastPoint, end));
        lastPoint = end;
    }

    public void quadTo(double c1x, double c1y, double x, double y) {
        Point2D end = new Point2D(x, y);
        Point2D control1 = new Point2D(c1x, c1y);
        add(new QuadraticCurve(lastPoint, end, control1));
        lastPoint = end;
    }

    public void curveTo(double c1x, double c1y, double c2x, double c2y, double x, double y) {
        Point2D end = new Point2D(x, y);
        Point2D control1 = new Point2D(c1x, c1y);
        Point2D control2 = new Point2D(c2x, c2y);
        add(new CubicCurve(lastPoint, end, control1, control2));
        lastPoint = end;
    }

    public void moveTo(double x, double y) {
        lastPoint.setLocation(x, y);
    }

    public void close() {
        if (curves.size() < 2) {
            return;
        }
        DataCurve first = curves.get(0);
        DataCurve last = lastCurve();

        last.setEnd(first.getStart());
        if (last.getType() == CurveType.CUBIC_BEZIER) {
            // TODO Calculate control point 2?
        }
    }

}
