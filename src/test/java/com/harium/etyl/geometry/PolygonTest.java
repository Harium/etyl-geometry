package com.harium.etyl.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PolygonTest {

    private static final float EPSILON = 0.01f;

    @Test
    public void testAdd() {
        Polygon polygon = new Polygon();
        Assert.assertEquals(0, polygon.size());

        polygon.add(0, 0);
        Assert.assertEquals(1, polygon.size());
    }

    @Test
    public void testPerimeter() {
        Polygon polygon = new Polygon();
        polygon.add(0, 0);
        polygon.add(10, 0);
        polygon.add(10, 10);
        polygon.add(0, 10);

        Assert.assertEquals(40, polygon.perimeter(), EPSILON);
    }

    @Test
    public void testArea() {
        Polygon polygon = new Polygon();
        polygon.add(0, 0);
        polygon.add(10, 0);
        polygon.add(10, 10);
        polygon.add(0, 10);

        Assert.assertEquals(100, polygon.area(), EPSILON);
    }

}
