package com.harium.etyl.geometry;

import com.badlogic.gdx.math.Vector3;

/**
 * Created by IntelliJ IDEA.
 * User: Aviad Segev
 * Date: 22/11/2009
 * Time: 20:29:56
 * BoundingBox represents a horizontal bounding rectangle defined by its lower left
 * and upper right point. This is usually used as a rough approximation of the
 * bounded geometry
 */
public class BoundingBox {
    /**
     * the minimum x-coordinate
     */
    private float minx;

    /**
     * the maximum x-coordinate
     */
    private float maxx;

    /**
     * the minimum y-coordinate
     */
    private float miny;

    /**
     * the maximum y-coordinate
     */
    private float maxy;

    /**
     * the minimum z-coordinate
     */
    private float minz;

    /**
     * the maximum z-coordinate
     */
    private float maxz;

    /**
     * Creates an empty  bounding box
     */
    public BoundingBox() {
        setToNull();
    }

    /**
     * Copy constructor
     *
     * @param other the copied bounding box
     */
    public BoundingBox(BoundingBox other) {
        if (other.isNull())
            setToNull();
        else
            init(other.minx, other.maxx, other.miny, other.maxy, other.minz, other.maxz);
    }

    /**
     * Creates a bounding box given the extent
     *
     * @param minx minimum x coordinate
     * @param maxx maximum x coordinate
     * @param miny minimum y coordinate
     * @param maxy maximum y coordinate
     * @param minz minimum z coordinate
     * @param maxz maximum z coordinate
     */
    public BoundingBox(float minx, float maxx, float miny, float maxy, float minz, float maxz) {
        init(minx, maxx, miny, maxy, minz, maxz);
    }

    /**
     * Create a bounding box between lowerLeft and upperRight
     *
     * @param lowerLeft  lower left point of the box
     * @param upperRight upper left point of the box
     */
    public BoundingBox(Vector3 lowerLeft, Vector3 upperRight) {
        init(lowerLeft.x, upperRight.x, lowerLeft.y, upperRight.y, lowerLeft.z, upperRight.z);
    }

    /**
     * Initialize a BoundingBox for a region defined by maximum and minimum values.
     *
     * @param x1 the first x-value
     * @param x2 the second x-value
     * @param y1 the first y-value
     * @param y2 the second y-value
     * @param z1 the first z-value
     * @param z2 the second z-value
     */
    private void init(float x1, float x2, float y1, float y2, float z1, float z2) {
        if (x1 < x2) {
            minx = x1;
            maxx = x2;
        } else {
            minx = x2;
            maxx = x1;
        }
        if (y1 < y2) {
            miny = y1;
            maxy = y2;
        } else {
            miny = y2;
            maxy = y1;
        }
        if (z1 < z2) {
            minz = z1;
            maxz = z2;
        } else {
            minz = z2;
            maxz = z1;
        }
    }

    /**
     * Makes this BoundingBox a "null" envelope, that is, the envelope
     * of the empty geometry.
     */
    private void setToNull() {
        minx = 0;
        maxx = -1;
        miny = 0;
        maxy = -1;
        minz = 0;
        maxz = -1;
    }

    /**
     * Returns true if this BoundingBox is a "null"
     * envelope.
     *
     * @return true if this BoundingBox is uninitialized
     * or is the envelope of the empty geometry.
     */
    public boolean isNull() {
        return maxx < minx;
    }

    /**
     * Tests if the other BoundingBox lies wholely inside this BoundingBox
     *
     * @param other the BoundingBox to check
     * @return true if this BoundingBox contains the other BoundingBox
     */
    public boolean contains(BoundingBox other) {
        return !(isNull() || other.isNull()) &&
                other.minx >= minx &&
                other.maxy <= maxx &&
                other.miny >= miny &&
                other.maxy <= maxy &&
                other.minz >= minz &&
                other.maxz <= maxz;
    }

    /**
     * Unify the BoundingBoxes of this and the other BoundingBox
     *
     * @param other another BoundingBox
     * @return The union of the two BoundingBoxes
     */
    public BoundingBox unionWith(BoundingBox other) {
        if (other.isNull()) {
            return new BoundingBox(this);
        }
        if (isNull()) {
            return new BoundingBox(other);
        } else {
            return new BoundingBox(
                    Math.min(minx, other.minx),
                    Math.max(maxx, other.maxx),
                    Math.min(miny, other.miny),
                    Math.max(maxy, other.maxy),
                    Math.min(minz, other.minz),
                    Math.max(maxz, other.maxz));
        }
    }

    /**
     * @return Minimum x value
     */
    public float minX() {
        return minx;
    }

    /**
     * @return Minimum y value
     */
    public float minY() {
        return miny;
    }

    /**
     * @return Minimum y value
     */
    public float minZ() {
        return minz;
    }

    /**
     * @return Maximum x value
     */
    public float maxX() {
        return maxx;
    }

    /**
     * @return Maximum y value
     */
    public float maxY() {
        return maxy;
    }

    /**
     * @return Maximum z value
     */
    public float maxZ() {
        return maxz;
    }

    /**
     * @return Width of the bounding box
     */
    public float getWidth() {
        return maxx - minx;
    }

    /**
     * @return Height of the bounding box
     */
    public float getHeight() {
        return maxy - miny;
    }

    /**
     * @return Maximum coordinate of bounding box
     */
    public Point3D getMinPoint() {
        return new Point3D(minx, miny, minz);
    }

    /**
     * @return Minimum coordinate of bounding box
     */
    public Point3D getMaxPoint() {
        return new Point3D(maxx, maxy, maxz);
    }
}