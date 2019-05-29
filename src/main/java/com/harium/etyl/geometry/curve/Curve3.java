package com.harium.etyl.geometry.curve;

import com.harium.etyl.geometry.Point3D;

public class Curve3 {

    // Start / End
    protected Point3D p0, p1;

    public Point3D[] flattenCurve(int segmentCount) {
        Point3D[] coordinates = new Point3D[segmentCount + 1];
        double step = 1 / (double) segmentCount;

        coordinates[0] = new Point3D(p0);
        for (int i = 1; i <= segmentCount; i++) {
            double t = i * step;
            coordinates[i] = new Point3D(x(t), y(t), z(t));
        }
        return coordinates;
    }

    public double x(double t) {
        return p0.x;
    }

    public double y(double t) {
        return p0.y;
    }

    public double z(double t) {
        return p0.z;
    }

    public Point3D getP0() {
        return p0;
    }

    public Point3D getP1() {
        return p1;
    }

}
