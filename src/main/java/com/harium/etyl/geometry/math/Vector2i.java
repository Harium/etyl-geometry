package com.harium.etyl.geometry.math;

public class Vector2i {

    public int x = 0;
    public int y = 0;

    public Vector2i() {}

    public Vector2i(int x, int y) {
        this.set(x, y);
    }

    public Vector2i(Vector2i v) {
        this.set(v);
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set(Vector2i v) {
        this.set(v.x, v.y);
    }

    public Vector2i cpy() {
        return new Vector2i(this);
    }

    public static float len(float x, float y) {
        return (float)Math.sqrt((double)(x * x + y * y));
    }

    public float len() {
        return (float)Math.sqrt((double)(this.x * this.x + this.y * this.y));
    }

    public static float len2(float x, float y) {
        return x * x + y * y;
    }

    public float len2() {
        return this.x * this.x + this.y * this.y;
    }

    public Vector2i sub(Vector2i v) {
        this.x -= v.x;
        this.y -= v.y;
        return this;
    }

    public Vector2i sub(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vector2i nor() {
        float len = this.len();
        if (len != 0.0F) {
            this.x /= len;
            this.y /= len;
        }

        return this;
    }

    public Vector2i add(Vector2i v) {
        this.x += v.x;
        this.y += v.y;
        return this;
    }

    public Vector2i add(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public double angle(double px, double py) {
        double deltaX = px - x;
        double deltaY = py - y;

        double angleInDegrees = Math.atan2(deltaY, deltaX) * 180 / Math.PI;
        return angleInDegrees;
    }

    public void rotate(double cx, double cy, double degreeAngle) {
        double angle = Math.toRadians(degreeAngle);
        double nx = cx + (x - cx) * Math.cos(angle) - (y - cy) * Math.sin(angle);
        double ny = cy + (x - cx) * Math.sin(angle) + (y - cy) * Math.cos(angle);

        x = (int) nx;
        y = (int) ny;
    }

    public double distance(Vector2i vector) {
        return distance(this.x, this.y, vector.x, vector.y);
    }

    public double distance(double px, double py) {
        return distance(px, py, this.x, this.y);
    }

    public static double distance(double px, double py, double qx, double qy) {
        double difX = px - qx;
        double difY = py - qy;

        double dist = Math.sqrt(Math.pow(difX, 2) + Math.pow(difY, 2));

        return dist;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
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
        Vector2i other = (Vector2i) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}
