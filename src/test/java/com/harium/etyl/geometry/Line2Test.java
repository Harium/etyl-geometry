package com.harium.etyl.geometry;

import com.badlogic.gdx.math.Vector2;
import org.junit.Assert;
import org.junit.Test;

public class Line2Test {
	
	@Test
	public void testInterpolate() {
		Vector2 p1 = new Vector2(0, 0);

		Vector2 p2 = new Vector2(3, 6);
		
		int size = 4;

		Vector2[] points = Line2.interpolate(p1, p2, size);
		
		Assert.assertEquals(size, points.length);
		
		Assert.assertEquals(0, points[0].x, 0);
		Assert.assertEquals(1, points[1].x, 0);
		Assert.assertEquals(2, points[2].x, 0);
		Assert.assertEquals(3, points[3].x, 0);
		
		Assert.assertEquals(0, points[0].y, 0);
		Assert.assertEquals(2, points[1].y, 0);
		Assert.assertEquals(4, points[2].y, 0);
		Assert.assertEquals(6, points[3].y, 0);
		
	}
	
	@Test
	public void testIntersection() {

		Vector2 p1 = new Vector2(0, 0);
		Vector2 p2 = new Vector2(4, 4);

		Vector2 p3 = new Vector2(4, 0);
		Vector2 p4 = new Vector2(0, 4);
		
		Vector2 point = Line2.intersection(p1, p2, p3, p4);
				
		Assert.assertEquals(2, point.x, 0);
		Assert.assertEquals(2, point.y, 0);
		
	}
	
}
