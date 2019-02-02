package com.harium.etyl.geometry.curve;

import com.badlogic.gdx.math.Vector3;

public class CubicBezier3 extends Curve3 {

    protected Vector3 p2, p3;

    public CubicBezier3(Vector3 p0, Vector3 p1, Vector3 p2, Vector3 p3) {
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public float x(float t) {
        return CubicBezier.interpolate(t, p0.x, p1.x, p2.x, p3.x);
    }

    public float y(float t) {
        return CubicBezier.interpolate(t, p0.y, p1.y, p2.y, p3.y);
    }

    public float z(float t) {
        return CubicBezier.interpolate(t, p0.z, p1.z, p2.z, p3.z);
    }

    public Vector3 getP2() {
        return p2;
    }

    public Vector3 getP3() {
        return p3;
    }
}
