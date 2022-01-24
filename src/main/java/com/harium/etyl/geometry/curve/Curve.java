package com.harium.etyl.geometry.curve;

import com.harium.etyl.geometry.Point2D;

/**
 * Represents a flat curve (segment)
 */
public class Curve {

    // Start
    public Point2D p0;
    // End
    public Point2D p1;

    public Curve() {
        p0 = new Point2D(0, 0);
        p1 = new Point2D(0, 0);
    }

    public Curve(Point2D p0, Point2D p1) {
        this.p0 = p0;
        this.p1 = p1;
    }

    /**
     * Approximate the curve to an array of points
     * @param resolution - the number of points to approximate the curve
     * @return the array of points
     */
    public Point2D[] flattenCurve(int resolution) {
        Point2D[] coordinates = new Point2D[resolution];
        double step = 1.0 / (resolution - 1);

        for (int i = 0; i < resolution; i++) {
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

    public void translate(float x, float y) {
        p0.x += x;
        p0.y += y;

        p1.x += x;
        p1.y += y;
    }

    public Point2D[] computeBoundingBox() {
        Point2D min = new Point2D(p0);
        Point2D max = new Point2D(p0);

        min.x = Math.min(min.x, p1.x);
        min.y = Math.min(min.y, p1.y);

        max.x = Math.max(max.x, p1.x);
        max.y = Math.max(max.y, p1.y);

        return new Point2D[] { min, max };
    }

}
