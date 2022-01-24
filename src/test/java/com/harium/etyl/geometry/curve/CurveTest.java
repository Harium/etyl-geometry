package com.harium.etyl.geometry.curve;

import com.harium.etyl.geometry.Point2D;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CurveTest {

    Curve curve;

    @Before
    public void setUp() {
        curve = new Curve(new Point2D(0, 20), new Point2D(10, 20));
    }

    @Test
    public void testInterpolateX() {
        assertEquals(curve.p0.x, curve.x(0), 0);
        assertEquals(curve.p1.x, curve.x(1), 0);
        assertEquals((curve.p0.x + curve.p1.x) / 2, curve.x(0.5f), 0);
    }

    @Test
    public void testInterpolateY() {
        assertEquals(curve.p0.y, curve.y(0), 0);
        assertEquals(curve.p1.y, curve.y(1), 0);
        assertEquals((curve.p0.y + curve.p1.y) / 2, curve.y(0.5f), 0);
    }

    @Test
    public void testTranslate() {
        curve.translate(10,20);

        // Test translate
        assertEquals(10, curve.p0.x, 0);
        assertEquals(40, curve.p0.y, 0);

        assertEquals(20, curve.p1.x, 0);
        assertEquals(40, curve.p1.y, 0);
    }

    @Test
    public void testFlattenCurve() {
        Point2D[] coordinates = curve.flattenCurve(1);
        assertEquals(1, coordinates.length);
    }

    @Test
    public void testFlattenCurve_FlattenBezierHorizontal() {
        float width = 100;
        float height = 100;

        Point2D start = new Point2D(0, height / 2);
        Point2D end = new Point2D(width, height / 2);

        curve = new CubicBezier(start,
                                new Point2D(0, 0),
                                new Point2D(width, 0),
                                end);

        Point2D[] coordinates = curve.flattenCurve(3);
        assertEquals(3, coordinates.length);

        assertEquals(start.x, coordinates[0].x, 0);
        assertEquals(start.y, coordinates[0].y, 0);

        assertEquals(width / 2, coordinates[1].x, 0);
        assertEquals(height / 8, coordinates[1].y, 0);

        assertEquals(end.x, coordinates[2].x, 0);
        assertEquals(end.y, coordinates[2].y, 0);
    }

    @Test
    public void testFlattenCurve_FlattenBezierVertical() {
        float width = 100;
        float height = 100;

        Point2D start = new Point2D(width / 2, 0);
        Point2D end = new Point2D(width / 2, height);

        curve = new CubicBezier(start,
                                new Point2D(width, 0),
                                new Point2D(width, height),
                                end);

        Point2D[] coordinates = curve.flattenCurve(3);

        assertEquals(3, coordinates.length);

        assertEquals(start.x, coordinates[0].x, 0);
        assertEquals(start.y, coordinates[0].y, 0);

        assertEquals(width * (7 / 8f), coordinates[1].x, 0);
        assertEquals(height / 2, coordinates[1].y, 0);

        assertEquals(end.x, coordinates[2].x, 0);
        assertEquals(end.y, coordinates[2].y, 0);
    }

}
