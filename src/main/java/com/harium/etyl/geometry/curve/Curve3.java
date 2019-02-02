package com.harium.etyl.geometry.curve;

import com.badlogic.gdx.math.Vector3;

public class Curve3 {

    // Start / End
    protected Vector3 p0, p1;

    public Vector3[] flattenCurve(int segmentCount) {
        Vector3[] coordinates = new Vector3[segmentCount + 1];
        float step = 1 / (float) segmentCount;

        coordinates[0] = new Vector3(p0);
        for (int i = 1; i <= segmentCount; i++) {
            float t = i * step;
            coordinates[i] = new Vector3(x(t), y(t), z(t));
        }
        return coordinates;
    }

    public float x(float t) {
        return p0.x;
    }

    public float y(float t) {
        return p0.y;
    }

    public float z(float t) {
        return p0.z;
    }

    public Vector3 getP0() {
        return p0;
    }

    public Vector3 getP1() {
        return p1;
    }

}
