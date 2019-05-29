package com.harium.etyl.geometry.path;

import com.harium.etyl.geometry.Point2D;
import com.harium.etyl.geometry.curve.CubicBezier;

public class CubicCurve extends QuadraticCurve {

    protected Point2D control2;

    public CubicCurve(Point2D start, Point2D end, Point2D control1, Point2D control2) {
        super(start, end, control1);
        type = CurveType.CUBIC_BEZIER;
        this.control2 = control2;

        curve = new CubicBezier(start, control1, control2, end);
    }

    public void setEnd(Point2D end) {
        this.end = end;
        ((CubicBezier) curve).p3 = end;
        updateCurve();
    }

    public void setControl2(Point2D control2) {
        this.control2 = control2;
        ((CubicBezier) curve).p2 = control2;
        updateCurve();
    }

    public Point2D getControl2() {
        return control2;
    }
}
