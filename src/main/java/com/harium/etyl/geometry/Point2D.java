package com.harium.etyl.geometry;

/**
 * @author yuripourre
 */
public class Point2D {

    public double x;
    public double y;

    public Point2D() {
        super();
        set(0, 0);
    }

    public Point2D(double x, double y) {
        super();
        set(x, y);
    }

    public Point2D(Point2D point) {
        super();
        set(point.x, point.y);
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void set(Point2D point) {
        set(point.x, point.y);
    }

    public Point2D translate(double x, double y) {
        translateX(x);
        translateY(y);

        return this;
    }

    public void translateX(double x) {
        this.x += x;
    }

    public void translateY(double y) {
        this.y += y;
    }

    public Point2D scale(double factor) {
        return scale(factor, factor);
    }

    public Point2D scale(double x, double y) {
        scaleX(x);
        scaleY(y);
        return this;
    }

    public Point2D scaleX(double factor) {
        this.x *= factor;
        return this;
    }

    public Point2D scaleY(double factor) {
        this.y *= factor;
        return this;
    }

    public double angle(Point2D point) {
        return angle(point.x, point.y);
    }

    public double angle(double px, double py) {
        return angleXY(px, py);
    }

    public double angleXY(double px, double py) {

        double deltaX = px - x;
        double deltaY = py - y;

        double angleInDegrees = Math.atan2(deltaY, deltaX) * 180 / Math.PI;

        return angleInDegrees;
    }

    public static double angle(double px, double py, double qx, double qy) {

        double deltaX = qx - px;
        double deltaY = qy - py;

        double angleInDegrees = Math.atan2(deltaY, deltaX) * 180 / Math.PI;

        return angleInDegrees;
    }

    public Point2D rotate(double cx, double cy, double degreeAngle) {
        double angle = Math.toRadians(degreeAngle);
        double nx = cx + (x - cx) * Math.cos(angle) - (y - cy) * Math.sin(angle);
        double ny = cy + (x - cx) * Math.sin(angle) + (y - cy) * Math.cos(angle);

        x = nx;
        y = ny;
        return this;
    }

    public Point2D rotate(Point2D p, double degreeAngle) {
        return rotate(p.x, p.y, degreeAngle);
    }

    public double distance(Point2D point) {
        return distance(point.x, point.y);
    }

    public double distance(double px, double py) {
        return distance(px, py, this.x, this.y);
    }

    public static double distance(double px, double py, double qx, double qy) {
        double dist = Math.sqrt(distanceSq(px, py, qx, qy));
        return dist;
    }

    public double distanceSq(Point2D point) {
        return distanceSq(point.x, point.y);
    }

    public double distanceSq(double px, double py) {
        return distanceSq(px, py, this.x, this.y);
    }

    public static double distanceSq(double px, double py, double qx, double qy) {
        double difX = px - qx;
        double difY = py - qy;

        return difX * difX + difY * difY;
    }

    public Point2D distantPoint(Point2D b, double distance) {

        double deltaX = x - b.x;
        double deltaY = y - b.y;

        double dist = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        deltaX /= dist;
        deltaY /= dist;

        Point2D c = new Point2D(x - distance * deltaX, y - distance * deltaY);

        return c;
    }

    /**
     * Check if a to b to c is a counter-clockwise turn
     *
     * @param a point
     * @param b point
     * @param c point
     * @return +1 if counter-clockwise, -1 if clockwise, 0 if collinear
     */
    public static int ccw(Point2D a, Point2D b, Point2D c) {
        double area2 = (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y);
        if (area2 < 0) return -1;
        else if (area2 > 0) return +1;
        else return 0;
    }

    /**
     * Check if a, b and c are collinear
     *
     * @param a point
     * @param b point
     * @param c point
     * @return they are collinear
     */
    public static boolean collinear(Point2D a, Point2D b, Point2D c) {
        return ccw(a, b, c) == 0;
    }

    /**
     * Check if c is between a and b?
     * Reference: O' Rourke p. 32
     *
     * @param a point
     * @param b point
     * @param c point
     * @return c is between a and b
     */
    public static boolean between(Point2D a, Point2D b, Point2D c) {
        if (ccw(a, b, c) != 0) return false;
        if (a.x == b.x && a.y == b.y) {
            return a.x == c.x && a.y == c.y;
        } else if (a.x != b.x) {
            // ab not vertical
            return (a.x <= c.x && c.x <= b.x) || (a.x >= c.x && c.x >= b.x);
        } else {
            // ab not horizontal
            return (a.y <= c.y && c.y <= b.y) || (a.y >= c.y && c.y >= b.y);
        }
    }

    public static Point2D clone(Point2D point) {
        return new Point2D(point.x, point.y);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point2D other = (Point2D) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
            return false;
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
            return false;
        return true;
    }

}
