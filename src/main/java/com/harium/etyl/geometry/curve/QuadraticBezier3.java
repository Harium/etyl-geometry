package com.harium.etyl.geometry.curve;

import com.badlogic.gdx.math.Vector3;

public class QuadraticBezier3 extends Curve3 {

    protected Vector3 p2;

    public QuadraticBezier3(Vector3 p0, Vector3 p1, Vector3 p2) {
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
    }

    public float x(float t) {
        return QuadraticBezier.interpolate(t, p0.x, p1.x, p2.x);
    }

    public float y(float t) {
        return QuadraticBezier.interpolate(t, p0.y, p1.y, p2.y);
    }

    public float z(float t) {
        return QuadraticBezier.interpolate(t, p0.z, p1.z, p2.z);
    }

    public Vector3 getP2() {
        return p2;
    }
}
