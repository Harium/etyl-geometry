package com.harium.etyl.geometry.collision;

import org.junit.Assert;
import org.junit.Test;

public class CollisionDetectorTest {

    @Test
    public void collideCirclePoint() {
        int cx = 32;
        int cy = 32;
        int radius = 32;

        Assert.assertTrue(CollisionDetector.collideCirclePoint(cx, cy, radius, 20, 32));
        Assert.assertTrue(CollisionDetector.collideCirclePoint(cx, cy, radius, 32, 20));

        Assert.assertFalse(CollisionDetector.collideCirclePoint(cx, cy, radius, 2, 2));
    }

    @Test
    public void collideCircleCircle() {
        int cx = 0;
        int cy = 0;
        int radius = 10;

        int bCx = 10;
        int bCy = 0;
        int bRadius = 10;

        Assert.assertTrue(CollisionDetector.collideCircleCircle(cx, cy, radius, bCx, bCy, bRadius));
        Assert.assertFalse(CollisionDetector.collideCircleCircle(cx, cy, radius, bCx + 20.1f, bCy, bRadius));
    }

}
