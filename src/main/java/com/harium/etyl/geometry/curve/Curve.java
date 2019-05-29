package com.harium.etyl.geometry.curve;

import com.harium.etyl.geometry.Point2D;

/**
 * Represents a flat curve (segment)
 */
public class Curve {

    // Start / End
    public Point2D p0;
    public Point2D p1;

    public Curve() {
        p0 = new Point2D(0, 0);
        p1 = new Point2D(0, 0);
    }

    public Curve(Point2D p0, Point2D p1) {
        this.p0 = p0;
        this.p1 = p1;
    }

    public Point2D[] flattenCurve(int segmentCount) {
        Point2D[] coordinates = new Point2D[segmentCount + 1];
        double step = 1 / (double) segmentCount;

        coordinates[0] = new Point2D(p0);
        for (int i = 1; i <= segmentCount; i++) {
            double t = i * step;
            coordinates[i] = new Point2D(x(t), y(t));
        }
        return coordinates;
    }

    public double x(double t) {
        return p0.x * (1 - t) + (p1.x * t);
    }

    public double y(double t) {
        return p0.y * (1 - t) + (p1.y * t);
    }

    public Point2D getP0() {
        return p0;
    }

    public Point2D getP1() {
        return p1;
    }

}
