package com.harium.etyl.geometry;

import com.badlogic.gdx.math.Vector2;
import com.harium.etyl.geometry.util.MathHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Polygon
 * Forked from: http://algs4.cs.princeton.edu/91primitives/Polygon.java.html
 */
public class Polygon {

    private boolean isClosed = true;
    private List<Vector2> list = new ArrayList<>();

    public Polygon() {
        super();
        reset();
    }

    public void reset() {
        list.clear();
    }

    /**
     * @return the number of points
     */
    public int size() {
        return list.size();
    }

    /**
     * Add the point p to the end of the polygon
     *
     * @param x
     * @param y
     */
    public void add(float x, float y) {
        add(new Vector2(x, y));
    }

    /**
     * Add the point p to the end of the polygon
     *
     * @param p Vector2
     */
    public void add(Vector2 p) {
        list.add(p);
    }

    /**
     * Method to calculate the perimeter
     *
     * @return the perimeter of polygon
     */
    public double perimeter() {
        double sum = 0.0;

        Vector2 current = list.get(0);

        for (int i = 0; i < list.size() - 1; i++) {
            Vector2 next = list.get(i + 1);
            sum += MathHelper.distance(current.x, current.y, next.x, next.y);
            current = next;
        }

        Vector2 next = list.get(0);
        sum += MathHelper.distance(current.x, current.y, next.x, next.y);

        return sum;
    }

    /**
     * Method to calculate the area
     *
     * @return the signed area of polygon
     */
    public double area() {
        double sum = 0.0;
        for (int i = 0; i < list.size() - 1; i++) {
            Vector2 p = list.get(i);
            Vector2 q = list.get(i + 1);

            sum = sum + (p.x * q.y) - (p.y * q.x);
        }
        return 0.5 * sum;
    }

    /**
     * Check if the polygon contains the point p
     * if p is on boundary then 0 or 1 is returned, and p is in exactly one point of every partition of plane
     * Reference: http://exaflop.org/docs/cgafaq/cga2.html
     *
     * @param p
     * @return if polygon contains the point
     */
    public boolean contains2(Point2D p) {
        int crossings = 0;
        for (int i = 0; i < list.size(); i++) {
            Vector2 q = list.get(i);
            Vector2 r = list.get(i + 1);

            boolean cond1 = (q.y <= p.y) && (p.y < r.y);
            boolean cond2 = (r.y <= p.y) && (p.y < q.y);
            if (cond1 || cond2) {
                // need to cast to double
                if (p.x < (r.x - q.x) * (p.y - q.y) / (r.y - q.y) + q.x) {
                    crossings++;
                }
            }
        }
        if (crossings % 2 == 1) return true;
        else return false;
    }

    public boolean contains(float x, float y) {
        return contains(new Vector2(x, y));
    }

    /**
     * Check if the polygon contains the point p
     * Reference: http://softsurfer.com/Archive/algorithm_0103/algorithm_0103.htm
     *
     * @param p
     * @return if polygon contains the point
     */
    public boolean contains(Vector2 p) {
        int winding = 0;
        for (int i = 0; i < list.size(); i++) {
            Vector2 q = list.get(i);
            Vector2 r = list.get(i + 1);

            int ccw = ccw(q, r, p);
            if (r.y > p.y && p.y >= q.y)  // upward crossing
                if (ccw == +1) winding++;
            if (r.y <= p.y && p.y < q.y)  // downward crossing
                if (ccw == -1) winding--;
        }
        return winding != 0;
    }

    /**
     * Check if a->b->c is a counter-clockwise turn
     *
     * @param a
     * @param b
     * @param c
     * @return +1 if counter-clockwise, -1 if clockwise, 0 if collinear
     */
    private static int ccw(Vector2 a, Vector2 b, Vector2 c) {
        double area2 = (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y);
        if (area2 < 0) return -1;
        else if (area2 > 0) return +1;
        else return 0;
    }

    /**
     * Generates a mutable list with copies of points
     *
     * @return a copy of the points as a list
     */
    public List<Vector2> asList() {
        List<Vector2> list = new ArrayList<>(this.list);
        return list;
    }

    public List<Vector2> getList() {
        return list;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        for (int i = 0; i <= list.size(); i++) {
            builder.append(list.get(i));
            if (i < list.size() - 1) {
                builder.append(" ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
