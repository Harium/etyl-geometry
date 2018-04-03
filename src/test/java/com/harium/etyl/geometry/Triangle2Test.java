package com.harium.etyl.geometry;

import com.badlogic.gdx.math.Vector2;
import org.junit.Assert;
import org.junit.Test;

public class Triangle2Test {

    @Test
    public void testInit() {
        Vector2 a = new Vector2(-1,0);
        Vector2 b = new Vector2(0,1);
        Vector2 c = new Vector2(1,0);

        Triangle2 triangle = new Triangle2(a,b,c);

        Assert.assertEquals(a, triangle.a);
        Assert.assertEquals(b, triangle.b);
        Assert.assertEquals(c, triangle.c);
    }

}
