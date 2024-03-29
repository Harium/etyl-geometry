package com.harium.etyl.geometry.collision;

import com.harium.etyl.geometry.math.EtylMath;

public class CollisionDetector {

    private static final float EPSILON = 0;

    public static boolean collideCirclePoint(float cx, float cy, float radius, float px, float py) {
        float dx = cx - px;
        float dy = cy - py;
        float dist = (dx * dx) + (dy * dy);

        if (dist - (radius * radius) <= EPSILON) {
            return true;
        }

        return false;
    }

    public static boolean collideCirclePoint(int cx, int cy, float radius, int px, int py) {
        float dx = cx - px;
        float dy = cy - py;
        float dist = (dx * dx) + (dy * dy);

        if (dist - (radius * radius) <= EPSILON) {
            return true;
        }

        return false;
    }

    public static boolean collideCircleCircle(float cx1, float cy1, float radius1, float cx2, float cy2, float radius2) {
        float dx = cx1 - cx2;
        float dy = cy1 - cy2;
        float radius = radius1 + radius2;
        float dist = (dx * dx) + (dy * dy);

        if (dist - (radius * radius) <= EPSILON) {
            return true;
        }

        return false;
    }

    public static boolean collideCircleCircle(int x, int y, int w, int h, int bx, int by, int bw, int bh) {
        float radius = w / 2;
        float cx = x + radius;
        float cy = y + radius;

        float bRadius = bw / 2;
        float bCx = bx + radius;
        float bCy = by + radius;

        return collideCircleCircle(cx, cy, radius, bCx, bCy, bRadius);
    }

    public static boolean collideCircleRect(int cx, int cy, int radius, int rectX, int rectY, int rectW, int rectH) {

        double circleDistanceX = Math.abs(cx - rectX);
        double circleDistanceY = Math.abs(cy - rectY);

        if (circleDistanceX > (rectW / 2 + radius)) {
            return false;
        }
        if (circleDistanceY > (rectH / 2 + radius)) {
            return false;
        }

        if (circleDistanceX <= (rectW / 2)) {
            return true;
        }
        if (circleDistanceY <= (rectH / 2)) {
            return true;
        }

        double cornerDistance = Math.pow((circleDistanceX - rectW / 2), 2) +
                Math.pow((circleDistanceY - rectH / 2), 2);

        return (cornerDistance <= (radius * radius));
    }

    public static boolean collideIsometricPoint(int x, int y, int w, int h, int px, int py) {
        float mx = w / 2;
        float my = h / 2;

        float ix = px - x;
        float iy = py - y;

        if (iy > my) {
            iy = my - (iy - my);
        }

        if ((ix > mx + 1 + (2 * iy)) || (ix < mx - 1 - (2 * iy))) {
            return false;
        }

        return true;
    }

    //Checks collision with a vertical hexagon
    public static boolean collideHexagonPoint(int x, int y, int w, int h, int px, int py) {
        float mx = w / 4;
        float my = h / 2;

        float hx = px - x;
        float hy = py - y;

        if (hx > mx * 3) {
            hx = mx - (hx - mx * 3);
        } else if (hx > mx) {
            return py >= y && py <= y + h;
        }

        if ((hy > my + 1 + (2 * hx)) || (hy < my - 1 - (2 * hx))) {
            return false;
        }

        return true;
    }

    /**
     * Rectangle To Point.
     */
    public static boolean collideRectPoint(double rectX, double rectY, double rectWidth, double rectHeight, double rectAngle, double pointX, double pointY) {
        double rectCenterX = rectX + rectWidth / 2;
        double rectCenterY = rectY + rectHeight / 2;

        if (rectAngle == 0)  //High speed for rectangles without rotation
            return collideRectPointByCenter(rectWidth, rectHeight, rectCenterX, rectCenterY, pointX, pointY);

        final double cos = Math.cos(rectAngle);
        final double sin = Math.cos(rectAngle);

        double tx = cos * pointX - sin * pointY;
        double ty = cos * pointY + sin * pointX;

        double cx = cos * rectCenterX - sin * rectCenterY;
        double cy = cos * rectCenterY + sin * rectCenterX;

        return collideRectPointByCenter(rectWidth, rectHeight, cx, cy, tx, ty);
    }

