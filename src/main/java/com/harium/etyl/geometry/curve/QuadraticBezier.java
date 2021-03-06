package com.harium.etyl.geometry.curve;

import com.harium.etyl.geometry.Point2D;

/**
 * Code based on: https://pomax.github.io/bezierinfo/
 */
public class QuadraticBezier extends Curve {

    public Point2D p2;

    public QuadraticBezier(Point2D p0, Point2D p1, Point2D p2) {
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

    public static double interpolate(double t, double p0, double p1, double p2) {
        double t2 = t * t;
        double mt = 1 - t;
        double mt2 = mt * mt;
        return p0 * mt2 + p1 * 2 * mt * t + p2 * t2;
    }

    public Point2D getP2() {
        return p2;
    }
}
