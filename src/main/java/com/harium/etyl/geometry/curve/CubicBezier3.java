package com.harium.etyl.geometry.curve;

import com.harium.etyl.geometry.Point3D;

public class CubicBezier3 extends Curve3 {

    protected Point3D p2, p3;

    public CubicBezier3(Point3D p0, Point3D p1, Point3D p2, Point3D p3) {
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public double x(double t) {
        return CubicBezier.interpolate(t, p0.x, p1.x, p2.x, p3.x);
    }

    public double y(double t) {
        return CubicBezier.interpolate(t, p0.y, p1.y, p2.y, p3.y);
    }

    public double z(double t) {
        return CubicBezier.interpolate(t, p0.z, p1.z, p2.z, p3.z);
    }

    public Point3D getP2() {
        return p2;
    }

    public Point3D getP3() {
        return p3;
    }
}
