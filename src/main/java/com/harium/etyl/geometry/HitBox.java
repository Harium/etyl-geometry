package com.harium.etyl.geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author yuripourre
 *
 */

public class HitBox {

	// It should be a QuadTree
	private List<Rectangle> areas = new ArrayList<Rectangle>();
	
	public HitBox() {
		super();
	}

	public List<Rectangle> getAreas() {
		return areas;
	}

	public void setAreas(List<Rectangle> area) {
		this.areas = area;
	}

}
