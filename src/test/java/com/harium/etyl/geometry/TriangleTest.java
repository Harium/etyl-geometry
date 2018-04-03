package com.harium.etyl.geometry;

import com.badlogic.gdx.math.Vector3;
import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void testInit() {
        Vector3 a = new Vector3(-1,0,0);
        Vector3 b = new Vector3(0,1,0);
        Vector3 c = new Vector3(1,0,0);

        Triangle triangle = new Triangle(a,b,c);

        Assert.assertEquals(a, triangle.a);
        Assert.assertEquals(b, triangle.b);
        Assert.assertEquals(c, triangle.c);
    }

    @Test
    public void testEquals() {
        Vector3 a = new Vector3(1,1,1);
        Vector3 b = new Vector3(2,2,1);
        Vector3 c = new Vector3(2,2,2);

        Triangle t1 = new Triangle(a, b, c);
        Triangle t2 = new Triangle(a, b, c);

        Assert.assertTrue(t1.equals(t2));
    }

}
