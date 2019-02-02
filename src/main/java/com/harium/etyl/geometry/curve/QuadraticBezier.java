package com.harium.etyl.geometry.curve;

import com.badlogic.gdx.math.Vector2;

/**
 * Code based on: https://pomax.github.io/bezierinfo/
 */
public class QuadraticBezier extends Curve {

    protected Vector2 p2;

    public QuadraticBezier(Vector2 p0, Vector2 p1, Vector2 p2) {
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

    public static float interpolate(float t, float p0, float p1, float p2) {
        float t2 = t * t;
        float mt = 1 - t;
        float mt2 = mt * mt;
        return p0 * mt2 + p1 * 2 * mt * t + p2 * t2;
    }

    public Vector2 getP2() {
        return p2;
    }
}
