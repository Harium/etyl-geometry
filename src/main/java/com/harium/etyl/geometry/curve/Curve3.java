package com.harium.etyl.geometry.curve;

import com.harium.etyl.geometry.Point2D;
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

    public void translate(double x, double y, double z) {
        p0.x += x;
        p0.y += y;
        p0.z += z;

        p1.x += x;
        p1.y += y;
        p1.z += z;
    }

    public Point3D[] computeBoundingBox() {
        Point3D min = new Point3D(p0);
        Point3D max = new Point3D(p0);

        min.x = Math.min(min.x, p1.x);
        min.y = Math.min(min.y, p1.y);
        min.z = Math.min(min.z, p1.z);

        max.x = Math.max(max.x, p1.x);
        max.y = Math.max(max.y, p1.y);
        max.z = Math.max(max.z, p1.z);

        return new Point3D[] { min, max };
    }
}
