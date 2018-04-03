package com.harium.etyl.geometry;


import com.badlogic.gdx.math.Vector2;

public class Circle {

    private Vector2 center;
    private float radius;

    /**
     * Constructs a new Circle.
     *
     * @param centerX x center of the circle.
     * @param centerY y center of the circle.
     * @param radius  Radius of the circle.
     */
    public Circle(float centerX, float centerY, float radius) {
        this.center = new Vector2(centerX, centerY);
        this.radius = radius;
    }

    /**
     * Constructs a new Circle.
     *
     * @param center Center of the circle.
     * @param radius Radius of the circle.
     */
    public Circle(Vector2 center, float radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * Creates a new Circle with same properties of <code>circle</code>.
     *
     * @param circle Circle to clone.
     */
    public Circle(Circle circle) {
        this.center = circle.center;
        this.radius = circle.radius;
    }

    public String toString() {
        return (new String(" Circle[" + center.toString() + "|" + radius + "|" + (int) Math.round(Math.sqrt(radius)) + "]"));
    }

    /**
     * Gets the center of the circle.
     *
     * @return the center of the circle.
     */
    public Vector2 getCenter() {
        return center;
    }

    /**
     * Gets the radius of the circle.
     *
     * @return the radius of the circle.
     */
    public double getRadius() {
        return radius;
    }

    public float area() {
        return (float) (Math.PI * radius * radius);
    }

    public float circunference() {
        return (float) (2 * Math.PI * radius);
    }
}
