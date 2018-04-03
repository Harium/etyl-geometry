package com.harium.etyl.geometry;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {

    private static final float EPSILON = 0.01f;

    @Test
    public void testInit() {
        Rectangle rectangle = new Rectangle(1, 2, 3, 4);
        Assert.assertEquals(1, rectangle.getX(), EPSILON);
        Assert.assertEquals(2, rectangle.getY(), EPSILON);
        Assert.assertEquals(3, rectangle.getW(), EPSILON);
        Assert.assertEquals(4, rectangle.getH(), EPSILON);
    }

    @Test
    public void testCollide() {
        Rectangle a = new Rectangle(0, 0, 100, 20);
        Rectangle b = new Rectangle(90, 0, 100, 20);

        Assert.assertTrue(a.collide(b));

        b.set(a.getX() + a.getW() + 1, 0, 100, 20);
        Assert.assertFalse(a.collide(b));
    }

}