    private static boolean collideRectPointByCenter(double rectWidth, double rectHeight, double rectCenterX, double rectCenterY, double pointX, double pointY) {
        return Math.abs(rectCenterX - pointX) < rectWidth / 2 && Math.abs(rectCenterY - pointY) < rectHeight / 2;
    }

    public static boolean collideRectPoint(int x, int y, int w, int h, int pointX, int pointY) {
        return pointX >= x && pointX <= x + w && pointY >= y && pointY <= y + h;
    }

    /**
     * Circle To Segment.
     */
    private static boolean collideCircleLine(double circleCenterX, double circleCenterY, double circleRadius, double lineAX, double lineAY, double lineBX, double lineBY) {
        double lineSize = Math.sqrt(Math.pow(lineAX - lineBX, 2) + Math.pow(lineAY - lineBY, 2));
        double distance;

        if (lineSize == 0) {
            distance = Math.sqrt(Math.pow(circleCenterX - lineAX, 2) + Math.pow(circleCenterY - lineAY, 2));
            return distance < circleRadius;
        }

        double u = ((circleCenterX - lineAX) * (lineBX - lineAX) + (circleCenterY - lineAY) * (lineBY - lineAY)) / (lineSize * lineSize);

        if (u < 0) {
            distance = Math.sqrt(Math.pow(circleCenterX - lineAX, 2) + Math.pow(circleCenterY - lineAY, 2));
        } else if (u > 1) {
            distance = Math.sqrt(Math.pow(circleCenterX - lineBX, 2) + Math.pow(circleCenterY - lineBY, 2));
        } else {
            double ix = lineAX + u * (lineBX - lineAX);
            double iy = lineAY + u * (lineBY - lineAY);
            distance = Math.sqrt(Math.pow(circleCenterX - ix, 2) + Math.pow(circleCenterY - iy, 2));
        }

        return distance < circleRadius;
    }

    /**
     * Rectangle To Circle.
     */
    public static boolean collideRectCircle(double rectWidth, double rectHeight, double rectRotation, double rectCenterX, double rectCenterY, double circleCenterX, double circleCenterY, double circleRadius) {
        double tx, ty, cx, cy;

        if (rectRotation == 0) { //High speed for rectangles without rotation
            tx = circleCenterX;
            ty = circleCenterY;

            cx = rectCenterX;
            cy = rectCenterY;
        } else {
            tx = Math.cos(rectRotation) * circleCenterX - Math.sin(rectRotation) * circleCenterY;
            ty = Math.cos(rectRotation) * circleCenterY + Math.sin(rectRotation) * circleCenterX;

            cx = Math.cos(rectRotation) * rectCenterX - Math.sin(rectRotation) * rectCenterY;
            cy = Math.cos(rectRotation) * rectCenterY + Math.sin(rectRotation) * rectCenterX;
        }

        return collideRectPoint(rectWidth, rectHeight, rectRotation, rectCenterX, rectCenterY, circleCenterX, circleCenterY) ||
                collideCircleLine(tx, ty, circleRadius, cx - rectWidth / 2, cy + rectHeight / 2, cx + rectWidth / 2, cy + rectHeight / 2) ||
                collideCircleLine(tx, ty, circleRadius, cx + rectWidth / 2, cy + rectHeight / 2, cx + rectWidth / 2, cy - rectHeight / 2) ||
                collideCircleLine(tx, ty, circleRadius, cx + rectWidth / 2, cy - rectHeight / 2, cx - rectWidth / 2, cy - rectHeight / 2) ||
                collideCircleLine(tx, ty, circleRadius, cx - rectWidth / 2, cy - rectHeight / 2, cx - rectWidth / 2, cy + rectHeight / 2);
    }

