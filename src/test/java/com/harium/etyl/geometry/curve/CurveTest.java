package com.harium.etyl.geometry.curve;

import com.harium.etyl.geometry.Point2D;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CurveTest {

    Curve curve;

    @Before
    public void setUp() {
        curve = new Curve(new Point2D(0, 20), new Point2D(10, 20));
    }

    @Test
    public void testX() {
        Assert.assertEquals(curve.p0.x, curve.x(0), 0);
        Assert.assertEquals(curve.p1.x, curve.x(1), 0);
        Assert.assertEquals((curve.p0.x + curve.p1.x) / 2, curve.x(0.5f), 0);
    }

    @Test
    public void testY() {
        Assert.assertEquals(curve.p0.y, curve.y(0), 0);
        Assert.assertEquals(curve.p1.y, curve.y(1), 0);
        Assert.assertEquals((curve.p0.y + curve.p1.y) / 2, curve.y(0.5f), 0);
    }

    @Test
    public void testFlattenCurve() {
        Point2D[] coordinates = curve.flattenCurve(1);
        Assert.assertEquals(2, coordinates.length);
    }

}
