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
        Assert.assertEquals(1, coordinates.length);
    }

    @Test
    public void testFlattenCurve_FlattenBezierHorizontal() {
        float width = 100;
        float height = 100;

        Point2D start = new Point2D(0, height / 2);
        Point2D end = new Point2D(width, height / 2);

        curve = new CubicBezier(start,
                                end,
                                new Point2D(0, 0),
                                new Point2D(width, 0));

        Point2D[] coordinates = curve.flattenCurve(3);

        Assert.assertEquals(start.x, coordinates[0].x, 0);
        Assert.assertEquals(start.y, coordinates[0].y, 0);

        Assert.assertEquals(width / 2, coordinates[1].x, 0);
        Assert.assertEquals(height / 4, coordinates[1].y, 0);

        Assert.assertEquals(end.x, coordinates[2].x, 0);
        Assert.assertEquals(end.y, coordinates[2].y, 0);

        Assert.assertEquals(3, coordinates.length);
    }

    @Test
    public void testFlattenCurve_FlattenBezierVertical() {
        float width = 100;
        float height = 100;

        Point2D start = new Point2D(width / 2, 0);
        Point2D end = new Point2D(width / 2, height);

        curve = new CubicBezier(start,
                                end,
                                new Point2D(width, 0),
                                new Point2D(width, height));

        Point2D[] coordinates = curve.flattenCurve(3);

        Assert.assertEquals(start.x, coordinates[0].x, 0);
        Assert.assertEquals(start.y, coordinates[0].y, 0);

        Assert.assertEquals(width * (3 / 4f), coordinates[1].x, 0);
        Assert.assertEquals(height / 2, coordinates[1].y, 0);

        Assert.assertEquals(end.x, coordinates[2].x, 0);
        Assert.assertEquals(end.y, coordinates[2].y, 0);

        Assert.assertEquals(3, coordinates.length);
    }

}
