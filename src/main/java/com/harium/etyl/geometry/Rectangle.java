package com.harium.etyl.geometry;

import com.badlogic.gdx.math.Vector2;

/**
 * @author yuripourre
 */

public class Rectangle {
    private Vector2 position;
    private Vector2 dimension;

    public Rectangle(float x, float y, float w, float h) {
        position = new Vector2(x, y);
        dimension = new Vector2(w, h);
    }

    public boolean collide(Rectangle rect) {
        if (rect.getX() + rect.getW() < getX()) return false;
        if (rect.getX() > getX() + getW()) return false;

        if (rect.getY() + rect.getH() < getY()) return false;
        if (rect.getY() > getY() + getH()) return false;

        return true;
    }

    public float getW() {
        return dimension.x;
    }

    public void setW(float w) {
        dimension.x = w;
    }

    public float getH() {
        return dimension.y;
    }

    public void setH(float h) {
        dimension.y = h;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public void set(float x, float y, float w, float h) {
        position.set(x, y);
        dimension.set(w, h);
    }
}
