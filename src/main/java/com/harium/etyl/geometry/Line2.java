package com.harium.etyl.geometry;

import com.badlogic.gdx.math.Vector2;
import com.harium.etyl.geometry.math.EtylMath;
import com.harium.etyl.geometry.util.MathHelper;

public class Line2 {

    private Vector2 p1;
    private Vector2 p2;

    public Line2(Vector2 p1) {
        super();

        this.p1 = p1;
    }

    public Line2(Vector2 p1, Vector2 p2) {
        super();

        this.p1 = p1;
        this.p2 = p2;
    }

    public Vector2 intersection(Line2 line) {
        return intersection(p1, p2, line.p1, line.p2);
    }

    public static Vector2 intersection(Vector2 p1, Vector2 p2, Vector2 p3, Vector2 p4) {

        float x1 = p1.x;
        float y1 = p1.y;

        float x2 = p2.x;
        float y2 = p2.y;

        float x3 = p3.x;
        float y3 = p3.y;

        float x4 = p4.x;
        float y4 = p4.y;

        float pxN = (x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4);
        float pyN = (x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4);

        float denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        float px = pxN / denominator;
        float py = pyN / denominator;

        return new Vector2(px, py);
    }

    /**
     * Method to generate points between two points
     *
     * @param p1     the first point
     * @param p2     the last point
     * @param points number of points counting with p1 and p2
     * @return array of points
     */
    public static Vector2[] interpolate(Vector2 p1, Vector2 p2, int points) {

        if (points < 2) {
            Vector2[] array = new Vector2[2];

            array[0] = new Vector2(p1);
            array[1] = new Vector2(p2);

            return array;
        }

        Vector2[] array = new Vector2[points];

        array[0] = new Vector2(p1);

        int sections = points - 1;

        array[sections] = new Vector2(p2);

        for (int i = 1; i < sections; i++) {

            float px = p1.x + ((p2.x - p1.x) / sections) * i;
            float py = p1.y + ((p2.y - p1.y) / sections) * i;

            array[i] = new Vector2(px, py);
        }

        return array;
    }

    public double distance(Vector2 q) {
        return distance(p1, p2, q);
    }

    /**
     * Found at: https://en.wikipedia.org/wiki/Distance_from_a_point_to_a_line
     *
     * @param p1 first point of the line
     * @param p2 other point of the line
     * @param q  point to be calculated
     * @return distance between the q and the line p
     */
    public static double distance(Vector2 p1, Vector2 p2, Vector2 q) {
        double x1 = p1.x;
        double y1 = p1.y;
        double x2 = p2.x;
        double y2 = p2.y;

        double num = (y2 - y1) * q.x - (x2 - x1) * q.y + (x2 * y1) - (y2 * x1);
        num = EtylMath.mod(num);
        double distance = num / Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        return distance;
    }

    public Vector2 nearestPoint(Vector2 q) {
        return nearestPoint(p1, p2, q);
    }

    /**
     * Answered at: http://stackoverflow.com/questions/1459368/snap-point-to-a-line-java
     *
     * @param p1 first point of the line
     * @param p2 other point of the line
     * @param q  point to be calculated
     * @return the nearest point
     */
    public static Vector2 nearestPoint(Vector2 p1, Vector2 p2, Vector2 q) {
        boolean clampToSegment = true;
        Vector2 out = new Vector2();

        float apx = q.x - p1.x;
        float apy = q.y - p1.y;
        float abx = p2.x - p1.x;
        float aby = p2.y - p1.y;

        float ab2 = abx * abx + aby * aby;
        float ap_ab = apx * abx + apy * aby;
        float t = ap_ab / ab2;
        if (clampToSegment) {
            if (t < 0) {
                t = 0;
            } else if (t > 1) {
                t = 1;
            }
        }
        out.set(p1.x + abx * t, p1.y + aby * t);
        return out;
    }

    public Vector2 getP1() {
        return p1;
    }

    public void setP1(Vector2 p1) {
        this.p1 = p1;
    }

    public Vector2 getP2() {
        return p2;
    }

    public void setP2(Vector2 p2) {
        this.p2 = p2;
    }

    public double length() {
        return MathHelper.distance(p1, p2);
    }

}
