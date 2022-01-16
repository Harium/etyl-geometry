package com.harium.etyl.geometry.path;

import com.harium.etyl.geometry.Point2D;
import com.harium.etyl.geometry.curve.CubicBezier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BezierCurveTest {

    @Test
    public void testInterpolate() {
        double width = 100;
        double height = 100;

        Point2D start = new Point2D(0, height / 2);
        Point2D end = new Point2D(width, height / 2);
        Point2D cp1 = new Point2D(0, 0);
        Point2D cp2 = new Point2D(width, 0);

        CubicBezier curve = new CubicBezier(start, cp1, cp2, end);
        assertEquals(width / 2, curve.x(0.5f), 0);
        assertEquals(12.5f, curve.y(0.5f), 0);
    }

}
