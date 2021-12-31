package com.harium.etyl.geometry;

import com.badlogic.gdx.math.Vector2;
import com.harium.etyl.geometry.collision.CollisionDetector;
import com.harium.etyl.geometry.math.EtylMath;

public class Ellipse {

    protected Vector2 center;

    protected int w = 1;
    protected int h = 1;

    protected double angle = 0;

    public Ellipse(int x, int y) {
        super();
        this.center = new Vector2(x, y);
    }

    public Ellipse(int x, int y, int w, int h) {
        this(x, y);
        this.w = w;
        this.h = h;
    }

    public Ellipse(int x, int y, int w, int h, double angle) {
        this(x, y, w, h);
        this.angle = angle;
    }

    public Vector2 getCenter() {
        return center;
    }

    public void setCenter(Vector2 center) {
        this.center = center;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public boolean contains(double px, double py) {
        final double a = Math.toRadians(angle);

        final double cos = Math.cos(a);
        final double sin = Math.sin(a);

        double p = EtylMath.sqr(cos * (px - center.x) + sin * (py - center.y)) / (w * w);
        double q = EtylMath.sqr(sin * (px - center.x) - cos * (py - center.y)) / (h * h);

        return (p + q <= 1);
    }

    public boolean collidePoint(double px, double py) {
        return CollisionDetector.collideEllipsePoint(center.x, center.y, angle, w, h, px, py);
    }

}
