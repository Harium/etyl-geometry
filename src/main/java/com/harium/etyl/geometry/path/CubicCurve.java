package com.harium.etyl.geometry.path;

import com.harium.etyl.geometry.Point2D;
import com.harium.etyl.geometry.curve.CubicBezier;

public class CubicCurve extends DataCurve {

    public CubicCurve() {
        this(new Point2D(), new Point2D(), new Point2D(), new Point2D());
    }

    public CubicCurve(Point2D start, Point2D end, Point2D control1, Point2D control2) {
        type = CurveType.CUBIC_BEZIER;
        curve = new CubicBezier(start, control1, control2, end);
    }

    public Point2D getStart() {
        return curve.p0;
    }

    public void setStart(Point2D start) {
        curve.p0 = start;
        updateCurve();
    }

    public Point2D getEnd() {
        return ((CubicBezier) curve).p3;
    }

    public void setEnd(Point2D end) {
        ((CubicBezier) curve).p3 = end;
        updateCurve();
    }

    public void setControl1(Point2D control1) {
        curve.p1 = control1;
        updateCurve();
    }

    public Point2D getControl1() {
        return curve.p1;
    }

    public void setControl2(Point2D control2) {
        ((CubicBezier) curve).p2 = control2;
        updateCurve();
    }

    public Point2D getControl2() {
        return ((CubicBezier) curve).p2;
    }

    public DataCurve copy(CubicCurve dataCurve) {
        // Call them directly to not trigger the updateCurve multiple times
        curve.p0.set(dataCurve.getStart());
        curve.p1.set(dataCurve.getControl1());
        ((CubicBezier)curve).p2.set(dataCurve.getControl2());
        ((CubicBezier)curve).p3.set(dataCurve.getEnd());

        updateCurve();

        return this;
    }

}