    /**
     * Code found at: http://stackoverflow.com/a/21647567
     */
    public static boolean collidePolygon(int ax, int ay, int aw, int ah, double angle, int bx, int by, int bw, int bh, double bAngle) {
        Vector[] pointsA = getBounds(ax, ay, aw, ah, angle);
        Vector[] pointsB = getBounds(bx, by, bw, bh, bAngle);

        return collidePoints(pointsA, pointsB);
    }

    public static Vector[] getBounds(int ax, int ay, int aw, int ah, double angle) {
        int originX = aw / 2;
        int originY = ah / 2;

        return getBounds(ax, ay, aw, ah, originX, originY, angle);
    }

    public static Vector[] getBounds(int ax, int ay, int aw, int ah, int originX, int originY, double angle) {
        Vector[] points = new Vector[4];

        points[0] = new Vector(ax, ay);
        points[1] = new Vector(ax + aw, ay);
        points[2] = new Vector(ax + aw, ay + ah);
        points[3] = new Vector(ax, ay + ah);

        if (angle != 0) {
            for (Vector point : points) {
                point.rotate(ax + originX, ay + originY, angle);
            }
        }

        return points;
    }

    private static double[] e2p(double x, double y) {
        return new double[]{x, y, 1};
    }

    // standard vector maths
    private static double[] getCrossProduct(double[] u, double[] v) {
        return new double[]{u[1] * v[2] - u[2] * v[1],
                u[2] * v[0] - u[0] * v[2], u[0] * v[1] - u[1] * v[0]};
    }

    private static double getDotProduct(double[] u, double[] v) {
        return u[0] * v[0] + u[1] * v[1] + u[2] * v[2];
    }

    // collision check
    public static boolean collidePoints(Vector[] pointsA, Vector[] pointsB) {
        return !(isSeparate(pointsA, pointsB) || isSeparate(pointsB, pointsA));
    }

    // the following implementation expects the convex polygon's vertices to be in counter clockwise order
    private static boolean isSeparate(Vector[] coordsA, Vector[] coordsB) {
        edges:
        for (int i = 0; i < coordsA.length; i++) {

            double[] u = e2p(coordsA[i].x, coordsA[i].y);
            int ni = i + 1 < coordsA.length ? i + 1 : 0;
            double[] v = e2p(coordsA[ni].x, coordsA[ni].y);
            double[] pedge = getCrossProduct(u, v);

            for (Vector p : coordsB) {
                double d = getDotProduct(pedge, e2p(p.x, p.y));
                if (d > -0.001) {
                    continue edges;
                }
            }
            return true;
        }

        return false;
    }

    public static boolean collideEllipsePoint(double cx, double cy, double angle, double a, double b, double px, double py) {

        final double cos = Math.cos(angle);
        final double sin = Math.sin(angle);

        double p = EtylMath.sqr(cos * (px - cx) + sin * (py - cy)) / (a * a);
        double q = EtylMath.sqr(sin * (px - cx) - cos * (py - cy)) / (b * b);

        return (p + q <= 1);
    }

    public static boolean collideRectRect(int x, int y, int w, int h, int bx, int by, int bw, int bh) {
        if (bx + bw < x) return false;
        if (bx > x + w) return false;

        if (by + bh < y) return false;
        if (by > y + h) return false;

        return true;
    }

    static class Vector {
        float x;
        float y;

        public Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void rotate(double cx, double cy, double degreeAngle) {
            double angle = Math.toRadians(degreeAngle);
            double nx = cx + (x - cx) * Math.cos(angle) - (y - cy) * Math.sin(angle);
            double ny = cy + (x - cx) * Math.sin(angle) + (y - cy) * Math.cos(angle);

            x = (float) nx;
            y = (float) ny;
        }
    }
}
