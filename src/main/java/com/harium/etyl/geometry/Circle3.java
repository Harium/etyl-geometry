package com.harium.etyl.geometry;


import com.badlogic.gdx.math.Vector3;

public class Circle3 {

    private Vector3 center;
    private float radius;

    /**
     * Constructs a new Circle.
     *
     * @param centerX x center of the circle.
     * @param centerY y center of the circle.
     * @param radius  Radius of the circle.
     */
    public Circle3(float centerX, float centerY, float centerZ, float radius) {
        this.center = new Vector3(centerX, centerY, centerZ);
        this.radius = radius;
    }

    /**
     * Constructs a new Circle.
     *
     * @param center Center of the circle.
     * @param radius Radius of the circle.
     */
    public Circle3(Vector3 center, float radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * Creates a new Circle with same properties of <code>circle</code>.
     *
     * @param circle Circle to clone.
     */
    public Circle3(Circle3 circle) {
        this.center = circle.center;
        this.radius = circle.radius;
    }

    /**
     * Gets the center of the circle.
     *
     * @return the center of the circle.
     */
    public Vector3 getCenter() {
        return center;
    }

    public void setCenter(Vector3 center) {
        this.center = center;
    }

    /**
     * Gets the radius of the circle.
     *
     * @return the radius of the circle.
     */
    public double getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float area() {
        return (float) (Math.PI * radius * radius);
    }

    public float circunference() {
        return (float) (2 * Math.PI * radius);
    }

    public boolean contains(Vector3 p) {
        return radius > center.dst(p);
    }

    public String toString() {
        return (new String(" Circle[c:" + center.toString() + "| r:" + radius + "]"));
    }
}
