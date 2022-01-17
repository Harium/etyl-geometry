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

    public void translate(float x, float y) {
        super.translate(x, y);

        p2.x += x;
        p2.y += y;
    }

    public Point2D[] computeBoundingBox() {
        Point2D min = new Point2D(p0);
        Point2D max = new Point2D(p0);

        min.x = Math.min(min.x, p1.x);
        min.y = Math.min(min.y, p1.y);
        min.x = Math.min(min.x, p2.x);
        min.y = Math.min(min.y, p2.y);

        max.x = Math.max(max.x, p1.x);
        max.y = Math.max(max.y, p1.y);
        max.x = Math.max(max.x, p2.x);
        max.y = Math.max(max.y, p2.y);

        return new Point2D[] { min, max };
    }
}
