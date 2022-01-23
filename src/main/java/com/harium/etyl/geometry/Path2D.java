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

    public void scale(float factor) {
        for (DataCurve curve : curves) {
            curve.getStart().scale(factor);
            curve.getEnd().scale(factor);

            if (CurveType.QUADRATIC_BEZIER == curve.getType()) {
                QuadraticCurve quadratic = (QuadraticCurve) curve;
                quadratic.getControl1().scale(factor);

            } else if (CurveType.CUBIC_BEZIER == curve.getType()) {
                CubicCurve cubic = (CubicCurve) curve;

                cubic.getControl1().scale(factor);
                cubic.getControl2().scale(factor);
            }
        }
    }

    public void flipHorizontal() {
        Point2D[] boundingBox = calculateBoundingBox();

        double x = boundingBox[0].x;
        double maxX = boundingBox[1].x;

        for (DataCurve curve : curves) {
            curve.getStart().x = x - curve.getStart().x + maxX;
            curve.getEnd().x = x - curve.getEnd().x + maxX;

            if (CurveType.QUADRATIC_BEZIER == curve.getType()) {
                QuadraticCurve quadratic = (QuadraticCurve) curve;
                quadratic.getControl1().x = x - quadratic.getControl1().x + maxX;

            } else if (CurveType.CUBIC_BEZIER == curve.getType()) {
                CubicCurve cubic = (CubicCurve) curve;

                cubic.getControl1().x = x - cubic.getControl1().x + maxX;
                cubic.getControl2().x = x - cubic.getControl2().x + maxX;
            }
        }
    }

    public void flipVertical() {
        Point2D[] boundingBox = calculateBoundingBox();

        double y = boundingBox[0].y;
        double maxY = boundingBox[1].y;

        for (DataCurve curve : curves) {
            curve.getStart().y = y - curve.getStart().y + maxY;
            curve.getEnd().y = y - curve.getEnd().y + maxY;

            if (CurveType.QUADRATIC_BEZIER == curve.getType()) {
                QuadraticCurve quadratic = (QuadraticCurve) curve;
                quadratic.getControl1().y = y - quadratic.getControl1().y + maxY;

            } else if (CurveType.CUBIC_BEZIER == curve.getType()) {
                CubicCurve cubic = (CubicCurve) curve;

                cubic.getControl1().y = y - cubic.getControl1().y + maxY;
                cubic.getControl2().y = y - cubic.getControl2().y + maxY;
            }
        }
    }

    public Point2D[] calculateBoundingBox() {
        Point2D min = new Point2D(Double.MAX_VALUE, Double.MAX_VALUE);
        Point2D max = new Point2D(Double.MIN_VALUE, Double.MIN_VALUE);

        for (DataCurve curve : curves) {
            min.x = Math.min(min.x, curve.getStart().x);
            min.y = Math.min(min.y, curve.getStart().y);
            min.x = Math.min(min.x, curve.getEnd().x);
            min.y = Math.min(min.y, curve.getEnd().y);

            max.x = Math.max(max.x, curve.getStart().x);
            max.y = Math.max(max.y, curve.getStart().y);
            max.x = Math.max(max.x, curve.getEnd().x);
            max.y = Math.max(max.y, curve.getEnd().y);

            if (CurveType.QUADRATIC_BEZIER == curve.getType()) {
                QuadraticCurve quadratic = (QuadraticCurve) curve;

                min.x = Math.min(min.x, quadratic.getControl1().x);
                min.y = Math.min(min.y, quadratic.getControl1().y);
                max.x = Math.max(max.x, quadratic.getControl1().x);
                max.y = Math.max(max.y, quadratic.getControl1().y);
            } else if (CurveType.CUBIC_BEZIER == curve.getType()) {
                CubicCurve cubic = (CubicCurve) curve;

                min.x = Math.min(min.x, cubic.getControl1().x);
                min.y = Math.min(min.y, cubic.getControl1().y);
                min.x = Math.min(min.x, cubic.getControl2().x);
                min.y = Math.min(min.y, cubic.getControl2().y);

                max.x = Math.max(max.x, cubic.getControl1().x);
                max.y = Math.max(max.y, cubic.getControl1().y);
                max.x = Math.max(max.x, cubic.getControl2().x);
                max.y = Math.max(max.y, cubic.getControl2().y);
            }
        }
        return new Point2D[] { min, max };
    }

}
