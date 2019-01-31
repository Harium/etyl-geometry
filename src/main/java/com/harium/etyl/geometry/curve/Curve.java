package com.harium.etyl.geometry.curve;

import com.badlogic.gdx.math.Vector2;

/**
 * Represents a flat curve (segment)
 */
public class Curve {

    // Start / End
    protected Vector2 p0, p1;

    public Curve() {
        p0 = new Vector2(0, 0);
        p1 = new Vector2(0, 0);
    }

    public Curve(Vector2 p0, Vector2 p1) {
        this.p0 = p0;
        this.p1 = p1;
    }

    public Vector2[] flattenCurve(int segmentCount) {
        Vector2[] coordinates = new Vector2[segmentCount + 1];
        float step = 1 / (float) segmentCount;

        coordinates[0] = new Vector2(p0);
        for (int i = 1; i <= segmentCount; i++) {
            float t = i * step;
            coordinates[i] = new Vector2(x(t), y(t));
        }
        return coordinates;
    }

    public float x(float t) {
        return p0.x * (1 - t) + (p1.x * t);
    }

    public float y(float t) {
        return p0.y * (1 - t) + (p1.y * t);
    }

    public Vector2 getP0() {
        return p0;
    }

    public Vector2 getP1() {
        return p1;
    }

}
