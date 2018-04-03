package com.harium.etyl.geometry;

import com.badlogic.gdx.math.Vector2;
import org.junit.Assert;
import org.junit.Test;

public class CircleTest {

    private static final float EPSILON = 0.01f;

    @Test
    public void testInit() {
        Circle circle = new Circle(new Vector2(1,2), 3);

        Assert.assertEquals(1, circle.getCenter().x, EPSILON);
        Assert.assertEquals(2, circle.getCenter().y, EPSILON);
        Assert.assertEquals(3, circle.getRadius(), EPSILON);
    }

    @Test
    public void testArea() {
        Circle circle = new Circle(new Vector2(1,2), 3);

        Assert.assertEquals(28.274, circle.area(), EPSILON);
    }

    @Test
    public void testCircunference() {
        Circle circle = new Circle(new Vector2(1,2), 3);

        Assert.assertEquals(18.849, circle.circunference(), EPSILON);
    }

}
