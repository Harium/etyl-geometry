package com.harium.etyl.geometry.path;

import com.harium.etyl.geometry.Point2D;
import com.harium.etyl.geometry.curve.QuadraticBezier;

public class QuadraticCurve extends DataCurve {

    public QuadraticCurve() {
        this(new Point2D(), new Point2D(), new Point2D());
    }

    public QuadraticCurve(Point2D start, Point2D end, Point2D control1) {
        type = CurveType.QUADRATIC_BEZIER;
        curve = new QuadraticBezier(start, control1, end);
    }

    public Point2D getStart() {
        return curve.p0;
    }

    public void setStart(Point2D start) {
        curve.p0 = start;
        updateCurve();
    }

    public Point2D getEnd() {
        return ((QuadraticBezier) curve).p2;
    }

    public void setEnd(Point2D end) {
        ((QuadraticBezier) curve).p2 = end;
        updateCurve();
    }

    public void setControl1(Point2D control1) {
        curve.p1 = control1;
        updateCurve();
    }

    public Point2D getControl1() {
        return curve.p1;
    }

    public DataCurve copy(QuadraticCurve dataCurve) {
        // Call them directly to not trigger the updateCurve multiple times
        curve.p0.set(dataCurve.getStart());
        curve.p1.set(dataCurve.getControl1());
        ((QuadraticBezier) curve).p2.set(dataCurve.getEnd());

        updateCurve();

        return this;
    }
}
