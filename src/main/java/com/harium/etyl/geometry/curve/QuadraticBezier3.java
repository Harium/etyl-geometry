package com.harium.etyl.geometry.curve;

import com.harium.etyl.geometry.Point3D;

public class QuadraticBezier3 extends Curve3 {

    protected Point3D p2;

    public QuadraticBezier3(Point3D p0, Point3D p1, Point3D p2) {
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
    }

    public double x(double t) {
        return QuadraticBezier.interpolate(t, p0.x, p1.x, p2.x);
    }

    public double y(double t) {
        return QuadraticBezier.interpolate(t, p0.y, p1.y, p2.y);
    }

    public double z(double t) {
        return QuadraticBezier.interpolate(t, p0.z, p1.z, p2.z);
    }

    public Point3D getP2() {
        return p2;
    }

    public void translate(float x, float y, float z) {
        super.translate(x, y, z);

        p2.x += x;
        p2.y += y;
        p2.z += z;
    }

}
