package com.harium.etyl.geometry;

import com.harium.etyl.geometry.path.SegmentCurve;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Path2DTest {

    @Test
    public void testFlipHorizontal() {
        Path2D path = new Path2D();

        path.add(new SegmentCurve(new Point2D(10, 0), new Point2D(20, 0)));
        path.add(new SegmentCurve(new Point2D(20, 0), new Point2D(30, 10)));

        path.flipHorizontal();

        assertEquals(30, path.getCurves().get(0).getStart().x, 0);
        assertEquals(20, path.getCurves().get(0).getEnd().x, 0);
        assertEquals(20, path.getCurves().get(1).getStart().x, 0);
        assertEquals(10, path.getCurves().get(1).getEnd().x, 0);
    }

    @Test
    public void testFlipVertical() {
        Path2D path = new Path2D();

        path.add(new SegmentCurve(new Point2D(10, 0), new Point2D(20, 0)));
        path.add(new SegmentCurve(new Point2D(20, 0), new Point2D(30, 10)));

        path.flipVertical();

        assertEquals(10, path.getCurves().get(0).getStart().y, 0);
        assertEquals(10, path.getCurves().get(0).getEnd().y, 0);
        assertEquals(10, path.getCurves().get(1).getStart().y, 0);
        assertEquals(0, path.getCurves().get(1).getEnd().y, 0);
    }

    @Test
    public void testCalculateCenter() {
        Path2D path = new Path2D();

        path.add(new SegmentCurve(new Point2D(10, 0), new Point2D(20, 0)));
        path.add(new SegmentCurve(new Point2D(20, 0), new Point2D(30, 10)));

        Point2D centroid = path.calculateCenter();

        assertEquals(20, centroid.x, 0);
        assertEquals(5, centroid.y, 0);
    }

}
