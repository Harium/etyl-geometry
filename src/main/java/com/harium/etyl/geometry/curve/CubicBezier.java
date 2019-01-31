package com.harium.etyl.geometry.curve;

import com.badlogic.gdx.math.Vector2;

/**
 * Code based on: https://pomax.github.io/bezierinfo/
 *
 * To get a smooth seemless join, the shared control point and the two internal control points either side in each
 * patch of adjoining surfaces should be colinear.
 * Reference: http://euklid.mi.uni-koeln.de/c/mirror/www.cs.curtin.edu.au/units/cg351-551/notes/lect6c1.html
 */
public class CubicBezier extends Curve {

    protected Vector2 p2, p3;

    public CubicBezier(Vector2 p0, Vector2 p1, Vector2 p2, Vector2 p3) {
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

    public static float interpolate(float t, float p0, float p1, float p2, float p3) {
        float t2 = t * t;
        float mt = 1 - t;
        float mt2 = mt * mt;
        float t3 = t2 * t;
        float mt3 = mt2 * mt;

        return p0 * mt3 + 3 * p1 * mt2 * t + 3 * p2 * mt * t2 + p3 * t3;
    }

    public Vector2 getP2() {
        return p2;
    }

    public Vector2 getP3() {
        return p3;
    }
}
