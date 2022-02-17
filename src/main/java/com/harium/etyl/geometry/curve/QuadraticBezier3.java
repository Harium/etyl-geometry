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

    public void translate(double x, double y, double z) {
        super.translate(x, y, z);

        p2.x += x;
        p2.y += y;
        p2.z += z;
    }

    public Point3D[] computeBoundingBox() {
        Point3D min = new Point3D(p0);
        Point3D max = new Point3D(p0);

        min.x = Math.min(min.x, p1.x);
        min.y = Math.min(min.y, p1.y);
        min.z = Math.min(min.z, p1.z);
        min.x = Math.min(min.x, p2.x);
        min.y = Math.min(min.y, p2.y);
        min.z = Math.min(min.z, p2.z);

        max.x = Math.max(max.x, p1.x);
        max.y = Math.max(max.y, p1.y);
        max.z = Math.max(max.z, p1.z);
        max.x = Math.max(max.x, p2.x);
        max.y = Math.max(max.y, p2.y);
        max.z = Math.max(max.z, p2.z);

        return new Point3D[] { min, max };
    }
}
