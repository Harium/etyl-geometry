package com.harium.etyl.geometry.curve;

import com.harium.etyl.geometry.Point2D;

/**
 * Code based on: https://pomax.github.io/bezierinfo/
 * <p>
 * To get a smooth seamless join, the shared control point and the two internal control points either side in each
 * patch of adjoining surfaces should be collinear.
 * Reference: http://euklid.mi.uni-koeln.de/c/mirror/www.cs.curtin.edu.au/units/cg351-551/notes/lect6c1.html
 */
public class CubicBezier extends Curve {

    public Point2D p2;
    public Point2D p3;

    public CubicBezier(Point2D a, Point2D cp1, Point2D cp2, Point2D b) {
        this.p0 = a;
        this.p1 = cp1;
        this.p2 = cp2;
        this.p3 = b;
    }

    public double x(double t) {
        return CubicBezier.interpolate(t, p0.x, p1.x, p2.x, p3.x);
    }

    public double y(double t) {
        return CubicBezier.interpolate(t, p0.y, p1.y, p2.y, p3.y);
    }

    public static double interpolate(double t, double p0, double p1, double p2, double p3) {
        double t2 = t * t;  // t^2
        double t3 = t2 * t; // t^3
        double mt = 1 - t;  // 1 minus t
        double mt2 = mt * mt;
        double mt3 = mt2 * mt;

        return p0 * mt3 + 3 * p1 * mt2 * t + 3 * p2 * mt * t2 + p3 * t3;
    }

    public Point2D getP2() {
        return p2;
    }

    public Point2D getP3() {
        return p3;
    }

    public void translate(float x, float y) {
        super.translate(x, y);

        p2.x += x;
        p2.y += y;

        p3.x += x;
        p3.y += y;
    }

    public Point2D[] computeBoundingBox() {
        Point2D min = new Point2D(p0);
        Point2D max = new Point2D(p0);

        min.x = Math.min(min.x, p1.x);
        min.y = Math.min(min.y, p1.y);
        min.x = Math.min(min.x, p2.x);
        min.y = Math.min(min.y, p2.y);
        min.x = Math.min(min.x, p3.x);
        min.y = Math.min(min.y, p3.y);

        max.x = Math.max(max.x, p1.x);
        max.y = Math.max(max.y, p1.y);
        max.x = Math.max(max.x, p2.x);
        max.y = Math.max(max.y, p2.y);
        max.x = Math.max(max.x, p3.x);
        max.y = Math.max(max.y, p3.y);

        return new Point2D[] { min, max };
    }

}
