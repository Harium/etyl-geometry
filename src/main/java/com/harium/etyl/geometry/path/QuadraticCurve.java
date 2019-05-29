package com.harium.etyl.geometry.path;

import com.harium.etyl.geometry.Point2D;
import com.harium.etyl.geometry.curve.QuadraticBezier;

public class QuadraticCurve extends DataCurve {

    protected Point2D control1;

    public QuadraticCurve(Point2D start, Point2D end, Point2D control1) {
        type = CurveType.QUADRATIC_BEZIER;

        this.start = start;
        this.end = end;
        this.control1 = control1;

        curve = new QuadraticBezier(start, control1, end);
    }

    public void setEnd(Point2D end) {
        this.end = end;
        ((QuadraticBezier) curve).p2 = end;
        updateCurve();
    }

    public void setControl1(Point2D control1) {
        this.control1 = control1;
        ((QuadraticBezier) curve).p1 = control1;
        updateCurve();
    }

    public Point2D getControl1() {
        return control1;
    }
}
